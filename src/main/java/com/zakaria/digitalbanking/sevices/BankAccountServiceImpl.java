package com.zakaria.digitalbanking.sevices;

import com.zakaria.digitalbanking.entities.BankAccount;
import com.zakaria.digitalbanking.entities.CurrentAccount;
import com.zakaria.digitalbanking.entities.Customer;
import com.zakaria.digitalbanking.entities.SavingAccount;
import com.zakaria.digitalbanking.exceptions.CustomerNotFoundException;
import com.zakaria.digitalbanking.repositories.AccountOperationRepository;
import com.zakaria.digitalbanking.repositories.BankAccountRepository;
import com.zakaria.digitalbanking.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
//journalisation
@Slf4j
public class BankAccountServiceImpl implements BankAccountService{

    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
    private CustomerRepository customerRepository;


    @Override
    public Customer saveCurstomer(Customer customer) {
        log.info("Saving new Customer");
        Customer savedCustomer=customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String accountType, Long customerId) {
        Customer customer=customerRepository.findById(customerId).orElse(null);
        if(customer==null){
            throw new CustomerNotFoundException("Customer not found");
        }

        BankAccount bankAccount;
        if(accountType.equals("current")){
            bankAccount=new CurrentAccount();
        }else{
            bankAccount=new SavingAccount();
        }
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setBalance(initialBalance);

        return null;
    }

    @Override
    public List<Customer> listCustomers() {
        return List.of();
    }

    @Override
    public BankAccount getBankAccount(String customerId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {

    }
}
