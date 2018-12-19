package com.davidcortijo.wod.wodjournal.repository

import org.springframework.data.mongodb.repository.MongoRepository

interface ExerciseRepository extends MongoRepository<Exercise, String> {

    public Exercise findByName(String name)
    public List<Exercise> findByName(String name)

    public Exercise findByType(String type)

    /* //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain); */
}