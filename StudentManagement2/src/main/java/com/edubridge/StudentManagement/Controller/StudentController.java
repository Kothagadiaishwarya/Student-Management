package com.edubridge.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.StudentManagement.Domain.Course;
import com.edubridge.StudentManagement.Domain.Student;
import com.edubridge.StudentManagement.Service.CourseService;
import com.edubridge.StudentManagement.Service.StudentService;
@Controller
@RequestMapping("/Student")
public class StudentController {

	 
	 
	 @Autowired
	 private StudentService service;
	 @Autowired
	 private CourseService services;
	 
	/*  @RequestMapping("/")
	    public String viewHomePage(Model model) {
	     List<Student> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	       
	        return "Student";
	    }    */
	 	
	    @GetMapping("/addstudent")
	    public String add(Model model) {
	     List<Student> liststudent = service.listAll();
	     List<Course> listcourse = services.listAll();

	        model.addAttribute("listcourse", listcourse);
	        model.addAttribute("liststudent", liststudent);

	        model.addAttribute("student", new Student());
	        return "addstudent";
	    }
	 
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("student") Student std) {
	        service.save(std);
	        return "redirect:/student";
	    }
	 
	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("addstudent");
	        List<Course> listcourse =services.listAll();
	        Student std = service.get(id);
	        mav.addObject("student", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deleteStudentPage(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/student/";
	    }
	}



