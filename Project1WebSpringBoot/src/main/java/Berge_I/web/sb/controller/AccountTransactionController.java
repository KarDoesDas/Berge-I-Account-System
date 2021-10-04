package Berge_I.web.sb.controller;

import Berge_I.domain.dto.AccountTransactionDto;
import Berge_I.domain.dto.AccountTypeDto;
import Berge_I.domain.service.GeneralResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Berge_I.logic.flow.FetchAccountTransactionFlow;
import Berge_I.logic.flow.CreateAccountTransactionFlow;
//import Berge_I.logic.flow.ModifyAccountTransactionFlow;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccounttransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow){
        this.createAccountTransactionFlow = createAccounttransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }


    @GetMapping("account-transaction")     //symbol
    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.",
                    required = true)
            @PathVariable AccountTransactionDto AccountTransaction) {
        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/all")     //symbol
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of Account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> accountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, accountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")     //symbol
    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The Transaction that uniquely identifies the AccountTransaction.",
                    example = "50002",
                    name = "transactionId",
                    required = true)
            @PathVariable("transactionId") final Long transactionId) {
        AccountTransactionDto accountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
