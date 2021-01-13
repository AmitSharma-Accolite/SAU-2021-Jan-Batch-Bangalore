package com.example.au.couchbasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.CricketDB;

import java.util.List;

public interface CricketDbRepository extends CrudRepository<CricketDB,String> {

	List<CricketDB> findByRunGreaterThan(Integer value);
       
	
}
