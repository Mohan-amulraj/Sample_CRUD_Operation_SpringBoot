package com.example.crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.entity.Student;
import com.example.crud.exception.UserNotFoundException;
import com.example.crud.repository.StudentRepositry;

@Service
public class StudentService {
	@Autowired
	private StudentRepositry studentRepository;
	public List<Student> getAllStudent(){
		return this.studentRepository.findAll();
	}
	public Student getStudentById(Long id) {
	return this.studentRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException("Student not found for this id : " + id));
	}
	 public Student createStudent(Student student) {
	        return this.studentRepository.save(student);
	    }
	public String updateStudent(Long id,Student studentDetails) {
		Student student = studentRepository.findById(id)
				 .orElseThrow(() -> new UserNotFoundException("Student not found for this id : " + id));
			student.setName(studentDetails.getName());
			student.setAddress(studentDetails.getAddress());
			this.studentRepository.save(student);
		return "Student id:"+id+" "+"successfully updated";
	}
	public String deleteStudent(Long id) {
		Student student = studentRepository.findById(id)
		      .orElseThrow(() -> new UserNotFoundException("Student not found for this id : " + id));
	     this.studentRepository.delete(student);
	return "Student id:"+id+" "+"successfully deleted";
	} 
 }
