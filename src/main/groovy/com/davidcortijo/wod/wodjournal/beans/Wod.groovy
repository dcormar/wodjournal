package com.davidcortijo.wod.wodjournal.beans

import org.apache.camel.dataformat.bindy.annotation.CsvRecord
import org.apache.camel.dataformat.bindy.annotation.DataField
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@CsvRecord(separator = "\\|", crlf = "UNIX")
@Document(collection = "wod")
class Wod {

    @Id
    String Id

    @Indexed(unique = false)
    @DataField(pos = 1)
    String name

    @DataField(pos = 2, pattern="dd/mm/yyyy")
    Date date


    List<Exercise> exercises

    @DataField(pos = 3)
    String type //AMRAP, EMOM, For Time...
    @DataField(pos = 4)
    String special //for "girls", "hero", "chipper" etc
    @DataField(pos = 5)
    String desc
    @DataField(pos = 6)
    String level

    Wod () {
        //default constructor
    }

    Wod (def name, def type, def date, def exercises) {
        this(name, type, date, exercises, null, null, null)
    }
    @PersistenceConstructor
    Wod (def name, def type, def date, def exercises, def desc, def special, def level) {
        this.name = name ?: "wod ${new Date().format( 'dd/MM/YYYY' )}"
        this.type = name ?: "standard"
        this.date = date ?: new Date().clearTime()
        this.exercises = exercises
        this.desc = desc
        this.special = special
        this.level = level
    }

    String toString () {
        return """[Id: ${this.id}
                    name: "${this.name}"
                    date: "${this.date}"
                    exercises: {${this.exercises.each {x -> x.toString()}}}
                    type: "${this.type}"
                    desc: "${this.desc}"
                    special: "${this.special}"
                    level: "${this.level}"]"""
    }

}

