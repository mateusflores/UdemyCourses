package model.entities;

import model.exceptions.DepositException;
import model.exceptions.WithdrawException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws WithdrawException {
        if (withdrawLimit <= 0) {
            throw new WithdrawException("The withdraw limit must be higher than 0");
        }

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit (Double amount) throws DepositException{
        if (amount < 0) {
            throw new DepositException("The deposit must be higher than zero.");
        }

        this.balance += amount;
    }

    public void withDraw (Double amount) throws WithdrawException {
        if (amount > this.withdrawLimit) {
            throw new WithdrawException("The amount exceeds withdraw limit.");
        }
        if (amount > this.balance) {
            throw new WithdrawException("Not enough balance.");
        }

        this.balance -= amount;
    }
}
