package com.zakaria.digitalbanking.sevices;

import com.zakaria.digitalbanking.entities.BankAccount;
import com.zakaria.digitalbanking.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCurstomer(Customer customer);
    BankAccount saveBankAccount(double initialeBalance, String accountType, Long customerId);
    List<Customer> listCustomers();
    BankAccount getBankAccount(String customerId);
    void debit(String accountId, double amount, String description);
    void credit(String accountId, double amount, String description);
    void transfer(String accountIdSource, String accountIdDestination, double amount);



}
