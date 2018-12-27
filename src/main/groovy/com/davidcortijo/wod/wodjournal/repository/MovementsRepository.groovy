package com.davidcortijo.wod.wodjournal.repository

import com.davidcortijo.wod.wodjournal.beans.Movement
import org.springframework.data.mongodb.repository.MongoRepository

interface MovementsRepository extends MongoRepository<Movement, String> {

    Movement findByName(String name)
    //List<Movement> findByName(String name)

    List<Movement> findByType(String type)

    /* //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain); */
}