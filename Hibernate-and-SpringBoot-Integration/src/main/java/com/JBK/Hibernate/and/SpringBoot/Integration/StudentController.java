package com.JBK.Hibernate.and.SpringBoot.Integration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	SessionFactory sf;

	@SuppressWarnings("deprecation")
	@RequestMapping("singleRecord")
	public Student showSingleData() {
		Session ss = sf.openSession();
		Student s = ss.load(Student.class, 101);
		System.out.println(s);
		return s;
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@GetMapping("multipleRecord")
	public List showMultiplData() {

		Session ss = sf.openSession();
		String hql = "from Student"; // tableName
		Query query = ss.createQuery(hql);
		List results = query.list();

		System.out.println(results);
		return results;
	}

	@SuppressWarnings("deprecation")
	@PostMapping("insertRecord")
	public Session insertRecord(@RequestBody Student student) {
		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		ss.save(student); // dataBase
		
		tx.commit();
		System.out.println(ss);
		return ss;

	}

	@SuppressWarnings("deprecation")
	@PutMapping("updateRecord")
	public Session updateRecord(@RequestBody Student student) {
		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		
		ss.update(student);
		tx.commit();
		System.out.println(ss);
		return ss;

	}

	@SuppressWarnings("deprecation")
	@DeleteMapping("deleteRecord")
	public Session deleteRecord(@PathVariable int id) {
		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		
		ss.delete(id);
		tx.commit();
		System.out.println(ss);
		return ss;

	}

}
