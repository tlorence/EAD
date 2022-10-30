package com.example.fuelApp.Services;

import com.example.fuelApp.Models.Customer;
import com.example.fuelApp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    LocalDateTime date = LocalDateTime.now();

    public void enterQueue(Customer customer){
        customer.setArrivalTime(LocalDateTime.now().toString());
        customer.setDepartTime(null);
        customerRepository.save(customer);
    }
    public void departQueue(String nic){
        List<Customer> customers;
        customers= (List<Customer>) customerRepository.findAllById(Collections.singleton(nic));
        for (Customer customer:customers){
        customer.setDepartTime(LocalDateTime.now().toString());
        customerRepository.save(customer);
        }
    }
    public void exitQueue(String nic){
        List<Customer> customers;
        customers= (List<Customer>) customerRepository.findAllById(Collections.singleton(nic));
        for (Customer customer:customers){
            customer.setArrivalTime(null);
            customer.setDepartTime(null);
            customerRepository.save(customer);
        }
    }
}
