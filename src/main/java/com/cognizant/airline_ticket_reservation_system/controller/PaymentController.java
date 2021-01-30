package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class PaymentController {
    private BankService bankService;
    private AccountService accountService;
    private FlightBookingService flightBookingService;
    private BookingService bookingService;
    private PassengerService passengerService;

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
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

    @GetMapping("/user/user-home/book-ticket/payment")
    public ModelAndView payment(@ModelAttribute("bankAccount") BankAccount bankAccount) {
        return new ModelAndView("user/user_home/book_ticket/payment");
    }

    @PostMapping("/user/user-home/book-ticket/payment")
    public ModelAndView payment(
            @Valid @ModelAttribute("bankAccount") BankAccount bankAccount,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        int cost = ticket.getCost();

        if (bankAccount.getAccountNo() != null) {
            Account account = accountService.getAccountByAccountNo(bankAccount.getAccountNo());

            if (account == null) {
                bindingResult.rejectValue("accountNo", "error.account.accountNo.inValid");
            } else if (!bankAccount.getBankId().equals(account.getBankId())) {
                bindingResult.rejectValue("accountNo", "error.account.accountNo.noAssociated");
            } else if (account.getBalance() < cost) {
                bindingResult.rejectValue("accountNo", "error.account.balance.insufficient");
            }
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/user_home/book_ticket/payment");
            return modelAndView;
        }

        String flightBookingId;

        if (ticket.getFlightIsScheduled()) {
            flightBookingId = ticket.getFlightBookingId();
        } else {
            flightBookingId = UUID.randomUUID().toString();
        }

        // Object creation
        FlightBooking flightBooking = new FlightBooking();
        flightBooking.setId(flightBookingId);
        flightBooking.setDate(ticket.getDate());
        flightBooking.setScheduledFlightId(ticket.getFlightSchedule().getId());
        flightBooking.setEconomySeatsAvailable(ticket.getEconomySeatsAvailable());
        flightBooking.setBusinessSeatsAvailable(ticket.getBusinessSeatsAvailable());

        if (ticket.getFlightIsScheduled()) {
            // Update flightBooking in the database
            flightBookingService.updateFlightBooking(flightBooking);
        } else {
            // Save flightBooking in the database
            flightBookingService.saveFlightBooking(flightBooking);
        }

        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking();
        booking.setId(bookingId);
        booking.setFlightBookingId(flightBookingId);
        booking.setUserId(ticket.getUser().getId());

        // Save booking in the database
        bookingService.saveBooking(booking);

        for (Passenger passenger : ticket.getPassengers()) {
            passenger.setBookingId(bookingId);
        }

        // Save all passengers in the database
        passengerService.saveAllPassengers(ticket.getPassengers());

        // Reduce balance
        Account account = accountService.getAccountByAccountNo(bankAccount.getAccountNo());
        account.setBalance(account.getBalance() - cost);
        accountService.updateAccount(account);

        modelAndView.setViewName("redirect:/user/user-home/book-ticket/payment-successful");

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/payment-successful")
    public ModelAndView paymentSuccessful(HttpServletRequest request) {
        // Remove ticket session
        request.getSession().removeAttribute("ticket");
        return new ModelAndView("user/user_home/book_ticket/payment-successful");
    }

    @ModelAttribute("banks")
    public Map<Integer, String> banks() {
        return bankService.getBanks()
                .stream()
                .collect(Collectors.toMap(Bank::getId, Bank::getBankName));
    }
}
