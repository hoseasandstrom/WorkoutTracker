package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hoseasandstrom on 6/26/16.
 */
public interface WorkoutTrackerRepository extends CrudRepository<Movement, Integer> {

}
