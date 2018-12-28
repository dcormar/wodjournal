package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.mongodb.core.mapping.DBRef

class Exercise {

    Movement movement

    int reps
    String weight //Kg-% for men/women. Example: 50/35, or 60% RM

    Exercise () {

    }

    Exercise (def name, int reps) {
            this.name = name
            this.reps = reps
    }

}
