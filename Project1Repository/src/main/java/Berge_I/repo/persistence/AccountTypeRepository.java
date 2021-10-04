package Berge_I.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Berge_I.domain.persistence.AccountType;
import Berge_I.domain.dto.AccountTypeDto;

@Repository
public interface AccountTypeRepository extends JpaRepository< AccountType, Long> {


//    @Query(value = "SELECT new Berge_I.domain.dto.AccountTypeDto( " +
//            "        at.mnemonic," +
//            "        at.accountTypeName," +
//            "        at.creationDate )" +
//            "    FROM " +
//            "        AccountType at" +
//            "    WHERE at.mnemonic = :mnemonic ")
//    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


    @Query(value = "SELECT " +
            "        at " +
            "        FROM " +
            "        AccountType at " +

            "    WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

}
