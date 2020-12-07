package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepository extends PagingAndSortingRepository<CardHolder, Integer>, JpaSpecificationExecutor<CardHolder>, CrudRepository<CardHolder,Integer> {
}
