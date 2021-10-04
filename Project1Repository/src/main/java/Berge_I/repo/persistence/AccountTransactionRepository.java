package Berge_I.repo.persistence;


import Berge_I.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Berge_I.domain.persistence.AccountTransaction;

import java.util.Optional;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long>{
    @Query(value = "SELECT " +
            "        at " +
            "        FROM " +
            "        AccountType at " +

            "    WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

}
