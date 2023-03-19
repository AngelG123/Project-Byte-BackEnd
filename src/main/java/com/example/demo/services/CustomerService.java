package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Customer;

import com.example.demo.dao.CustomerDao;

@Service
public class CustomerService {
    
    @Autowired
    CustomerDao daoCustomer;

    public List<Customer> getAll(){
        return daoCustomer.getAll();
    }

    public Customer get(Long id){
        return daoCustomer.get(id);
    }

    public Customer register(Customer customer){
        return daoCustomer.register(customer);
    }

    public Customer update(Customer customer){
        return daoCustomer.update(customer);
    }  

    public int delete(Long id){
        return daoCustomer.delete(id);
    }

    public List<Customer> paginate(int page){
        return daoCustomer.paginate(page);
    }

}
