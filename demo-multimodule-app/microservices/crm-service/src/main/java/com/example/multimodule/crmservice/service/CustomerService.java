package com.example.multimodule.crmservice.service;

import com.example.multimodule.db.entity.Customer;
import com.example.multimodule.db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired(required=true)
    CustomerRepository repository;

    public Customer save(Customer customer){
        return repository.save(customer);
    }

}
