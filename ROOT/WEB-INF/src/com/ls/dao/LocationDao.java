package com.ls.dao;

import java.util.List;

import com.ls.pojo.Location;

public interface LocationDao {
	
	public String getName(Long id);
	public Long getId(String name);
	public List<Location> getAll();
	public Boolean saveData(Location loc);
	public Boolean  deleteDataById(Long id);
	public Location getById(Long id);

}
