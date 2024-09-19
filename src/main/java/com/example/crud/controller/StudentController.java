package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;

@RestController
@RequestMapping("api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public List <Student> getAllStudent(){
		return this.studentService.getAllStudent();
	}
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return this.studentService.getStudentById(id);
	}
	@PostMapping("/student")
	public Student createStudent(@RequestBody final Student student) {
		return this.studentService.createStudent(student);
	}
	@PutMapping("/student/{id}")
	public String updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	 return this.studentService.updateStudent(id, studentDetails);
	}
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return this.studentService.deleteStudent(id);
	}
}
