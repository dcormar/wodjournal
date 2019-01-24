package com.davidcortijo.wod.wodjournal.routes

import com.davidcortijo.wod.wodjournal.beans.Wod
import com.davidcortijo.wod.wodjournal.repository.WodsRepository
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.model.dataformat.BindyType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
public class WodsLoader extends RouteBuilder {

    @Autowired
    WodsRepository wrepository

    @Override
    public void configure() throws Exception {
        from("file:etl/csvfiles/wods?noop=true&idempotent=true")//?runLoggingLevel=INFO
        //.log("Looking at: ${simple('${headers.CamelFileAbsolutePath}')}")
        //.log("File content is: ${simple('${body}')}")
        .unmarshal()
        .bindy(BindyType.Csv, com.davidcortijo.wod.wodjournal.beans.Wod.class)
        .split(body())
        .log("${simple('${body}')}")
        .process {
            Wod w = it.in.getBody(Wod.class)
            wrepository.save(w)
        }
    }

}