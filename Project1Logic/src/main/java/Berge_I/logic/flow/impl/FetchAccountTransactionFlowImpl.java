package Berge_I.logic.flow.impl;

import Berge_I.domain.dto.AccountTransactionDto;
import Berge_I.domain.persistence.AccountTransaction;
import Berge_I.logic.flow.FetchAccountTransactionFlow;
import Berge_I.translator.AccountTransactionTranslator;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;




@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow{

    private AccountTransactionTranslator translator;

    private FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator) {
        this.translator = translator;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions(){
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for(AccountTransaction accountTransaction : translator.getAllAccountTransactions()){
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }
        return accountTransactionDtos;
    }

    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionId){
        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionId);
        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;
    }




}
