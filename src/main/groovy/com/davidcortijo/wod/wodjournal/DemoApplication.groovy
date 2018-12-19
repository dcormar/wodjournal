package com.davidcortijo.wod.wodjournal

import com.davidcortijo.wod.wodjournal.repository.ExerciseRepository
import package com.davidcortijo.wod.wodjournal.beans.Exercise

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DemoApplication {

	@Autowired
    private ExerciseRepository repository

	static void main(String[] args) {
		SpringApplication.run DemoApplication, args
	}

	public void run(String... args) throws Exception {
		repository.deleteAll()

		// save a couple of exercises
		repository.save(new Exercise("Push ups", "Floor"))
		repository.save(new Exercise("Chest to bar", "Gymnastics"))

		// fetch all Exercises
		print "Exercises found with findAll():"
		print "-------------------------------"
		for (Exercise exercise : repository.findAll()) {
				print exercise
		}
		print "\n"

		// fetch an individual Exercise
		System.out.println("Exercise found with findByName('Push Ups'):");
		print "-------------------------------"
		print repository.findByFirstName("Push Ups"));
		print "\n"

		System.out.println("Exercises found with findByType('Gymnastics'):");
		print "-------------------------------"
		for (Exercise exercise : repository.findByType("Gymnastics")) {
				print exercise;
		}

        }


}

