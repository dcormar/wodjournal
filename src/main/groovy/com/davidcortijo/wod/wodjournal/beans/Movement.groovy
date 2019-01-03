package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document

import org.apache.camel.dataformat.bindy.annotation.CsvRecord
import org.apache.camel.dataformat.bindy.annotation.DataField

@CsvRecord(separator = ",", crlf = "UNIX")
@Document(collection = "movement")
class Movement {

    @Id
    String Id

    //@Indexed(unique = true)
    @DataField(pos = 1)
    String name

    String altName //for reduced names, like "Toes to bar" = T2B
    @DataField(pos = 2)
    String type
    String desc
    String prime
    String level

    Movement () {

    }

    Movement (def name, def type) {
        this.name = name
        this.type = type
    }
    @PersistenceConstructor
    Movement (def name, def type, def desc, def prime, def level) {
        this.name = name
        this.type = type
        this.desc = desc
        this.prime = prime
        this.level = level
    }

    String toString () {
        return """[Id: ${this.id}
                    name: "${this.name}"
                    altName: "${this.altName}"
                    type: ${this.type}
                    desc: "${this.desc}"
                    prime: "${this.prime}"
                    level: "${this.level}"]"""
    }

}

