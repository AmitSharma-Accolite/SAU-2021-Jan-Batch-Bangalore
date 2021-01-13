/**
 * 
 */
package com.example.au.couchbasedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.CricketDB;
import com.example.au.couchbasedemo.repository.CricketDbRepository;

import java.util.List;

/**
 * @author khand
 *
 */
@RestController
public class CricketDbController {
       
	     @Autowired
	     CricketDbRepository cricRepo;
	     
	     @PostMapping("/cricketDB")
	     public CricketDB addNewEntry(@RequestBody CricketDB newPlayer) {
	    	 return cricRepo.save(newPlayer);
	     }
	     
	     @GetMapping("/cricketDB/search/{value}")
	     public List<CricketDB> getData(@PathVariable Integer value){
	    	 return (List<CricketDB>) cricRepo.findByRunGreaterThan(value);
	     }
	  
}
