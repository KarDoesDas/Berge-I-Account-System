package Berge_I.logic.flow.impl;

import Berge_I.domain.dto.AccountTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Berge_I.domain.dto.AccountTypeDto;
import Berge_I.logic.flow.FetchAccountTypeFlow;
import Berge_I.translator.AccountTypeTranslator;
import Berge_I.domain.persistence.AccountType;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountType getAccountTypeDbEntityByMnemonic(String mnemonic) {
        return null;
    } //Dto

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }

    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public AccountTransactionDto getAccountTransactionByMnemonic(Long transactionId) {
        return null;
    }

    public boolean methodToTest(){
        return true;
    }
}