package Berge_I.translator;

import Berge_I.domain.persistence.AccountTransactionDetails;

public interface AccountTransactionDetailsTranslator {
    AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails);
}
