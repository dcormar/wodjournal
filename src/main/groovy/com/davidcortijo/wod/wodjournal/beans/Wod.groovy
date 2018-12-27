package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.annotation.Id
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

    public Exercise () {

    }

    wod (def name, def type) {
        wod(name, type, null, null, null)
    }

    wod (def name, def type, def exercises, def desc, def level) {
        this.name = name ?: "wod ${new Date().format( 'dd/MM/YYYY' )}"
        this.type = name ?: "standard"
        this.exercises = exercises
        this.desc = desc
        this.level = level
    }

}

