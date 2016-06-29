package com.theironyard.entities;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by hoseasandstrom on 6/26/16.
 */
@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String workoutname;

    @Column(nullable = false)
    String movement;

    @Column(nullable = false)
    String reps;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    int rating;

    @Column(nullable = false)
    String note;

    @Column(nullable = false)
    LocalDateTime date;

    @ManyToOne
    User user;


    public Workout() {
    }

    public Workout(String workoutname, String movement, String reps, String location, int rating, String note) {
        this.workoutname = workoutname;
        this.movement = movement;
        this.reps = reps;
        this.location = location;
        this.rating = rating;
        this.note = note;
    }

    public Workout(String workoutname, String movement, String reps, String location, int rating, String note, LocalDateTime date) {
        this.workoutname = workoutname;
        this.movement = movement;
        this.reps = reps;
        this.location = location;
        this.rating = rating;
        this.note = note;
        this.date = date;
    }

    public Workout(String workoutname, String movement, String reps, String location, int rating, String note, LocalDateTime date, User user) {
        this.workoutname = workoutname;
        this.movement = movement;
        this.reps = reps;
        this.location = location;
        this.rating = rating;
        this.note = note;
        this.date = date;
        this.user = user;
    }

    public Workout(int id, String workoutname, String movement, String reps, String location, int rating, String note, LocalDateTime date) {
        this.id = id;
        this.workoutname = workoutname;
        this.movement = movement;
        this.reps = reps;
        this.location = location;
        this.rating = rating;
        this.note = note;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    public void setWorkoutname(String workoutname) {
        this.workoutname = workoutname;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
