package com.exam.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.dto.StudentDto;



@FeignClient(name="STUDENT")
public interface StudentDao {
	
	
	@GetMapping("/{id}")
	public StudentDto SearchByStudent(@PathVariable("id") long id);
	
	
	@PutMapping("/update")
	public StudentDto update( @RequestBody StudentDto student);

}
