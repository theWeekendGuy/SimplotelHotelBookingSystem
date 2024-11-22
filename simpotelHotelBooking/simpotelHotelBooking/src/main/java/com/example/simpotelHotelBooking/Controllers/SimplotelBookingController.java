package com.example.simpotelHotelBooking.Controllers;

import com.example.simpotelHotelBooking.Models.SimplotelBooking;
import com.example.simpotelHotelBooking.Services.SimplotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/simplotel/booking/")
public class SimplotelBookingController {

    @Autowired
    private SimplotelBookingService simplotelBookingService;

    @GetMapping("/listAll")
    public List<SimplotelBooking> getAllBookings(){
        return simplotelBookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimplotelBooking> getBookingById(@PathVariable Long id) {
        SimplotelBooking simplotelBooking=simplotelBookingService.getBookingById(id);
        if(simplotelBooking != null) {
            return ResponseEntity.ok(simplotelBooking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<SimplotelBooking> createBooking(@RequestBody SimplotelBooking simplotelBooking) {
        SimplotelBooking savedSimplotelBooking= simplotelBookingService.saveBooking(simplotelBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSimplotelBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        simplotelBookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SimplotelBooking> updateBooking(@RequestBody SimplotelBooking simplotelBooking, @PathVariable Long id) {
        SimplotelBooking existingSimplotelBooking=simplotelBookingService.getBookingById(id);
        if(existingSimplotelBooking != null) {
            simplotelBooking.setId(id);
            SimplotelBooking updatedBooking= simplotelBookingService.saveBooking(simplotelBooking);
            return ResponseEntity.ok(updatedBooking);
        }
        return ResponseEntity.notFound().build();
    }

}
