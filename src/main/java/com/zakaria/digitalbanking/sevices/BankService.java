package com.zakaria.digitalbanking.sevices;

import com.zakaria.digitalbanking.entities.BankAccount;
import com.zakaria.digitalbanking.entities.CurrentAccount;
import com.zakaria.digitalbanking.entities.SavingAccount;
import com.zakaria.digitalbanking.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter() {
        BankAccount bankAccount =
                bankAccountRepository.findById("036b0f3e-8bf1-45f1-838d-8632cc600b9f").orElse(null);
        if (bankAccount != null) {
            System.out.println("*****************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft=>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperation().forEach(op -> {
                System.out.println(op.getOperationType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }

    }
}
