package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Exam;
import com.exam.service.ExamServiceImp;

@RequestMapping("/exam")
@RestController
public class ExamController {
	
	@Autowired
	private ExamServiceImp examServiceImp;
	
	@PostMapping("/save")
	public Exam save(@RequestBody Exam exam)
	{
		return examServiceImp.saveDetails(exam);
	}
	@PutMapping("/update")
	public Exam update(@RequestBody Exam exam)
	{
		return examServiceImp.update(exam);
	}
	@GetMapping("get/{id}")
	public Exam searchByExamId(@PathVariable("id") long id)
	{
		return examServiceImp.searchByExamID(id);
	}
	
	
	@GetMapping("question/{examId}")
	public Set<String> takeExam(@PathVariable("examId") long examId)
	{
		return examServiceImp.takeExam(examId);
	}
	
	@PostMapping("/{examId}/sumbit")
	public int submitAnswer(@PathVariable("examid") long id)
	{
		return examServiceImp.submitAnswer(id, id, null);
	}


}
