package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.model.FlightBooking;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import com.cognizant.airline_ticket_reservation_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookingDetailsController {
    private FlightService flightService;
    private FlightScheduleService flightScheduleService;
    private FlightBookingService flightBookingService;
    private BookingService bookingService;
    private PassengerService passengerService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @Autowired
    public void setFlightBookingService(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/admin/admin-home/booking-details")
    public ModelAndView bookingDetails(ModelAndView modelAndView) {
        List<FlightBooking> flightBookings = flightBookingService.getFlightBookings();

        modelAndView.addObject("flightBookings", flightBookings);
        modelAndView.setViewName("admin/admin_home/booking-details");

        return modelAndView;
    }

    @GetMapping("/admin/admin/home/booking-details/view-booking/{flightBookingId}")
    public ModelAndView viewBooking(
            @PathVariable("flightBookingId") String flightBookingId,
            ModelAndView modelAndView
    ) {
        FlightBooking flightBooking = flightBookingService.getByFlightBookingId(flightBookingId);
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightBooking.getScheduledFlightId());
        Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());


        modelAndView.addObject("flightBooking", flightBooking);
        modelAndView.addObject("flightSchedule", flightSchedule);
        modelAndView.addObject("flight", flight);
        modelAndView.setViewName("admin/admin_home/booking_details/view-booking");

        return modelAndView;
    }
}
