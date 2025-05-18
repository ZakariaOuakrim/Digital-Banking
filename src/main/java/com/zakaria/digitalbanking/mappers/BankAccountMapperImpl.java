package com.zakaria.digitalbanking.mappers;

import com.zakaria.digitalbanking.dtos.CustomerDTO;
import com.zakaria.digitalbanking.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

//Map struct
@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

}
