/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatema.evd02student.controller;

import com.fatema.evd02student.dao.EmployeeDao;
import com.fatema.evd02student.model.Employee;
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
public class EmpController {
    @Autowired
    private EmployeeDao dao;
    
    
    @RequestMapping("/emplist")
    public String getAllemp(Model m){
        List<Employee> empList= dao.getAllEmp();
        m.addAttribute("empList", empList);
        return "emplist";
    }
    
    @GetMapping("/saveform")
    public  String saveForm(Model m){
        
        m.addAttribute("employee", new Employee());        
        return "addemp";    
    }
    
    @PostMapping("/save")
    public  String saveStu(@ModelAttribute Employee emp){        
        dao.saveEmp(emp);            
        return "redirect:/emplist";   
    }
    
    @RequestMapping("/delete/{id}")
    public  String deleteEmp(@PathVariable("id") int id){
        
        dao.deleteEmp(id);
        return "redirect:/emplist";         
    }
    
    @RequestMapping("/editemp/{id}")
    public String EmpEditForm(@PathVariable("id") int id,Model m){
        Employee emp=dao.getEmpById(id);
        m.addAttribute("employee", emp);
        return  "editemp";
    }
    
    @RequestMapping("/edit")
    public String editStuSave(@ModelAttribute("employee") Employee emp){
       dao.updateEmp(emp);
        return "redirect:/emplist";
    }
}
