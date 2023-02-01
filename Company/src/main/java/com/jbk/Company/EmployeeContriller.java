package com.jbk.Company;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Step1-Write a code  for get or load or select the data from database
@RestController
public class EmployeeContriller {
	
	@Autowired
	SessionFactory sf;
	@RequestMapping("Show Single Record")
	public Employee ShowSingleRecord(){
		Session ss=sf.openSession();
		Employee ee=ss.load(Employee.class, 7);
		System.out.println(ee);
		return ee;
	}
	//code for get multiple record
	@SuppressWarnings("rawtypes")
	@GetMapping("Show Multiple Record From Employee")
	public List ShowMultipleRecord(){
		
		Session ss=sf.openSession();
		
		String s="from Employee";
		
		Query q=ss.createQuery(s);
		
		List result=q.list();
		
		System.out.println(result);
		return result;
	}
	
	//code for inserting Data
	@PostMapping("Inserting Date Into Employee Table")
	public Employee InsertRecord(){
		
		Session ss=sf.openSession();
		
		Transaction ts=ss.beginTransaction();
		
		Employee ee=new Employee(8, "Rahul", 25, "pune");
		ss.save(ee);
		ts.commit();
		System.out.println(ee);
		return ee;
	}
	
	//code for Updating data
	@PutMapping("Updating Data Of Employee Table")
	public Employee UpdateData(){
       
		Session ss=sf.openSession();
		
		Transaction ts=ss.beginTransaction();
		
		Employee ee=new Employee(8, "Chetan", 26, "pune");
		
		ss.update(ee);
		
		ts.commit();
		
		System.out.println(ee);
		
		return ee;
	}
	
	//code for deleting the data from employee
	@DeleteMapping("Delete data From Employee")
	public Employee DeleteRecord(){
        Session ss=sf.openSession();
		
		Transaction ts=ss.beginTransaction();
		
		Employee ee=ss.load(Employee.class, 8);
		
		
		ss.delete(ee);
		
		ts.commit();
		
		System.out.println(ee);
		
		return ee;
		
	}
	
	
	
	
	
	
	
	
	
}
