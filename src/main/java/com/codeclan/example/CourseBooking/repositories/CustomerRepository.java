package com.codeclan.example.CourseBooking.repositories;

import com.codeclan.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    List<Customer> findByBookingsCustomerName(String customerName);

    List<Customer> findByTownAndBookingsCourseName(String town, String courseName);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String courseName);

}
