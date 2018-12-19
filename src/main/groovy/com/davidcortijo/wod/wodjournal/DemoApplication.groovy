package com.davidcortijo.wod.wodjournal

import com.davidcortijo.wod.wodjournal.repository.ExercisesRepository
import com.davidcortijo.wod.wodjournal.beans.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DemoApplication implements CommandLineRunner{

	@Autowired
    ExercisesRepository repository

	static main(args) {
		SpringApplication.run (DemoApplication, args)
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll()

		// save a couple of exercises
		repository.save(new Exercise("Push ups", "Floor"))
		repository.save(new Exercise("Chest to bar", "Gymnastics"))
		repository.save(new Exercise("Toes to bar", "Gymnastics"))
		repository.save(new Exercise("Ring muscle up", "Gymnastics"))

		// fetch all Exercises
		println "Exercises found with findAll():"
		println "-------------------------------"
		for (Exercise exercise : repository.findAll()) {
				print "${exercise.name}\n"
		}
		print "\n"
		// fetch an individual Exercise
		println("Exercise found with findByName('Push Ups'):")
		println "-------------------------------"
		println repository.findByName("Push ups").name
		print "\n"
		// fetch a list of Gymnastic exercises
		println("Exercises found with findByType('Gymnastics'):")
		println "-------------------------------"
		for (Exercise exercise : repository.findByType("Gymnastics")) {
			println exercise.name
		}

        }


}

