package com.journaldev.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.model.User;

@Controller
public class HomeController {
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	String dname;
    String dpass;
    String msg;
	
	public void connection() {
		try {
		Connection con = null;
	      Statement stmt = null;
	      ResultSet result = null;
	      
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
        con = DriverManager.getConnection(
           "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        stmt = con.createStatement();
        result = stmt.executeQuery(
           "SELECT username,password FROM users");
        
        while(result.next()){
           dname=result.getString("username");
           dpass=result.getString("password");
        }
		}
	 catch (Exception e) {
        e.printStackTrace(System.out);
     }
	}
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		connection();
		System.out.println("Home Page Requested");
		return new ModelAndView("home", "message", new User());
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public  @ResponseBody ModelAndView user(@RequestParam("username") String uname,@RequestParam("password") String upass) {
		System.out.println("User Page Requested");
		if(uname.equals(dname) && upass.equals(dpass)) {
			msg="Authorized";
		}
		else
			msg = "UnAuthorized";
		
		return new ModelAndView("user", "message", msg);

	}
	
	
}
