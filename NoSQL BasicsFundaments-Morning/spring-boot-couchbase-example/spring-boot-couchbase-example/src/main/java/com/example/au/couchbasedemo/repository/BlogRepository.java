package com.example.au.couchbasedemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.au.couchbasedemo.model.Blogs;

public interface BlogRepository extends CrudRepository<Blogs, String> {
	
	Blogs findByAuthor(String author);

	List deleteBytopicAndAuthor(String title, String author);
	
	
 //@Query(value ="FROM `couchbasedemo` AS t1 WHERE SEARCH(t1.tags,:tag)")
	
    List<Blogs> findByTags(@PathVariable("tag") String tag);
       



	   
}