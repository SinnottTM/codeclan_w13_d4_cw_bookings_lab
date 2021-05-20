package com.codeclan.example.CourseBooking.controllers;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

//    @GetMapping(value = "/bookings")
//    public ResponseEntity<List<Booking>> getAllBookings(){
//        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
//    }


    @GetMapping(value = "/bookings")
    public ResponseEntity getAllBookingsAndFilter(
            @RequestParam(required = false, name = "date") String date
    ){
//      GET  /bookings?date=20.05.21
        if (date != null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

//    @GetMapping(value = "/distilleries")
//    public ResponseEntity getAllDistilleriesAndFilters(
//            @RequestParam(required = false, name = "region") String region,
//            @RequestParam(required = false, name = "whiskyAge") Integer whiskyAge
//
//    ){
//        // GET  /distilleries?region=Speyside
//        if (region != null){
//            return new ResponseEntity(distillaryRepository.findDistillerysByRegion(region), HttpStatus.OK);
//        }
//        // GET /distilleries?whiskyAge=12
//        if (whiskyAge != null){
//            return new ResponseEntity(distillaryRepository.findDistilleriesByWhiskiesAgeGreaterThan(whiskyAge), HttpStatus.OK);
//        }
//        // GET /distilleries
//        return new ResponseEntity(distillaryRepository.findAll(), HttpStatus.OK);
//    }

}
