package Berge_I.repo.persistence;

import Berge_I.domain.persistence.AccountTransactionDetails;
import Berge_I.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionDetailsRepository extends JpaRepository<AccountTransactionDetails, Long> {
    @Query(value = "SELECT " +
            "        at " +
            "        FROM " +
            "        AccountType at " +

            "    WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);
}
