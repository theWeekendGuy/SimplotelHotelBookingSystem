package com.example.simpotelHotelBooking.Services;

import com.example.simpotelHotelBooking.Models.SimplotelBooking;
import com.example.simpotelHotelBooking.Repositories.SimplotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplotelBookingService {

    @Autowired
    private SimplotelBookingRepository simplotelBookingRepository;

    public List<SimplotelBooking> getAllBooking() {
        return simplotelBookingRepository.findAll();
    }

    public SimplotelBooking getBookingById(Long id) {
        return simplotelBookingRepository.findById(id).orElse(null);
    }

    public SimplotelBooking saveBooking(SimplotelBooking simplotelBooking) {
        return simplotelBookingRepository.save(simplotelBooking);
    }

    public void deleteBooking(Long id) {
        simplotelBookingRepository.deleteById(id);
    }
}
