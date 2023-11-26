package com.example.Customer_Service.Controller;

import com.example.Customer_Service.Model.Customer;
import com.example.Customer_Service.Model.CustomerDto;
import com.example.Customer_Service.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class Controller {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll(){

        List<Customer> lt=customerService.getAll();

        return new ResponseEntity<List<Customer>>(lt, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomerData(@Valid @RequestBody Customer customer){

        Customer cs=customerService.addCustomerData(customer);
        return new ResponseEntity<Customer>(cs,HttpStatus.CREATED);
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("customerId") Integer customerId){
        //Customer ac=customerService.findById(id);
        return new ResponseEntity<>(customerService.findById(customerId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateAll(@RequestBody Customer customer){

        Customer acc=customerService.updateAll(customer);
        return new ResponseEntity<Customer>(acc,HttpStatus.CREATED);

    }

    @PatchMapping("/update/{id}/{customerName}")
    public ResponseEntity<Customer> updateByCustomerName(@PathVariable("id") Integer id,@PathVariable("customerName") String customerName){
        Customer lau=customerService.updateByCustomerName(id,customerName);
        return new ResponseEntity<Customer>(lau,HttpStatus.OK);
    }


}
