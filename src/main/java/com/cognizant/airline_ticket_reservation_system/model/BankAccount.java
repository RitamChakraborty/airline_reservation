package com.cognizant.airline_ticket_reservation_system.model;

import javax.validation.constraints.NotNull;

public class BankAccount {
    private Integer bankId;
    @NotNull(message = "{error.bankAccount.accountNo}")
    private Long accountNo;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
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
                "bankName='" + bankId + '\'' +
                ", accountNo=" + accountNo +
                '}';
    }
}
