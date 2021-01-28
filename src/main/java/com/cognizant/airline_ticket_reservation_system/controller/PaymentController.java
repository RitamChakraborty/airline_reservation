package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Account;
import com.cognizant.airline_ticket_reservation_system.model.Bank;
import com.cognizant.airline_ticket_reservation_system.model.BankAccount;
import com.cognizant.airline_ticket_reservation_system.model.Ticket;
import com.cognizant.airline_ticket_reservation_system.service.AccountService;
import com.cognizant.airline_ticket_reservation_system.service.BankService;
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
import java.util.stream.Collectors;

@Controller
public class PaymentController {
    private BankService bankService;
    private AccountService accountService;

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/user/user-home/book-ticket/payment")
    public ModelAndView payment(
            @ModelAttribute("bankAccount") BankAccount bankAccount,
            HttpServletRequest request
    ) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        System.out.println(ticket);
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

        // Reduce balance
        Account account = accountService.getAccountByAccountNo(bankAccount.getAccountNo());
        account.setBalance(account.getBalance() - cost);
        accountService.updateAccount(account);

        modelAndView.setViewName("redirect:/user/user-home/book-ticket/payment-successful");

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/payment-successful")
    public ModelAndView paymentSuccessful() {
        return new ModelAndView("user/user_home/book_ticket/payment-successful");
    }

    @ModelAttribute("banks")
    public Map<Integer, String> banks() {
        return bankService.getBanks()
                .stream()
                .collect(Collectors.toMap(Bank::getId, Bank::getBankName));
    }
}
