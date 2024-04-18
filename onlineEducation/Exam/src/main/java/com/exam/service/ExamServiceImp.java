package com.exam.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.StudentDao;
import com.exam.entity.Exam;
import com.exam.entity.TestPaper;
import com.exam.repository.ExamRepository;
import com.exam.repository.TestPaperRepository;
@Service
public class ExamServiceImp implements ExamService{
	
	 @Autowired
	private StudentDao dao;
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private TestPaperRepository paperRepository;

	@Override
	public Exam saveDetails(Exam exam) {
		  
		for(TestPaper paper:exam.getTestPaper())
		{
			paperRepository.save(paper);
		}
		
		return examRepository.save(exam);
	}

	@Override
	public Exam update(Exam exam) {
		
		if(searchByExamID(exam.getExamId())==null)
		{
			
		}
		return examRepository.save(exam);
	}

	@Override
	public void delete(Exam exam) {
		if(searchByExamID(exam.getExamId())==null)
		{
			
		}
		examRepository.delete(exam);
	}
	
	public Exam searchByExamID(long id)
	{   
		if(examRepository.findByExamId(id).get()==null)
		{
			
		}
		return examRepository.findByExamId(id).get();
	}
	
	
	public Set<String> takeExam(Long examId)  {
		Set<String> questionsAndChoices = new HashSet<>();
 
		Exam exam = examRepository.findByExamId(examId).get();
		if (exam != null) {
			List<TestPaper> testPapers = exam.getTestPaper();
			if (testPapers != null) {
				for (TestPaper testPaper : testPapers) {
					String question= testPaper.getQuestion();
					String choice1 = testPaper.getChoice1();
					String choice2 = testPaper.getChoice2();
					String choice3 = testPaper.getChoice3();
					String choice4 = testPaper.getChoice4();
 
					String questionWithChoices = "Question: " + question + "\n" + "1. " + choice1 + "\n" + "2. "
							+ choice2 + "\n" + "3. " + choice3 + "\n" + "4. " + choice4 + "\n";
 
					questionsAndChoices.add(questionWithChoices);
				}
			}
		}
 
		return questionsAndChoices;
	}
	
	public int submitAnswer(long studentId,long emamId,List<String> answers)
	{  
		
		if(dao.SearchByStudent(emamId)==null)
		{
			
		}
		
		
		if(examRepository.findByExamId(emamId).get()==null)
		{
			
		}
	   
		Exam exam = examRepository.findByExamId(emamId).get();
 
		// Get test papers from the exam
		List<TestPaper> testPapers = exam.getTestPaper();
 
		// Calculate score
		int score = 0;
		Iterator<String> answersIterator = answers.iterator();
		for (TestPaper testPaper : testPapers) {
			String studentAnswer = answersIterator.next();
			System.out.println("student" + studentAnswer);
			String correctAnswer = testPaper.getAnswer();
			System.out.println("correct" + correctAnswer);
			if (studentAnswer != null && studentAnswer.equals(correctAnswer)) {
				score++;
			}
		}
		System.out.println(score);
		dao.SearchByStudent(studentId).setScore(score);
		dao.update(dao.SearchByStudent(studentId));
		return score;
	}
 

	

}
