package com.zakaria.digitalbanking.dtos;


import lombok.Data;

@Data
public class DebitDTO {
    private String accountId;
    private double Amount;
    private String description;
}