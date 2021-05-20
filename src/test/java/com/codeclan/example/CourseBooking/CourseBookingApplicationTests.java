package com.codeclan.example.CourseBooking;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.BookingRepository;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createBookingsCoursesAndCustomers() {

		Course course1 = new Course("Learning to be a mad bastard", "Edinburgh", 5);
		courseRepository.save(course1);

		Customer customer1 = new Customer("Tim", "Edinburgh", 34);
		Customer customer2 = new Customer("Vitor", "Linlithgow", 24);
		Customer customer3 = new Customer("Malcolm", "Edinburgh", 45);
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);

		Booking booking1 = new Booking("20.05.21", course1, customer1);
		Booking booking2 = new Booking("20.05.21", course1, customer2);
		Booking booking3 = new Booking("20.05.21", course1, customer3);
		bookingRepository.save(booking1);
		bookingRepository.save(booking2);
		bookingRepository.save(booking3);
	}

	@Test
	public void canFindByRating() {
		List<Course> foundCourses = courseRepository.findByRating(5);
		assertEquals("Learning to be a mad bastard", foundCourses.get(0).getName());
	}

	@Test
	public void canFindByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("20.05.21");
		assertEquals("20.05.21", foundBookings.get(0).getDate());
	}

	@Test
	public void canFindCustomerByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("20.05.21");
		assertEquals("Tim", foundBookings.get(0).getCustomer().getName());
	}

	@Test
    public void canFindCourseByBooking(){
		List<Course> foundCourses = courseRepository.findByBookingsCourseName("Learning to be a mad bastard");
		assertEquals("Edinburgh", foundCourses.get(0).getTown());
	}

	@Test
	public void canFindCustomerByBooking(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCustomerName("Tim");
		assertEquals("Edinburgh", foundCustomers.get(0).getTown());
	}

	@Test
	public void canFindCustomerTownByCourseName(){
		List<Customer> foundCustomers = customerRepository.findByTownAndBookingsCourseName("Edinburgh", "Learning to be a mad bastard");
		assertEquals("Tim", foundCustomers.get(0).getName());
		assertEquals("Malcolm", foundCustomers.get(1).getName());
	}

	@Test
	public void canFindCustomerByAgeAndTownAndCourseName(){
		List<Customer> foundCustomers = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(40, "Edinburgh", "Learning to be a mad bastard");
		assertEquals("Malcolm", foundCustomers.get(0).getName());
	}
}
