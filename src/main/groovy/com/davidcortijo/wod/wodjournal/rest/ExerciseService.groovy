package com.davidcortijo.wod.wodjournal.rest

import com.davidcortijo.wod.wodjournal.beans.Exercise
import com.davidcortijo.wod.wodjournal.repository.ExercisesRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/exercise")
class ExerciseService {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseService.class)

    @Autowired
    private ExercisesRepository repository

    ExerciseService () {
        logger.debug("Created Spring MVC REST resource ExerciseService")
    }

    @GetMapping(value="/details/{name}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    Exercise getExerciseDetails (@PathVariable String name) {
        logger.debug("Exercise Request received for resource 'list'")
        return repository.findByName(name)
    }

    @GetMapping(value="/list/{type}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List <Exercise> allExercisesByType (@PathVariable String type) {
        logger.debug("Exercise Request received for resource 'list'")
        return repository.findByType(type)
    }

    @PostMapping("/save")
    Exercise newExercise (@RequestBody Exercise newExercise) {
        logger.debug("Exercise Request received for resource 'save'")
        return repository.save(newExercise)
    }
}