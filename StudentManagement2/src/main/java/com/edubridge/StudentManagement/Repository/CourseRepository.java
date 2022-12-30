package com.edubridge.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.StudentManagement.Domain.Course;
 
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
 
}
