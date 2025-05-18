package com.zakaria.digitalbanking.repositories;

import com.zakaria.digitalbanking.entities.AccountOperation;
import com.zakaria.digitalbanking.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
    public List<AccountOperation> findByBankAccountId(String accountId);
}
