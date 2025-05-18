package com.zakaria.digitalbanking.sevices;

import com.zakaria.digitalbanking.dtos.BankAccountDTO;
import com.zakaria.digitalbanking.dtos.CurrentBankAccountDTO;
import com.zakaria.digitalbanking.dtos.CustomerDTO;
import com.zakaria.digitalbanking.dtos.SavingBankAccountDTO;
import com.zakaria.digitalbanking.entities.BankAccount;
import com.zakaria.digitalbanking.entities.CurrentAccount;
import com.zakaria.digitalbanking.entities.Customer;
import com.zakaria.digitalbanking.entities.SavingAccount;
import com.zakaria.digitalbanking.exceptions.BalanceNotSufficientException;
import com.zakaria.digitalbanking.exceptions.BankAccountNotFoundException;
import com.zakaria.digitalbanking.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCurstomer(CustomerDTO customer);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String customerId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;


    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long id) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long id);
}
