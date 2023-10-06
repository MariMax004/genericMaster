package generics.bank;

import java.math.BigDecimal;
import java.util.Random;


public final class RandomClientFactory {
    private Random random = new Random();

    public Client nextClient() {
        Client client = new Client("Random client");
        Integer accountCount = getRandomValue(3);
        Integer cardCount = getRandomValue(3);
        for (int i = 0; i < accountCount; i++) {
            Integer currencyRandom = getRandomValue(2);
            switch (currencyRandom) {
                case 0:
                    client.addAccount(new Account<USD>(getRandomAccountCardNumber(), getRandomBalance(), "USD"));
                case 1:
                    client.addAccount(new Account<RUB>(getRandomAccountCardNumber(), getRandomBalance(), "RUB"));
                case 2:
                    client.addAccount(new Account<KZT>(getRandomAccountCardNumber(), getRandomBalance(), "KZT"));
            }
        }
        for (int i = 0; i < cardCount; i++) {
            Integer currencyRandom = getRandomValue(2);
            switch (currencyRandom) {
                case 0:
                    client.addCard(new Card<USD>(getRandomAccountCardNumber(), getRandomBalance(), "USD"));
                case 1:
                    client.addCard(new Card<RUB>(getRandomAccountCardNumber(), getRandomBalance(), "RUB"));
                case 2:
                    client.addCard(new Card<KZT>(getRandomAccountCardNumber(), getRandomBalance(), "KZT"));
            }
        }
        return client;
    }

    private BigDecimal getRandomBalance() {
        return new BigDecimal(getRandomValue(1000));
    }

    private String getRandomAccountCardNumber() {
        Integer number = getRandomValue(100000000);
        return number.toString();
    }

    private Integer getRandomValue(Integer count) {
        return random.nextInt(count);
    }
}
