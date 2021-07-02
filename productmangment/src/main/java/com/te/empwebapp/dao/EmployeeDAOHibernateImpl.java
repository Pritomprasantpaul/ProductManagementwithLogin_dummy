package com.te.empwebapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.empwebapp.beans.EmployeeInfoBean;
import com.te.empwebapp.customexp.EmployeeException;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Override
	public EmployeeInfoBean authenticate(int id, String pwd) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, id);
		if (infoBean != null) {
			if (infoBean.getPassword().equals(pwd)) {
				return infoBean;
			} else {
				throw new EmployeeException("Password is wrong");
			}
		} else {
			throw new EmployeeException("Invalid ID");
		}

	}

}
