package com.example.demo;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.PagingResponse;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
public class CardHolderController {
	
	private final CardHolderRepository repository;
	private final CardHolderService service;
	
	public CardHolderController(CardHolderRepository cardHolderRepository, CardHolderService cardHolderService) {
		// TODO Auto-generated constructor stub
		this.repository = cardHolderRepository;
		this.service = cardHolderService;
	}
	
	@GetMapping("/cardHolders")
	List<CardHolder> all() {
		return (List<CardHolder>) repository.findAll();
	}
	
	@Transactional
	@PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<CardHolder>> getCardHolder(
			@And({
				@Spec(path = "firstName", params = "firstName", spec = Like.class)
			}) Specification<CardHolder> spec, @RequestBody Map<String, String> params) {
		return new ResponseEntity<>(service.get(spec, params),HttpStatus.OK);
	}
}
