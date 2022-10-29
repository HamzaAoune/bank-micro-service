package com.example.bankmicroservice.mappers;

import com.example.bankmicroservice.dto.BankAccountResponseDTO;
import com.example.bankmicroservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);

        return bankAccountResponseDTO;
    }
}
