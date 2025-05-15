package com.zakaria.digitalbanking.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CA")
@AllArgsConstructor @NoArgsConstructor @Data
public class CurrentAccount extends BankAccount{
    private double overDraft;
}
