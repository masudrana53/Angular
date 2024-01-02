/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatema.evd02student.dao;

import com.fatema.evd02student.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author user
 */
public class EmployeeDao {
    
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    
    public int saveEmp(Employee emp){
    
        String sql="insert into evd_employee(ename, department, salary, gender) values(' "+emp.getEname()+"','"+emp.getDepartment()+"','"+emp.getSalary()+"','"+emp.getGender()+" ')";
        
        return template.update(sql);
    
    }
    
    public int deleteEmp(int id){
    String sql="delete from evd_employee where id=" + id + " ";
    return template.update(sql);
    }
    
    public int updateEmp(Employee emp) {

        String sql = "update  evd_employee set ename='" + emp.getEname()+ "', department='" + emp.getDepartment() + "', salary='" + emp.getSalary()+ "', gender='" + emp.getGender() + "' where id='" + emp.getId()+ "' ";

        return template.update(sql);
    }
    
    public Employee getEmpById(int id) {
        String sql = "select * from evd_employee where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }
    
    public List<Employee> getAllEmp() {
        return template.query("select * from evd_employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee emp= new Employee(
                        rs.getInt("id"),
                        rs.getString("ename"),  
                        rs.getString("department"),
                        rs.getInt("salary"),
                        rs.getString("gender")
                        
                        
                );

                return emp;
            }
        });
    
    }    
    
}
