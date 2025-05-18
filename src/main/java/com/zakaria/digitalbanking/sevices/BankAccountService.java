package com.zakaria.digitalbanking.sevices;

import com.zakaria.digitalbanking.entities.BankAccount;
import com.zakaria.digitalbanking.entities.CurrentAccount;
import com.zakaria.digitalbanking.entities.Customer;
import com.zakaria.digitalbanking.entities.SavingAccount;
import com.zakaria.digitalbanking.exceptions.BalanceNotSufficientException;
import com.zakaria.digitalbanking.exceptions.BankAccountNotFoundException;
import com.zakaria.digitalbanking.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCurstomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String customerId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;



}
