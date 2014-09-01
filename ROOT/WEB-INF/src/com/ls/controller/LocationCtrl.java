package com.ls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ls.dao.LocationDao;
import com.ls.pojo.Location;

@Controller
@RequestMapping("/location")
public class LocationCtrl {
	
	@Autowired
	LocationDao locationDao;	
	//LIST ALL
	@RequestMapping(value= "/all", method=RequestMethod.GET)
	public ModelAndView getAll(){
		List<Location> list=null;
		try{
			list=locationDao.getAll();
		}catch(Exception e)
		{
			System.err.println(e);
		}		
		return new ModelAndView("listall","list",list);		
	}
	
	//ADD WITHOUT FORM
	@RequestMapping("/add")
	public ModelAndView add()
	{
		Location loc=new Location();
		
		loc.setName("Ganesh");
		try{
			locationDao.saveData(loc);
		}catch(Exception e){
			System.err.println(e);
		}
		return new ModelAndView("home");	
	}
	
	//ADD THROUGH FORM
	@RequestMapping("/addloc")
	public ModelAndView addloc(@RequestParam("name") String name)
	{
		
		Location loc=new Location();		
		loc.setName(name);
		try{
			locationDao.saveData(loc);
		}catch(Exception e){
			System.err.println(e);
		}
		List<Location> list=null;
		list=locationDao.getAll();
		return new ModelAndView("listall","list",list);	
	}
	
	//NEW FORM	
	@RequestMapping("/new")
	public String newLoc()
	{
		return "newLoc";
	}
	
	//DELETE
	@RequestMapping("/delete")
	public ModelAndView deleteLoc(@RequestParam("id")Long id){
		
		locationDao.deleteDataById(id);	
		List<Location> list=null;
		list=locationDao.getAll();
		return new ModelAndView("listall","list",list);

	
		
	}
}
