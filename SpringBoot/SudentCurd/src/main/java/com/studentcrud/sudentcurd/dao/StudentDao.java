/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentcrud.sudentcurd.dao;

import com.studentcrud.sudentcurd.model.Student;
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
public class StudentDao {
    
    JdbcTemplate jdbcTemplate;

    public StudentDao() {
    }

     public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
     public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
     
     
             public int saveStu(Student s) {

            String sql = "insert into student_2(name, gender, department, marks)"
                + "values('" + s.getName()+ "','" + s.getGender()+ "', '" + s.getDepartment()+ "', '" + s.getMarks()+ "')";
        return jdbcTemplate.update(sql);       
    }
             
        public int deleteStu(int id) {

        String sql = "delete from student_2 where id=" + id + " ";

        return jdbcTemplate.update(sql);
    }
             
       
        public int updateStu(Student s) {

        String sql = "update  student_2 set name='" + s.getName()+ "', gender='" + s.getGender()+ "', department='" + s.getDepartment()+ "', marks='" + s.getMarks()+ "' where id='" + s.getId()+ "' ";

        return jdbcTemplate.update(sql);
    }
      
        
                         public List<Student> getAllStu() {
        return jdbcTemplate.query("select * from student_2", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int row) throws SQLException {
                Student s = new Student(
                       rs.getInt("id"),
                       rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getString("marks")               
                );
                return s;
            }
        });
        }
                         
          public Student getStuById(int id) {
        String sql = "select * from student_2 where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }
             
             
    
}
