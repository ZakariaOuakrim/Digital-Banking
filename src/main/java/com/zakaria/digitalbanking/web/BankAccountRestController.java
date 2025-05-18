package com.zakaria.digitalbanking.web;

import com.zakaria.digitalbanking.dtos.AccountOperationDTO;
import com.zakaria.digitalbanking.dtos.BankAccountDTO;
import com.zakaria.digitalbanking.exceptions.BankAccountNotFoundException;
import com.zakaria.digitalbanking.sevices.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/accounts/{id}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts() {
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.history(accountId);
    }
}
