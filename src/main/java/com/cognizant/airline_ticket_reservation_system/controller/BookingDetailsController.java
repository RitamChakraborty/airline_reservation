package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookingDetailsController {
    private FlightService flightService;
    private FlightScheduleService flightScheduleService;
    private FlightBookingService flightBookingService;
    private BookingService bookingService;
    private PassengerService passengerService;
    private UserService userService;

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

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/admin-home/booking-details")
    public ModelAndView bookingDetails(
            @ModelAttribute("flightBookingFilter") FlightBookingFilter flightBookingFilter,
            ModelAndView modelAndView
    ) {
        List<FlightBooking> flightBookings = flightBookingService.getFlightBookings();
        flightBookings.forEach(i -> {
            i.setFlightSchedule(flightScheduleService.getFlightScheduleById(i.getScheduledFlightId()));
            i.getFlightSchedule().setFlight(flightService.getFlightByNo(i.getFlightSchedule().getFlightNo()));
        });

        modelAndView.addObject("flightBookings", flightBookings);
        modelAndView.setViewName("admin/admin_home/booking-details");

        return modelAndView;
    }

    @PostMapping("/admin/admin-home/booking-details")
    public ModelAndView bookingDetails(
            @RequestParam(value = "msg", required = false) String message,
            @ModelAttribute("flightBookingFilter") FlightBookingFilter flightBookingFilter,
            ModelAndView modelAndView
    ) {
        List<FlightBooking> flightBookings = flightBookingService.getFlightBookings();

        flightBookings.forEach(i -> {
            i.setFlightSchedule(flightScheduleService.getFlightScheduleById(i.getScheduledFlightId()));
            i.getFlightSchedule().setFlight(flightService.getFlightByNo(i.getFlightSchedule().getFlightNo()));
        });

        // Reset request
        if (message == null) {
            // Filter date
            if (flightBookingFilter.getDate() != null) {
                flightBookings = flightBookings.stream()
                        .filter(i -> i.getDate().equals(flightBookingFilter.getDate()))
                        .collect(Collectors.toList());
            }

            // Filter flight no
            if (flightBookingFilter.getFlightNo() != null) {
                flightBookings = flightBookings.stream()
                        .filter(i -> i.getFlightSchedule().getFlightNo().equals(flightBookingFilter.getFlightNo()))
                        .collect(Collectors.toList());
            }

            // Filter source
            if (flightBookingFilter.getSource() != null) {
                flightBookings = flightBookings.stream()
                        .filter(i -> i.getFlightSchedule().getSource().equals(flightBookingFilter.getSource()))
                        .collect(Collectors.toList());
            }

            // Filter destination
            if (flightBookingFilter.getDestination() != null) {
                flightBookings = flightBookings.stream()
                        .filter(i -> i.getFlightSchedule().getDestination().equals(flightBookingFilter.getDestination()))
                        .collect(Collectors.toList());
            }
        }

        modelAndView.addObject("flightBookings", flightBookings);
        modelAndView.setViewName("admin/admin_home/booking-details");

        return modelAndView;
    }

    @GetMapping("/admin/admin/home/booking-details/view-booking/{flightBookingId}")
    public ModelAndView viewBooking(
            @PathVariable("flightBookingId") String flightBookingId,
            ModelAndView modelAndView
    ) {
        FlightBooking flightBooking = flightBookingService.getFlightBookingByFlightBookingId(flightBookingId);
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightBooking.getScheduledFlightId());
        Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());
        List<Booking> bookings = bookingService.getBookingsByFlightBookingId(flightBookingId);

        modelAndView.addObject("flightBooking", flightBooking);
        modelAndView.addObject("flightSchedule", flightSchedule);
        modelAndView.addObject("flight", flight);
        modelAndView.addObject("bookings", bookings);
        modelAndView.setViewName("admin/admin_home/booking_details/view-booking");

        return modelAndView;
    }

    @GetMapping("/admin/admin-home/booking-details/booking-information/{bookingId}")
    public ModelAndView bookingInformation(
            @PathVariable("bookingId") String bookingId,
            ModelAndView modelAndView
    ) {
        Booking booking = bookingService.getBookingByBookingId(bookingId);
        User user = userService.getUserById(booking.getUserId());
        List<Passenger> passengers = passengerService.getPassengersByBookingId(bookingId);

        modelAndView.addObject("booking", booking);
        modelAndView.addObject("user", user);
        modelAndView.addObject("passengers", passengers);
        modelAndView.setViewName("admin/admin_home/booking_details/booking-information");

        return modelAndView;
    }

    @ModelAttribute("sources")
    private List<String> sources(@Value("#{'${flightSchedule.sources}'.split(',')}") List<String> sources) {
        return sources;
    }

    @ModelAttribute("destinations")
    private List<String> destinations(@Value("#{'${flightSchedule.destinations}'.split(',')}") List<String> destinations) {
        return destinations;
    }

    @ModelAttribute("flights")
    public List<Integer> flights() {
        return flightService.getFlights()
                .stream()
                .map(Flight::getNo)
                .collect(Collectors.toList());
    }
}
