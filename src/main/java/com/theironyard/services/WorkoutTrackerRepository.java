package com.theironyard.services;

import com.theironyard.entities.Workout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hoseasandstrom on 6/26/16.
 */
public interface WorkoutTrackerRepository extends CrudRepository<Workout, Integer> {
    public Iterable<Workout> findByWorkoutname(String workoutname);
    public Iterable<Workout> findByMovement(String movement);
    public Iterable<Workout> findByLocation(String location);
    public Iterable<Workout> findByRatingGreaterThanEqual(int rating);



    @Query("SELECT w FROM Workout w WHERE w.note LIKE ?1%")
    public Iterable<Workout> searchNote(String note);

}
