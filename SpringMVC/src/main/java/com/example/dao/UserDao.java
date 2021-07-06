package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.models.User;



@Component
public class UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	
	public String addUserDetails(User user) {
		
		try {
			
			String sql="INSERT INTO USER (username,password)values(?,?)";
			this.template.update(sql,user.getUsername(),user.getPassword());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
		
	}
	
	
	public List<User> getUserList(){
		
		String sql="SELECT * FROM USER";
		
		return  template.query(sql,(ResultSet rs, int rowNum) -> {
			User details = new User();
			details.setUsername(rs.getString("username"));
			details.setPassword(rs.getString("password"));
			return details;
		});
		
		
	}
}
