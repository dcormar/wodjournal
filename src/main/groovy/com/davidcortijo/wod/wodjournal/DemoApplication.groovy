package com.davidcortijo.wod.wodjournal

import com.davidcortijo.wod.wodjournal.repository.MovementsRepository
import com.davidcortijo.wod.wodjournal.beans.Movement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DemoApplication implements CommandLineRunner{

	@Autowired
	MovementsRepository repository

	static main(args) {
		SpringApplication.run (DemoApplication, args)
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll()

		// save a couple of movements
		repository.save(new Movement("Push ups", "Floor"))
		repository.save(new Movement("Chest to bar", "Gymnastics"))
		repository.save(new Movement("Toes to bar", "Gymnastics"))
		repository.save(new Movement("Ring muscle up", "Gymnastics"))

		// fetch all Movements
		println "Movement found with findAll():"
		println "-------------------------------"
		for (Movement exercise : repository.findAll()) {
				print "${exercise.name}\n"
		}
		print "\n"
		// fetch an individual Movement
		println("Movement found with findByName('Push Ups'):")
		println "-------------------------------"
		println repository.findByName("Push ups").name
		print "\n"
		// fetch a list of Gymnastic Movements
		println("Movement found with findByType('Gymnastics'):")
		println "-------------------------------"
		for (Movement exercise : repository.findByType("Gymnastics")) {
			println exercise.name
		}

        }
}

