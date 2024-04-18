package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.CourseDao;
import com.student.dto.CourseDto;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseDao dao;
	
	public Student saveDetails(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student searchById(long id)
	{
	    Student student = studentRepository.findByStudentId(id).get();
	    
	    if(student==null)
	    {
	    	
	    }
	    return student;
	}

	
	
	@Override
	public String delete(long id) {
		
		if(searchById(id)==null)
		{
			return "no record";
		}
		
		studentRepository.delete(searchById(id));
		return "delete successfully";
	}

	@Override
	public Student update(Student student) {
	   
		if(searchById(student.getStudentId())==null)
		{
			
		}
		return studentRepository.saveAndFlush(student);
	}

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	
	public String registerForCourse(long studentId,long courseId)
	{
		if(searchById(studentId)==null)
		{
			
		}
		if(dao.searchByCourseId(courseId)==null)
		{
			
		}
		
		CourseDto course = dao.searchByCourseId(courseId);
		
		if (course.getMaxStudent() >= course.getMaxStudent()) {
			throw new IllegalStateException("Course is already full!");
		}
 
		course.setMaxStudent(course.getMaxStudent() - 1);
        dao.update(course);
		// Set the course for the student
	    searchById(studentId).setCourseId((int)courseId);
		// Update the student in the database
		update( searchById(studentId));
		
		return "registrated successfully";
	}

	public int getScore(long id) {
		
		return searchById(id).getScore();
	}
	
	
	

}