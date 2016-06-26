package com.theironyard;

import javax.persistence.*;

/**
 * Created by hoseasandstrom on 6/26/16.
 */
@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String reps;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    int rating;

    public Movement() {
    }

    public Movement(String name, String reps, String location, int rating) {
        this.name = name;
        this.reps = reps;
        this.location = location;
        this.rating = rating;
    }
}
