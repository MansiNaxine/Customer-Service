package com.example.Customer_Service.Feign;
import com.example.Customer_Service.Model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "ACCOUNT-SERVICE", url = "http://localhost:8082")
public interface AccountService {

    @GetMapping("/account/id/{customerId}")
    public ResponseEntity<Account> getIds(@PathVariable("customerId") int customerId);


}
