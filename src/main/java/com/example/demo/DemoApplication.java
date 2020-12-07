package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	CardHolderRepository cardHolderRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Generating first record
		AccessCard card1 = new AccessCard(1001,1,0,1);
		AccessCard card2 = new AccessCard(1002,0,1,0);
		List<AccessCard> accessCardList = Stream.of(card1, card2).collect(Collectors.toList());
		CardHolder cardHolder1 = new CardHolder("12000","Kapil","Baheti",1, accessCardList);
		log.info("Loading: "+cardHolderRepository.save(cardHolder1));
	}

}
