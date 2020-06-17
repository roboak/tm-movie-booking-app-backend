package com.upgrad.mtb.controllers;

import com.upgrad.mtb.beans.Booking;
import com.upgrad.mtb.exceptions.BookingDetailsNotFoundException;
import com.upgrad.mtb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @RequestMapping(value= {"/sayHelloBooking"},method= RequestMethod.GET)
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<String>("Hello World To All From BookingController", HttpStatus.OK);
    }

    //BOOKING CONTROLLER
    @PostMapping(value="/newBooking",consumes= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    void newBooking(@RequestBody Booking booking) {
        bookingService.acceptBookingDetails(booking);
    }

    @GetMapping("/getBookingDetails")
    public Booking getBookingDetails(@RequestParam int id) throws BookingDetailsNotFoundException {
        System.out.println(bookingService.getBookingDetails(id));
        return bookingService.getBookingDetails(id);
    }

    @RequestMapping(value="/getAllBookingDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public List<Booking> findAllBookings() {
        return bookingService.getAllBookingDetails();
    }

    @DeleteMapping("/deleteBooking")
    public ResponseEntity<String> removeBookingDetails(@RequestParam int id) throws BookingDetailsNotFoundException{
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Booking details successfully removed ",HttpStatus.OK);
    }
}
