package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.mongodb.core.mapping.DBRef

class Exercise {


    @DBRef
    Movement movement

    int reps
    String weight //Kg-% for men/women. Example: 50/35, or 60% RM

    Exercise () {

    }

    Exercise (def movement, int reps, def weight) {
        this.movement = movement
        this.reps = reps
        this.weight = weight
    }

    String toString () {
        return """[movement: ${this.movement.toString()}
                    reps: "${this.reps}"
                    weight: "${this.weight}"]"""
    }

}
