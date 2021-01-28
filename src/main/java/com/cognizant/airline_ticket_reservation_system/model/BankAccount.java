package com.cognizant.airline_ticket_reservation_system.model;

import javax.validation.constraints.NotNull;

public class BankAccount {
    private String bankName;
    @NotNull(message = "{error.bankAccount.accountNo}")
    private Long accountNo;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankName='" + bankName + '\'' +
                ", accountNo=" + accountNo +
                '}';
    }
}
