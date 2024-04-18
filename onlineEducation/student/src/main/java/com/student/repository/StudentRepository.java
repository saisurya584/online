package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

   public 	Optional<Student> findByStudentId(long id);

}
