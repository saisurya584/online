package com.exam.service;

import com.exam.entity.Exam;

public interface ExamService {
	
	public Exam saveDetails(Exam exam);
	
	public Exam update(Exam exam);
	
	public void delete(Exam exam);

}
