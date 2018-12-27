package com.davidcortijo.wod.wodjournal.repository

import com.davidcortijo.wod.wodjournal.beans.Wod
import org.springframework.data.mongodb.repository.MongoRepository

interface WodRepository extends MongoRepository<Wod, String> {

    Wod findByName(String name)

    Wod findByDate(Date date)

    /* //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain); */
}
