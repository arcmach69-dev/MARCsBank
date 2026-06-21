package com.marcsbank.account_service.service;

import com.marcsbank.account_service.dto.AccountResponse;
import com.marcsbank.account_service.dto.CreateAccountRequest;
import com.marcsbank.account_service.entity.Account;
import com.marcsbank.account_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private static final SecureRandom RANDOM = new SecureRandom();

    public AccountResponse createAccount(CreateAccountRequest request, Long userId, String userEmail) {
        String accountNumber = generateAccountNumber();

        Account account = Account.builder()
                .accountNumber(accountNumber)
                .userId(userId)
                .userEmail(userEmail)
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO)
                .status(Account.AccountStatus.ACTIVE)
                .build();

        accountRepository.save(account);

        return mapToResponse(account);
    }

    public List<AccountResponse> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public AccountResponse getAccountByNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found: " + accountNumber));
        return mapToResponse(account);
    }

    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private String generateAccountNumber() {
        String accountNumber;
        do {
            StringBuilder sb = new StringBuilder("MB");
            for (int i = 0; i < 10; i++) {
                sb.append(RANDOM.nextInt(10));
            }
            accountNumber = sb.toString();
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }

    private AccountResponse mapToResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .userId(account.getUserId())
                .userEmail(account.getUserEmail())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .status(account.getStatus())
                .createdAt(account.getCreatedAt())
                .build();
    }
}