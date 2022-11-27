package com.powafinance.service;

import com.powafinance.persistence.repository.ExpenseRepository;
import com.powafinance.persistence.table.ExpenseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public List<ExpenseTable> getAllExpenses(String username) {
        return expenseRepository.findUserExpense(username);
    }
}
