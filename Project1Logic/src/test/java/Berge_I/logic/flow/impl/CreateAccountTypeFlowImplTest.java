package Berge_I.logic.flow.impl;

import Berge_I.domain.dto.AccountTypeDto;

import Berge_I.translator.AccountTypeTranslator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

//import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
//public class CreateAccountTypeFlowImplTest {
//
//    private AccountTypeTranslator translator;
//    private CreateAccountTypeFlowImpl flow;
//
//    @Before
//    public void setUp() throws Exception {
//        translator = Mockito.mock(AccountTypeTranslator.class); //Long
//        flow = new CreateAccountTypeFlowImpl(translator);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void create() {
//        flow.create(new AccountTypeDto());
//    }
//}

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        doThrow(new RuntimeException()).when(translator).someMethod(); //when void throw exception
        extracted();
        verify(translator, times(1)).someMethod();
        verify(translator, never()).create(any(AccountTypeDto.class));

    }

    private void extracted() {
        try{
            flow.create(new AccountTypeDto()); // ctrl ult m to extract method
            fail("Should throw an exception");
        }  catch (Exception e) {

        }
    }


}