package com.davidcortijo.wod.wodjournal.repository

import com.davidcortijo.wod.wodjournal.beans.Exercise
import org.springframework.data.mongodb.repository.MongoRepository

interface ExercisesRepository extends MongoRepository<Exercise, String> {

    Exercise findByName(String name)
    //List<Exercise> findByName(String name)

    List<Exercise> findByType(String type)

    /* //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain); */
}