package com.zakaria.digitalbanking.dtos;


import com.zakaria.digitalbanking.enums.AccountStatus;
import lombok.Data;

import java.util.Date;

@Data
// the class is abstract because we don't want to create a table for it
public  class CurrentBankAccountDTO extends BankAccountDTO {
    private String id;
    private  double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overdraft;

}
