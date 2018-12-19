package com.davidcortijo.wod.wodjournal.beans

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "exercise")
class Exercise {
    @Id
    String Id

    @Indexed(unique = true)
    String name

    String type
    String desc
    String prime
    String level

    public Exercise () {

    }

    public Exercise (def name, def type) {
            this.name = name
            this.type = type
    }

    public Exercise (def name, def type, def desc, def prime, def level) {
        this.name = name
        this.type = type
        this.desc = desc
        this.prime = prime
        this.level = level
    }

}
