package com.te.empwebapp.dao;

import java.util.List;

import com.te.empwebapp.beans.EmployeeInfoBean;

public interface EmployeeDAO {

	public EmployeeInfoBean authenticate(int id, String pwd);

	
}
