package com.davidcortijo.wod.wodjournal.routes

import com.davidcortijo.wod.wodjournal.beans.Movement
import com.davidcortijo.wod.wodjournal.repository.MovementsRepository
import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.model.dataformat.BindyType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
public class MovementsLoader extends RouteBuilder {

    @Autowired
    MovementsRepository mrepository

    @Override
    public void configure() throws Exception {
        //from("timer:foo")
                //.to("log:checking for new CSV file entries")
        from("file:etl/csvfiles")//?runLoggingLevel=INFO
        .log("Looking at: ${simple('${headers.CamelFileAbsolutePath}')}")
        .log("File content is: ${simple('${body}')}")
        .unmarshal()
        .bindy(BindyType.Csv, com.davidcortijo.wod.wodjournal.beans.Movement.class)
        .split(body())
        //.to("log:bar")
        .log("${simple('${body}')}")
        .process {
            println it.in.body
            Movement m = it.in.getBody(Movement.class)
            println "Movement name is: ${m.name}"
            println "Movement type is: ${m.type}"
            mrepository.save(m)

            // fetch a list of Gymnastic Movements
            println("Movement found with findByType('Floor'):")
            println "-------------------------------"
            for (Movement exercise : mrepository.findByType("Floor")) {
                println exercise.name
            }
        }
    }

}