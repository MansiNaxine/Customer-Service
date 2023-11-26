package com.example.Customer_Service.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Customer_Service.Model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}