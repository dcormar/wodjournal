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
        from("file:etl/csvfiles/movements?noop=true&idempotent=true")//?runLoggingLevel=INFO
        //.log("Looking at: ${simple('${headers.CamelFileAbsolutePath}')}")
        //.log("File content is: ${simple('${body}')}")
        .unmarshal()
        .bindy(BindyType.Csv, com.davidcortijo.wod.wodjournal.beans.Movement.class)
        .split(body())
        .log("${simple('${body}')}")
        .process {
            Movement m = it.in.getBody(Movement.class)
            mrepository.save(m)
        }
    }

}