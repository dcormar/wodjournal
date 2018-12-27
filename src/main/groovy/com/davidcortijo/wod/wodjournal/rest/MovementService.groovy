package com.davidcortijo.wod.wodjournal.rest

import com.davidcortijo.wod.wodjournal.beans.Movement
import com.davidcortijo.wod.wodjournal.repository.MovementsRepository

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
@RequestMapping("/movement")
class MovementService {
    private static final Logger logger = LoggerFactory.getLogger(MovementService.class)

    @Autowired
    private MovementsRepository repository

    MovementService () {
        logger.debug("Created Spring MVC REST resource MovementService")
    }

    @GetMapping(value="/details/{name}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    Movement getExerciseDetails (@PathVariable String name) {
        logger.debug("Movement Request received for resource 'list'")
        return repository.findByName(name)
    }

    @GetMapping(value="/list/{type}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List <Movement> allMovementsByType (@PathVariable String type) {
        logger.debug("Movement Request received for resource 'list'")
        return repository.findByType(type)
    }

    @PostMapping("/save")
    Exercise newMovement (@RequestBody Movement newMovement) {
        logger.debug("Movement Request received for resource 'save'")
        return repository.save(newMovement)
    }
}