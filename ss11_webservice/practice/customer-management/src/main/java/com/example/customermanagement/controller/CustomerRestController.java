package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> getCustomer(){
                return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public void creater(@RequestBody Customer customer){
        this.customerService.create(customer);
    }

    @ResponseStatus(value = HttpStatus.FOUND)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id, Customer customer){
        Customer customer2 = customerService.findById(id);
        this.customerService.delete(customer2);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Customer customer){
        Customer temp= customerService.findById(id);
        temp.setFirstName(customer.getFirstName());
        temp.setLastName(customer.getLastName());
        this.customerService.update(temp);
    }

}
