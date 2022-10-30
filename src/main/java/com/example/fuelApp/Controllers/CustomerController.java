package com.example.fuelApp.Controllers;

import com.example.fuelApp.Models.Customer;
import com.example.fuelApp.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/enterQueue")
    public void enterQueue(@RequestBody Customer customer){
        customerService.enterQueue(customer);
    }

    @PostMapping("/departQueue")
    public void departQueue(@RequestParam String nic){
        customerService.departQueue(nic);
    }

    @PostMapping("/exitQueue")
    public void exitQueue(@RequestParam String nic){
        customerService.exitQueue(nic);
    }
}
