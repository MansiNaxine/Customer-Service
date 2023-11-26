package com.example.Customer_Service.Service;

import com.example.Customer_Service.Feign.AccountService;
import com.example.Customer_Service.Model.Account;
import com.example.Customer_Service.Model.Customer;
import com.example.Customer_Service.Model.CustomerDto;
import com.example.Customer_Service.Repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AccountService feignAccountService;

    public List<Customer> getAll(){

        return (List<Customer>) customerRepo.findAll();
    }

    public Customer addCustomerData(Customer customer){

        return customerRepo.save(customer);
    }

    public CustomerDto findById(Integer customerId){

        Optional<Customer> customer=customerRepo.findById(customerId);
        CustomerDto customerDto=mapper.map(customer,CustomerDto.class);

        // Using FeignClient
        ResponseEntity<Account> account=feignAccountService.getIds(customerId);
        customerDto.setAccount(account.getBody());

        return customerDto;
    }



    public Customer updateAll(Customer customer)
    {
        return customerRepo.save(customer);
    }

    public Customer updateByCustomerName(Integer id,String customerName )
    {
        Customer cust=customerRepo.findById(id).get();
        cust.setCustomerName(customerName);
        return customerRepo.save(cust);
    }


}

