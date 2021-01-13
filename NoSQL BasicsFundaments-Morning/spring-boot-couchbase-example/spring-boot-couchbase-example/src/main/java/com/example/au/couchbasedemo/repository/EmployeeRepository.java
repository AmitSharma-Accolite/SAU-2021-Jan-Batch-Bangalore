package com.example.au.couchbasedemo.repository;

import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.au.couchbasedemo.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String>
{

   //@Query("from * couchbasedemo where #{#n1ql.filter} location +location and pincode +pincode END within #{#n1ql.bucket}")
   List  getBylocationAndPincode(String location,String pincode);


}
