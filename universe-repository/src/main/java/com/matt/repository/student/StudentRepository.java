package com.matt.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matt.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
