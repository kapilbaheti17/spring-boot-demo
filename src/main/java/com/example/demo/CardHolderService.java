package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CardHolderService {
	
	private final CardHolderRepository cardHolderRepository;
	
	@Autowired
	public CardHolderService(CardHolderRepository cardHolderRepository) {
		this.cardHolderRepository = cardHolderRepository;
	}
	
	/**
     * get elements using Criteria.
     *
     * @param spec     *
     * @param pageable pagination data
     * @return retrieve elements with pagination
     */
    public List<CardHolder> get(Specification<CardHolder> spec, Map<String, String> params) {
        List<CardHolder> page = cardHolderRepository.findAll(spec);
        //If the card type is present then extract the list
        if(params.get("cardType") != null)
        {
        	for(CardHolder cdHolder: page) {
        		List<AccessCard> acdAccessCards = new ArrayList<AccessCard>();
        		if(cdHolder.getAccessCardList().size() > 0) {
        			for(AccessCard accessCard: cdHolder.getAccessCardList()) {
            			if(accessCard.getCardType() == Integer.parseInt(params.get("cardType"))) {
            				acdAccessCards.add(accessCard);
            			}
            		}
        			cdHolder.setAccessCardList(acdAccessCards);
        		}
        	}
        }
        System.out.println(page);
        if(params.get("cardStatus") != null)
        {
        	for(CardHolder cdHolder: page) {
        		List<AccessCard> acdAccessCards = new ArrayList<AccessCard>();
        		if(cdHolder.getAccessCardList().size() > 0) {
        			for(AccessCard accessCard: cdHolder.getAccessCardList()) {
            			if(accessCard.getCardStatus() == Integer.parseInt(params.get("cardStatus"))) {
            				acdAccessCards.add(accessCard);
            			}
            		}
        			cdHolder.setAccessCardList(acdAccessCards);
        		}
        	}
        }
        return page;
    }   
}
