package com.example.simpotelHotelBooking.Models;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class SimplotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String hotelName;

    private Double price;

    private Date startDate;

    private Date endDate;
}
