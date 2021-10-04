package Berge_I.logic.flow.impl;

import Berge_I.domain.dto.AccountTransactionDto;
import Berge_I.domain.persistence.AccountTransaction;
import Berge_I.domain.persistence.AccountTransactionDetails;
import Berge_I.domain.persistence.AccountType;
import Berge_I.logic.flow.CreateAccountTransactionFlow;
import Berge_I.logic.flow.FetchAccountTypeFlow;
import Berge_I.translator.AccountTransactionTranslator;
import Berge_I.translator.AccountTransactionDetailsTranslator;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTransactionDetailsTranslator accountTransactionDetailsTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            AccountTransactionDetailsTranslator accountTransactionDetailsTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTransactionDetailsTranslator = accountTransactionDetailsTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }
    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {

        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if (null != accountTransactionDto.getDetails()){
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails()
                    .buildAccountTransactionDetails(createdAccountTransaction);
            accountTransactionDetailsTranslator.save(accountTransactionDetails);
        }
        return new AccountTransactionDto(createdAccountTransaction);
    }


}
