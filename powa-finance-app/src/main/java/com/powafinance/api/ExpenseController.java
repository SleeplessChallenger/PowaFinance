package com.powafinance.api;

import com.powafinance.dto.Response;
import com.powafinance.persistence.table.ExpenseTable;
import com.powafinance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ExpenseController {
    private static final String EXPENSE_CREATION_API = "/add-expense";
    private static final String EXPENSE_RETRIEVAL_API = "/get-expense/{username}";

    private final ExpenseService expenseService;

    @GetMapping(path = EXPENSE_RETRIEVAL_API, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserExpense(@PathVariable @NotBlank String username) {
        final List<ExpenseTable> expenses = expenseService.getAllExpenses(username);
        if (expenses.isEmpty()) {
            return ResponseEntity.ok(Response.builder()
                    .responseCode(HttpStatus.NO_CONTENT.value())
                    .message(String.format("No expenses for user = %s", username))
                    .build()
            );
        }
        return ResponseEntity.ok(expenses);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> catchErrors(Exception ex) {
        final ErrorMessage error = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    }
}
