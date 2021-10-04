package Berge_I.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Berge_I.domain.dto.AccountTypeDto;
import Berge_I.logic.flow.ModifyAccountTypeFlow;
import Berge_I.translator.AccountTypeTranslator;
import java.time.LocalDate;

@Component
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        return accountTypeTranslator.deleteAccountType();
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate) {
        return accountTypeTranslator.updateAccountType(mnemonic, newAccountTypeName, newCreationDate);
    }

    public boolean methodToTest() {
        return true;
    }
}

