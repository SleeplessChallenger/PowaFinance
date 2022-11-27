package com.powafinance.persistence.repository;

import com.powafinance.persistence.table.ExpenseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseTable, Long> {

    @Query(value = "select e.* from {h-schema}expenses e join users u on u.id = e.user_id " +
            "where u.username = :username", nativeQuery = true)
    List<ExpenseTable> findUserExpense(@Param("username") String username);
}
