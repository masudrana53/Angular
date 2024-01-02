/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvcempcrudtest.controller;

import com.mycompany.mvcempcrudtest.dao.EmployeeDao;
import com.mycompany.mvcempcrudtest.model.Employee;
import java.lang.annotation.Retention;
import java.util.List;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeDao ed;
    
    
    @GetMapping("/viewallpro")
    public  String viewAllEmp(Model m){
        List<Employee> empList=ed.getAllEmp();        
        m.addAttribute("empList", empList);
        return "viewAllEmp";
    
    }
    
    @GetMapping("/prosaveform")
    public  String saveForm(Model m){
        
        m.addAttribute("employee", new Employee());        
        return "empsaveform";    
    }
    
    @PostMapping("/empsave")
    public  String saveEmp(@ModelAttribute Employee e){        
        ed.saveEmp(e);            
        return "redirect:/viewallpro";   
    }
    
    @RequestMapping("/deleteemp/{id}")
    public  String deleteEmp(@PathVariable("id") int id){
        
        ed.deleteEmp(id);
        return "redirect:/viewallpro";         
    }
    
    @RequestMapping("/empeditform/{id}")
    public String empEditForm(@PathVariable("id") int id,Model m){
        Employee employee=ed.getEmpById(id);
        m.addAttribute("employee", employee);
        return  "empEdit";
    }
    
    @RequestMapping("/editempsave")
    public String editEmpSave(@ModelAttribute("employee") Employee employee){
        ed.updateEmp(employee);
        return "redirect:/viewallpro";
    }
    
}
