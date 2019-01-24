package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document

import org.apache.camel.dataformat.bindy.annotation.CsvRecord
import org.apache.camel.dataformat.bindy.annotation.DataField

@CsvRecord(separator = "\\|", crlf = "UNIX")
@Document(collection = "movement")
class Movement {

    @Id
    String Id

    //@Indexed(unique = true)
    @DataField(pos = 1)
    String name
    @DataField(pos = 2)
    String altName //for reduced names, like "Toes to bar" = T2B
    @DataField(pos = 3)
    String type
    @DataField(pos = 4)
    String desc
    @DataField(pos = 5)
    String tuto //URL with (youtube) video tutorial
    @DataField(pos = 6)
    String level //difficulty level

    Movement () {
        //default constructor
    }

    Movement (def name, def type) {
        this.name = name
        this.type = type
    }
    @PersistenceConstructor
    Movement (def name, def type, def desc, def tuto, def level) {
        this.name = name
        this.type = type
        this.desc = desc
        this.tuto = tuto
        this.level = level
    }

    String toString () {
        return """[Id: ${this.id}
                    name: "${this.name}"
                    altName: "${this.altName}"
                    type: ${this.type}
                    desc: "${this.desc}"
                    tuto: "${this.tuto}"
                    level: "${this.level}"]"""
    }

}

