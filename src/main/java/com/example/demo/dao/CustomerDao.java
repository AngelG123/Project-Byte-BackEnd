package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Customer;

public interface CustomerDao {

    public List<Customer> getAll();
    public Customer get(Long id);
    public Customer register(Customer customer);
    public Customer update(Customer customer);   
    public int delete(Long id);
    public List<Customer> paginate(int page);

}

