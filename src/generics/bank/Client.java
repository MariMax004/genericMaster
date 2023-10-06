package generics.bank;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Account> accounts = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    public Client(String name) {
        this.name = name;
    }
    public Client() {
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
