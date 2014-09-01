package com.ls.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ls.dao.EmployeeDao;
import com.ls.pojo.Location;

public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	SessionFactory sessionfactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAllEmployee() {
		Session session=null;
		Transaction tx=null;
		List<Location> listEmployee=null;
		try{
		session=sessionfactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Location.class);
		listEmployee=criteria.list();
		tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			if(tx!=null)
			{
				tx.rollback();
			}
		}finally{
			if (session != null) {
				session.close();
				session = null;
				tx = null;
			}
		}
		return listEmployee;
		
	}

}
