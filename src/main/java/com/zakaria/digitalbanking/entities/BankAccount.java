package com.zakaria.digitalbanking.entities;

import com.zakaria.digitalbanking.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@AllArgsConstructor @NoArgsConstructor @Data
// the class is abstract because we don't want to create a table for it
public abstract class BankAccount {
    @Id
    private String id;
    private  double balance;
    private Date createdAt;
    // this annotation is used so we will store the status as string not integer
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperation;
}
