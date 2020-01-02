package com.restapisample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapisample.pojo.Student;
import com.restapisample.repo.StudentsRepo;

	

/**
 * Controller class for various operations.
 *  
 * @author hari
 *
 */

@RestController
public class StudentResource {
	
	@Autowired
	private StudentsRepo studentsRepo;
	
	@GetMapping("getallstudents")
	public List<Student> getAllStudents(){
		
		return studentsRepo.retrieveAllStudents();
	}
	
	@GetMapping("/findstudent/{name}")
	public Student retrieveStudentByName(@PathVariable String name) {

		return studentsRepo.getStudentWithName(name);
	}
	
	@DeleteMapping("/deletestudent/{name}")
	public List<Student> deleteStudent(@PathVariable String name) {
		
		return studentsRepo.deleteByName(name);
	}
	
	@PostMapping("/createStudent")
	public Student createNewStudent(@RequestBody Student student) {
		
		return studentsRepo.createStudent(student);
	}
}
