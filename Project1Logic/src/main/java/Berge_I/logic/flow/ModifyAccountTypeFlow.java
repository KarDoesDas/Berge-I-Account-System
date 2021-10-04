package Berge_I.logic.flow;

import Berge_I.domain.dto.AccountTypeDto;

import java.time.LocalDate;

public interface ModifyAccountTypeFlow {
    AccountTypeDto deleteAccountType(String anyString);

    AccountTypeDto updateAccountType(String anyString, String anyString1, LocalDate any);
}
