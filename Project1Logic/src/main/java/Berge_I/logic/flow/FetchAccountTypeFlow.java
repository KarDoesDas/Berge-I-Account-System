package Berge_I.logic.flow;

import Berge_I.domain.dto.AccountTransactionDto;
import Berge_I.domain.dto.AccountTypeDto;
import Berge_I.domain.persistence.AccountType;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();

    AccountType getAccountTypeDbEntityByMnemonic(String mnemonic);
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTransactionDto getAccountTransactionById(Long transactionId);
    AccountTransactionDto getAccountTransactionByMnemonic(Long transactionId);


}