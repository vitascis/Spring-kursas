package com.springdemo.rest;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    //    Autowired customer service
    @Autowired
    private CustomerService customerService;

    //     add mapping for get/customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //    add mappoing for get / customers / {customer Id}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Id not found - " + customerId);
        }
        return customer;
    }

    //    add mapping for post / customers - add new customers
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
//         just in case client will pass id in json, set id to 0
//        this will force to save new item instead of update
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    //    add mapping for put/ customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    //    add mapping for delete/customers/customerId - deletes existing customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

//        test uif such customer exists
        Customer customer = customerService.getCustomer(customerId);

//    throw exception if nul
        if (customer == null) {
            throw new CustomerNotFoundException("customer Id " + customerId +  " not found");
        }
//        if exists -> return message that deletes successfully
            customerService.deleteCustomer(customerId);
            return "Deleted customer Id - " + customerId;
        }

    }
