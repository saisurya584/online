package com.attendance.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.dao.StudentDao;
import com.attendance.entity.Attendance;
import com.attendance.repository.AttendanceRepository;
@Service
public class AttendanceServiceImp implements AttendanceService{
	@Autowired
	private AttendanceRepository attendanceRepository;
	@Autowired
	private StudentDao dao;

	@Override
	public Attendance saveDetail(Attendance attendance) {
		// TODO Auto-generated method stub
		
		if(dao.SearchByStudent(attendance.getStudentId())==null)
		{
			
		}
		   
		attendance.setDate(LocalDate.now().toString());
		
		return attendanceRepository.save(attendance);
	}

	@Override
	public Attendance update(Attendance attendance) {
		if(!attendanceRepository.findById(attendance.getId()).isPresent())
		{
			
		}
		return attendanceRepository.save(attendance);
	}

}
