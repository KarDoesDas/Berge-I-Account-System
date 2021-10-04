package Berge_I.translator.impl;

import Berge_I.domain.persistence.AccountTransactionDetails;
import Berge_I.translator.AccountTransactionDetailsTranslator;
import org.springframework.stereotype.Component;
import Berge_I.repo.persistence.AccountTransactionDetailsRepository;




@Component
public class AccountTransactionDetailsTranslatorImpl implements AccountTransactionDetailsTranslator {
    private AccountTransactionDetailsRepository  repo;

    public AccountTransactionDetailsTranslatorImpl(AccountTransactionDetailsRepository accountTransactionDetailsRepository){
        this.repo = accountTransactionDetailsRepository;
    }

    @Override
    public AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails){
        try{
            return repo.save(accountTransactionDetails);
        }catch (Exception e){
            throw new RuntimeException("unable to save to the DB", e);
        }
    }
}
