package generics.bank;

import java.math.BigDecimal;

public class Account<T extends Currency> implements Balance {
    private String accountNumber;
    private BigDecimal accountBalance;
    private String currency;

    public Account(String accountNumber, BigDecimal accountBalance, String currency) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

    @Override
    public BigDecimal getBalance() {
        return accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getCurrency() {
        return currency;
    }
}
