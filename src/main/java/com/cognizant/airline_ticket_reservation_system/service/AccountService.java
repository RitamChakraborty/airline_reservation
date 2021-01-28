package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.AccountDao;
import com.cognizant.airline_ticket_reservation_system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account getAccountByAccountNo(Long accountNo) {
        return accountDao.findById(accountNo).orElse(null);
    }

    public void updateAccount(Account account) {
        accountDao.save(account);
    }
}
