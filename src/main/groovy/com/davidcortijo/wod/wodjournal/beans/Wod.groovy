package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "wod")
class Wod {

    @Id
    String Id

    @Indexed(unique = false)
    String name

    Date date

    @DBRef
    List<Movement> exercises

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

}

