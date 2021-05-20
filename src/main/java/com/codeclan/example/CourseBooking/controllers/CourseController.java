package com.codeclan.example.CourseBooking.controllers;

import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRespository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRespository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/course/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRespository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRespository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
