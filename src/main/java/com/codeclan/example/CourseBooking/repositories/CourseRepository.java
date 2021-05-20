package com.codeclan.example.CourseBooking.repositories;

import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(int rating);

    List<Course> findByBookingsCourseName(String courseName);

}
