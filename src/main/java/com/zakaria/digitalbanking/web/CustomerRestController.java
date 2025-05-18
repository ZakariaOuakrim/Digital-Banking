package com.zakaria.digitalbanking.web;

import com.zakaria.digitalbanking.dtos.CustomerDTO;
import com.zakaria.digitalbanking.entities.Customer;
import com.zakaria.digitalbanking.exceptions.CustomerNotFoundException;
import com.zakaria.digitalbanking.sevices.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers() {
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name="id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return bankAccountService.saveCurstomer(customerDTO);
    }

}
