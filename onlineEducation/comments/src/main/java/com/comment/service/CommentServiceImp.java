package com.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.dao.CourseDao;
import com.comment.dao.StudentDao;
import com.comment.entity.Comment;
import com.comment.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;

	@Override
	public Comment saveComment(Comment comment) {
		if(studentDao.SearchByStudent(comment.getStudentId())==null)
		{
			
		}
		if(courseDao.searchByCourseId(comment.getCourseId())==null)
		{
			
		}
		
		return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		if(commentRepository.findById(comment.getId()).get()==null)
		{
			
		}
		if(studentDao.SearchByStudent(comment.getStudentId())==null)
		{
			
		}
		if(courseDao.searchByCourseId(comment.getCourseId())==null)
		{
			
		}
		
		return commentRepository.saveAndFlush(comment);
	}

	public String delete(long id) {
		if(commentRepository.findById(id).get()==null)
		{
			return "no record found";
		}
		commentRepository.deleteById(id);
		return "deleted";
	}
       
	public List<Comment> getByCourseId(long id)
	{
		if(courseDao.searchByCourseId(id)==null)
		{
			
		}
		return commentRepository.findByCourseId(id);
	}
}