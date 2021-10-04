package Berge_I.logic.flow;

import Berge_I.domain.dto.AccountTransactionDto;


import java.util.List;

public interface FetchAccountTransactionFlow {
    List<AccountTransactionDto> getAllAccountTransactions();


    AccountTransactionDto getAccountTransactionById(Long transactionId);


}
