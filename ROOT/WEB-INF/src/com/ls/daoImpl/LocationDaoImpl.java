package com.ls.daoImpl;

import java.util.List;

import javax.management.Query;
import javax.servlet.jsp.jstl.core.Config;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ls.dao.LocationDao;
import com.ls.pojo.Location;

public class LocationDaoImpl implements LocationDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String getName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getId(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAll() {
		System.out.println("In Get all ");
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Location.class);
		List<Location> list=null;
		if(criteria!=null)
		{
		 list=criteria.list();
		}
		tx.commit();
		return list;
	}

	@Override
	public Boolean saveData(Location loc) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(loc);
		tx.commit();
		session.close();			
		return null;
	}

	@Override
	public Boolean deleteDataById(Long id) {
		/*Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from Location where id="+id;
		org.hibernate.Query query=session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();*/
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Location loc=getById(id);	
		session.delete(loc);
		tx.commit();
		session.close();
		return null;
	}

	@Override
	public Location getById(Long id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Location loc=(Location) session.get(Location.class,id);
		tx.commit();
		session.close();
		return loc;
    
	}
	
	

}
