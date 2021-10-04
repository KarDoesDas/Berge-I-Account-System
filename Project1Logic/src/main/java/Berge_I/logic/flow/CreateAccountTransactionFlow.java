package Berge_I.logic.flow;

import Berge_I.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}
