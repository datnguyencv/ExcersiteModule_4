package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(Customer customer);

    Customer findById(Integer id);
}
