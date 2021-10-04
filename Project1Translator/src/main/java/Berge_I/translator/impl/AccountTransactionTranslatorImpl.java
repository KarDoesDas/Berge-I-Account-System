package Berge_I.translator.impl;

import Berge_I.domain.dto.AccountTransactionDto;
import Berge_I.domain.persistence.AccountTransaction;
import Berge_I.repo.persistence.AccountTransactionRepository;
import Berge_I.translator.AccountTransactionTranslator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction){
        try {
            return repo.save(accountTransaction);
        }catch (Exception e) {
            throw new RuntimeException("unable to save to the DB", e);
        }
    }


    @Override
    public List<AccountTransaction> getAllAccountTransactions(){
        List<AccountTransaction> accountTransactions;
        try {
            accountTransactions = new ArrayList<>(repo.findAll());
        }catch (Exception e) {
            throw new RuntimeException("unable to save to the DB", e);
        }
        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId){
        try {
            return repo.findById(transactionId).orElse(null);
        }catch (Exception e) {
            throw new RuntimeException("unable to save to the DB", e);
        }
    }

    @Override
    public AccountTransactionDto getAccountTypeDbEntityByMnemonic(String mnemonic) {
        return null;
    }
}
