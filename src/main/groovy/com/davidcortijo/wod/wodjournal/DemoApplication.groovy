package com.davidcortijo.wod.wodjournal

import com.davidcortijo.wod.wodjournal.repository.WodsRepository
import com.davidcortijo.wod.wodjournal.repository.MovementsRepository
import com.davidcortijo.wod.wodjournal.beans.Wod
import com.davidcortijo.wod.wodjournal.beans.Movement
import com.davidcortijo.wod.wodjournal.beans.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.core.MongoTemplate

@SpringBootApplication
class DemoApplication implements CommandLineRunner{

	@Autowired
	MovementsRepository mrepository

	@Autowired
	WodsRepository wrepository

	@Autowired
	MongoTemplate mongoTemplate;

	static main(args) {
		SpringApplication.run (DemoApplication, args)
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection(Movement)
		mongoTemplate.dropCollection(Wod)

		// save a couple of movements
		mrepository.save(new Movement("Push ups", "Floor"))
		mrepository.save(new Movement("Chest to bar", "Gymnastics"))
		mrepository.save(new Movement("Toes to bar", "Gymnastics"))
		mrepository.save(new Movement("Ring muscle up", "Gymnastics"))

		// fetch all Movements
		println "Movement found with findAll():"
		println "-------------------------------"
		for (Movement exercise : mrepository.findAll()) {
				print "${exercise.name}\n"
		}
		print "\n"
		// fetch an individual Movement
		println("Movement found with findByName('Push Ups'):")
		println "-------------------------------"
		println mrepository.findByName("Push ups").name
		print "\n"
		// fetch a list of Gymnastic Movements
		println("Movement found with findByType('Gymnastics'):")
		println "-------------------------------"
		for (Movement exercise : mrepository.findByType("Gymnastics")) {
			println exercise.name
		}

		// save a couple of wods
		Movement mov = mrepository.findByName("Push ups")
		wrepository.save(new Wod("Cindy", "Girls", null, Arrays.asList(new Exercise(mrepository.findByName("Push ups"), 10, "15 kg"))))
		wrepository.save(new Wod("Fran", "Hero", null,Arrays.asList(new Exercise(mrepository.findByName("Push ups"), 25, "25 kg"))))
		print "\n"
		// fetch a list of Today's wods
		println("Today's wods:")
		println "-------------------------------"
		for (Wod wod : wrepository.findByDate(new Date().clearTime())) {
			println wod.name
		}
	}
}

