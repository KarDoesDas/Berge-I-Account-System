package Berge_I.translator;


import Berge_I.domain.persistence.AccountTransaction;
import Berge_I.domain.dto.AccountTransactionDto;
import java.time.LocalDate;
import java.util.List;

public interface AccountTransactionTranslator {
    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);

    AccountTransactionDto getAccountTypeDbEntityByMnemonic(String mnemonic);
}
