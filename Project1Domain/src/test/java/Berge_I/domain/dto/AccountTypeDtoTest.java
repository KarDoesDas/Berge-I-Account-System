package Berge_I.domain.dto;

import org.junit.Assert;
import org.junit.Test;

public class AccountTypeDtoTest {
    @Test
    public void getMnemonic(){
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        Assert.assertNull(accountTypeDto.getMnemonic());
    }

}
