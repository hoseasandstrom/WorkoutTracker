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
    String deadlift;

    @Column(nullable = false)
    String backsquat;

    @Column(nullable = false)
    String shoulderpress;

    @Column(nullable = false)
    int rating;

    public Movement() {
    }

    public Movement(String deadlift, String backsquat, String shoulderpress, int rating) {
        this.deadlift = deadlift;
        this.backsquat = backsquat;
        this.shoulderpress = shoulderpress;
        this.rating = rating;
    }
}
