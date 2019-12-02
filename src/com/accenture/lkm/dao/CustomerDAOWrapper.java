package com.accenture.lkm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.entity.CustomerEntity;



@Repository
@Transactional(value = "txManager")
public class CustomerDAOWrapper {

	@Autowired
	private CustomerDAO dao;
	
	@Autowired
	private CustomerTypeDAO typeDAO;
	

	@PersistenceContext
	EntityManager entityManager;
	
	public Integer addCustomer(CustomerBean Custbean) throws Exception {
		CustomerBean bean = null;
		CustomerEntity entity = convertCustomerBeanToEntity(Custbean);
		try {
		bean = convertCustomerEntityToBean(dao.save(entity));
		}catch(Exception ex) {
			throw ex;
		}
		
		return bean.getCustomerId();
		
	}

	private CustomerBean convertCustomerEntityToBean(CustomerEntity entity) {
		// TODO Auto-generated method stub
		CustomerBean bean = new CustomerBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

	private CustomerEntity convertCustomerBeanToEntity(CustomerBean bean) {
		// TODO Auto-generated method stub
		CustomerEntity entity = new CustomerEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
}
