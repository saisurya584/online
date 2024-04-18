package com.student.controller;

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

import com.student.entity.Student;
import com.student.service.StudentServiceImp;

@RestController
@RequestMapping("/student")
public class StudentController{
   
	@Autowired
	private StudentServiceImp serviceImp;
	
	@PostMapping("/save")
	public Student saveDetais(@RequestBody Student student)
	{
		return serviceImp.saveDetails(student);
	}
	
	@PutMapping("/update")
	public Student update( @RequestBody Student student)
	{
		return serviceImp.update(student);
	}
	
	@GetMapping("/{id}")
	public Student SearchByStudent(@PathVariable("id") long id)
	{
		return serviceImp.searchById(id);
	}
	@DeleteMapping("/delect/{id}")
	public String deleteStudent(@PathVariable("id") long id)
	{
		return serviceImp.delete(id);
	}
	
	
	@GetMapping("/all")
	public List<Student> getAll()
	{
		return serviceImp.getAll();
	}
	
	@GetMapping("/score/{id}")
	public int getScore(@PathVariable("id") long id)
	{
		return serviceImp.getScore(id);
	}
	
	
	
	@PostMapping("/register/{studentId}/{courseId}")
    public String registerForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
         
		return serviceImp.registerForCourse(studentId, courseId);
    }

 
}
