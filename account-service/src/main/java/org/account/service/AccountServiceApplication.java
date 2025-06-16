package org.account.service;

import java.time.LocalDate;
import java.util.UUID;

import org.account.service.entities.BankAccount;
import org.account.service.enums.AccountType;
import org.account.service.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
        return args -> {
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*80000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(Long.valueOf(1))
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*65432)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(Long.valueOf(2))
                        .build();
                accountRepository.save(bankAccount1);
                accountRepository.save(bankAccount2);
            ;


        };
    }
}
