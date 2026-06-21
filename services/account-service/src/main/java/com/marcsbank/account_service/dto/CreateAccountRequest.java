package com.marcsbank.account_service.dto;

import com.marcsbank.account_service.entity.Account;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAccountRequest {

    @NotNull(message = "Account type is required")
    private Account.AccountType accountType;
}