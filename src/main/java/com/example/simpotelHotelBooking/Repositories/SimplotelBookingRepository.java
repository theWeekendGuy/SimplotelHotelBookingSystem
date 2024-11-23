package com.example.simpotelHotelBooking.Repositories;

import com.example.simpotelHotelBooking.Models.SimplotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimplotelBookingRepository extends JpaRepository<SimplotelBooking, Long> {
}
