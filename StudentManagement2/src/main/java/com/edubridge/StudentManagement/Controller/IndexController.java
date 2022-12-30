package com.edubridge.StudentManagement.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edubridge.StudentManagement.Domain.Course;
import com.edubridge.StudentManagement.Domain.Student;
import com.edubridge.StudentManagement.Domain.StudentDAO;
import com.edubridge.StudentManagement.Repository.StudentRepository;
import com.edubridge.StudentManagement.Service.CourseService;
import com.edubridge.StudentManagement.Service.StudentService;


@Controller
@RequestMapping("/")
public class IndexController {
            @Autowired
            private CourseService service;
            @Autowired
            private StudentService services;
             @Autowired
             private StudentRepository studentRepository;
            
            @RequestMapping(value ="/student" ,method= RequestMethod.GET)
            public String viewStudentPage(Model model) {
         	   List<StudentDAO> li=new ArrayList<>();
         	   for(Object[] o : studentRepository.findStudent()){
         		   StudentDAO student=new StudentDAO();
         	   
         	   student.setId(Long.parseLong(String.valueOf(o[0])));
         	   student.setStname((String)(o[1]));
         	   student.setCoursename((String)(o[2]));
                      li.add(student);
         	   }
         	   model.addAttribute("liststudent " , li);
         	   
         	   return "student";  }
            


            
            @RequestMapping(value="/index",method =RequestMethod.GET)
            public String index() {
            	return "index";
            }
               @RequestMapping(value ="/course" ,method= RequestMethod.GET)
               public String viewHomePage(Model model) {
            	   List<Course> listcourse =service.listAll();
            	   model.addAttribute("listcourse " , listcourse);
            	   System.out.print("Get / ");
            	   return "Course";
               }
}
