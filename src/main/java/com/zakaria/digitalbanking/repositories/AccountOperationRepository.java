package com.zakaria.digitalbanking.repositories;

import com.zakaria.digitalbanking.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperationRepository,Long> {
}
