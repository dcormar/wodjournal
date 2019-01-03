package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "wod")
class Wod {

    @Id
    String Id

    @Indexed(unique = false)
    String name

    Date date


    List<Exercise> exercises

    String type //for "girls", "hero", "chipper" etc
    String desc
    String level


    Wod (def name, def type, def date, def exercises) {
        this(name, type, date, exercises, null, null)
    }
    @PersistenceConstructor
    Wod (def name, def type, def date, def exercises, def desc, def level) {
        this.name = name ?: "wod ${new Date().format( 'dd/MM/YYYY' )}"
        this.type = name ?: "standard"
        this.date = date ?: new Date().clearTime()
        this.exercises = exercises
        this.desc = desc
        this.level = level
    }

    String toString () {
        return """[Id: ${this.id}
                    name: "${this.name}"
                    date: "${this.date}"
                    exercises: {${this.exercises.each {x -> x.toString()}}}
                    type: "${this.type}"
                    desc: "${this.desc}"
                    level: "${this.level}"]"""
    }

}

