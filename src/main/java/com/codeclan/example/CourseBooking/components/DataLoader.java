package com.codeclan.example.CourseBooking.components;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.BookingRepository;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Learning to be a mad bastard", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Enjoying your Ma's cooking", "Your Ma's house", 2);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Tim", "Edinburgh", 34);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Vitor", "Linlithgow", 33);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Malcolm", "Edinburgh", 45);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("20.05.21", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("20.05.21", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("20.05.21", course1, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("22.05.21", course1, customer3);
        bookingRepository.save(booking4);
    }
}
