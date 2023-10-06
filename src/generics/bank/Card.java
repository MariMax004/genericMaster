package generics.bank;

import java.math.BigDecimal;

public class Card<T extends Currency> implements Balance {

    private String cardNumber;
    private BigDecimal cardBalance;
    private String currency;

    public Card(String cardNumber, BigDecimal cardBalance, String currency) {
        this.cardNumber = cardNumber;
        this.cardBalance = cardBalance;
        this.currency = currency;
    }

    @Override
    public BigDecimal getBalance() {
        return cardBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCurrency() {
        return currency;
    }
}
