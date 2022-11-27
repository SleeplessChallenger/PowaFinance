package com.powafinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private Long id;
    @NotNull
    private Number amount;
    @NotNull
    private OffsetDateTime date;
    private String expenseReason;
}
