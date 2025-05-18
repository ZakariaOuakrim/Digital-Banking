package com.zakaria.digitalbanking.web;

import com.zakaria.digitalbanking.entities.Customer;
import com.zakaria.digitalbanking.sevices.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<Customer> customers() {
        return bankAccountService.listCustomers();
    }
}
