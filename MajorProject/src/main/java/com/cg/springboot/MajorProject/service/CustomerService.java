package com.cg.springboot.MajorProject.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.springboot.MajorProject.bean.Customer;
import com.cg.springboot.MajorProject.repo.ICustomerRepo;
@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerRepo repo;

	
	@Override
	public Optional<Customer> getCustomerById(String customer_email) {
		if(!repo.existsById(customer_email)) {
		Customer cust = new Customer();
		cust.setCustomer_email(customer_email);
		cust.setCustomer_refcode(getCode());
		repo.save(cust);
		}
		return repo.findById(customer_email);
	}


	@Override
	public long getCode(Customer c) {
	return c.getCustomer_refcode();
	}
	
	@Override
	public long getCode() {
	long ref= (long)(Math.random() * 10000 + 999999);
	return ref;
	}
	
}
