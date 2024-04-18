package com.comment.service;

import com.comment.entity.Comment;

public interface CommentService {
   
	public Comment saveComment(Comment comment); 
	
	
	public Comment updateComment(Comment comment);
}
