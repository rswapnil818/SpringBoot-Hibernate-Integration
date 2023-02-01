package com.JBK.Hibernate.and.SpringBoot.Integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeMO_PathVariable_and_RequestBody {

	@RequestMapping("DemoPathVariable/{id}")
	void DemoPathVariable(@PathVariable int id) {// default/para // default /para

		System.out.println(id);

	}
	

	@RequestMapping("DemoPathVariableID/{id}")
	int DemoPathVariable123(@PathVariable int id) {

		System.out.println(id);
		return id;
	}

	@RequestMapping("DemoPathVariableName/{name}")
	String DemoPathVariableString(@PathVariable String name) {

		System.out.println(name);
		return name;
	}
	
	
	@GetMapping("DemoRequestBodyID")
	int DemoRequestBody(@RequestBody int id) {

		System.out.println(id);
		return id;
	}
	
	@GetMapping("DemoRequestBodyName")
	String DemoRequestBody(@RequestBody String name) {

		System.out.println(name);
		return name;
	}
}








