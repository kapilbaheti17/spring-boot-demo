package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessCardRepository extends PagingAndSortingRepository<AccessCard, Integer>, CrudRepository<AccessCard, Integer> {
}
