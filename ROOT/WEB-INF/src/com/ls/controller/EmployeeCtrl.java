package com.ls.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ls.dao.EmployeeDao;
import com.ls.pojo.Location;

@Controller
@RequestMapping("/employee")
public class EmployeeCtrl {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping("/all")
	 public ModelAndView getAll()
	 {
		 List<Location> list=null;
		 list=employeeDao.getAllEmployee();
		 System.out.println(list);
		 return new ModelAndView("employee","listEmployee",list);
	 }
}
