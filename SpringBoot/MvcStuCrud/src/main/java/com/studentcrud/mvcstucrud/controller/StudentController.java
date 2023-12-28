/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentcrud.mvcstucrud.controller;

import com.studentcrud.mvcstucrud.dao.StudentDao;
import com.studentcrud.mvcstucrud.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/")
public class StudentController {
    
    @Autowired
    private StudentDao ed;
    
    
    @GetMapping("home")
    public String home(){
    
    return "home";
    }
    
     @GetMapping("viewallstu")
    public  String viewAllStu(Model m){
        List<Student> empList=ed.getAllStu();        
        m.addAttribute("empList", empList);
        return "viewAllStudent";
    
    }
    
     @RequestMapping("stusaveform")
    public  String saveStudent(Model m){
        
        m.addAttribute("student", new Student());        
        return "studentSaveForm";    
    }
    
    @PostMapping("stusave")
    public  String saveStu(@ModelAttribute Student e){        
        ed.saveStu(e);            
        return "redirect:viewallstu";   
    }
    
    @RequestMapping("deletestu/{id}")
    public  String deleteStu(@PathVariable("id") int id){
        
        ed.deleteStu(id);
        return "redirect:viewallstu";         
    }
    
    @RequestMapping("stueditform/{id}")
    public String stuEditForm(@PathVariable("id") int id,Model m){
        Student student=ed.getStuById(id);
        m.addAttribute("student", student);
        return  "studentEdit";
    }
    
    @RequestMapping("editstusave")
    public String editStuSave(@ModelAttribute("student") Student student){
        ed.updateStu(student);
        return "redirect:viewallstu";
    }
    
}
