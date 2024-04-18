package com.course.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.ExamDto;
import com.course.entity.Course;
import com.course.service.CourseServiceImp;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseServiceImp courseServiceImp;
	
	@PostMapping("/save")
	public Course saveDetails(@RequestBody Course course)
	{
		return courseServiceImp.saveDetails(course);
	}
	@PutMapping("/update")
	public Course update(@RequestBody Course course)
	{
		return courseServiceImp.update(course);
	}
	
	@GetMapping("/get/{id}")
	public Course searchByCourseId(@PathVariable("id") long id)
	{
		return courseServiceImp.searchById(id);
	}
	
	@GetMapping("/{name}")
	public Course searchByName(@PathVariable("name") String name)
	{
		return courseServiceImp.searchByName(name);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id)
	{
		return courseServiceImp.deleteCourse(id);
	}
	
	@PostMapping("/{courseId}/addExam/{examId}")
    public String addExamToCourse(@PathVariable Long courseId, @PathVariable Long examId)  {
       
        return courseServiceImp.addExamToCourse(courseId, examId);
    }
	@GetMapping("/exam/{courseId}")
	public ExamDto getExamCourseId(@PathVariable("courseId") long courseId)
	{
		return courseServiceImp.getExamDetails(courseId);
	}

}
