package com.example.customermanagement.service.impl;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.repository.ICustomerRepository;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(customer);    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
