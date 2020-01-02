package com.restapisample.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapisample.pojo.Student;



/**
 * Repository class for connecting to database.
 * For demonstration used local variable as list of students.
 * @author hari
 *
 */
@Repository
public class StudentsRepo {

	List<Student> mAllStudents = new ArrayList<Student>();
	
	public StudentsRepo() {
		
		//Populate default data 
		Student s1 = new Student();
		s1.setAddress("Student Address 1");
		s1.setAge(25);
		s1.setName("Hari");
		
		Student s2 = new Student();
		s2.setAddress("Student Address 2");
		s2.setAge(31);
		s2.setName("Sandy");
	
		Student s3 = new Student();
		s3.setAddress("Student Address 3");
		s3.setAge(22);
		s3.setName("Roshan");
		
		Student s4 = new Student();
		s4.setAddress("Student Address 4");
		s4.setAge(26);
		s4.setName("Guru");
	
		mAllStudents.add(s1);
		mAllStudents.add(s2);
		mAllStudents.add(s3);
		mAllStudents.add(s4);

	}

	/**
	 * Retrieve all students.
	 * @return
	 */
	public List<Student> retrieveAllStudents() {

		return mAllStudents;

	}
	
	/**
	 * Adding new student. 
	 * @param newStudent
	 * @return
	 */
	public List<Student> addStudent(Student newStudent) {
		
		mAllStudents.add(newStudent);
		
		return mAllStudents;
	}

	/**
	 * Get student with name.
	 * @param id
	 * @return
	 */
	public Student getStudentWithName(String name) {
		
		Student student = findStudentByName(name);
		return student;
	}

	/**
	 * Delete student by name.
	 * @param name
	 * @return
	 */
	public List<Student> deleteByName(String name) {

		Student student = findStudentByName(name);
		mAllStudents.remove(student);
		
		return mAllStudents;
	}
	
	/**
	 * Create new student
	 * @param student
	 * @return
	 */
	public Student createStudent(Student student) {
		mAllStudents.add(student);
		return student;
	}
	
	/**
	 * Find student by name.
	 * @param name
	 * @return
	 */
	private Student findStudentByName(String name) {
		Student student = mAllStudents.stream()
				  .filter(std -> name.equals(std.getName()))
				  .findAny()
				  .orElse(null);
		return student;
	}

	

}
