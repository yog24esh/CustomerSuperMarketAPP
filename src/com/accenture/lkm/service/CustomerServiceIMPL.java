package com.accenture.lkm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.dao.CustomerDAOWrapper;


@Service
public class CustomerServiceIMPL implements CustomerService{

	@Autowired
	CustomerDAOWrapper daoWrapper;
	
//	CustomerDAOWrapper daoWrapper = new CustomerDAOWrapper();
	@Override
	public Integer addCustomer(CustomerBean bean) throws Exception {
		bean.setCustomerType("s");
		return daoWrapper.addCustomer(bean);
	}

}
