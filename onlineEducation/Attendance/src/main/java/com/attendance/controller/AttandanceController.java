package com.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entity.Attendance;
import com.attendance.service.AttendanceServiceImp;

@RestController
@RequestMapping("/attendance")
public class AttandanceController {
	
	
	@Autowired
	private AttendanceServiceImp attendanceServiceImp;
	
	@PostMapping("/saveData")
	public Attendance saveDetails( @RequestBody Attendance attendance)
	{ 
		
		return attendanceServiceImp.saveDetail(attendance);
	}
	
	@PutMapping("/update")
	public Attendance update(@RequestBody Attendance attendance)
	{
		return attendanceServiceImp.update(attendance);
	}

}
