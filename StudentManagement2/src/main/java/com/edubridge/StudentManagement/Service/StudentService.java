package com.edubridge.StudentManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.edubridge.StudentManagement.Domain.Student;
import com.edubridge.StudentManagement.Repository.StudentRepository;
 
@Service
public class StudentService {
 
@Autowired
    private StudentRepository repo;
public List<Student> listAll()
{
System.out.println(repo.findAll());
        return repo.findAll();
    }
    
 
    public void save(Student std) {
        repo.save(std);
        System.out.println(repo.save(std));

    }
    
    public Student get(long id) {
        return repo.findById(id).get();
    }
    
    public void delete(long id) {
        repo.deleteById(id);
    }
                        
}

