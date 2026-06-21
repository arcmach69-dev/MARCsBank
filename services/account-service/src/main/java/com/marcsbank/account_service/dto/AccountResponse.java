package com.marcsbank.account_service.dto;

import com.marcsbank.account_service.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private Long id;
    private String accountNumber;
    private Long userId;
    private String userEmail;
    private Account.AccountType accountType;
    private BigDecimal balance;
    private Account.AccountStatus status;
    private LocalDateTime createdAt;
}