package generics.bank;

import java.util.List;

public final class ClientUtils {
    public static String printBalance(Client client) {
        StringBuilder result = new StringBuilder();
        List<Account> accounts = client.getAccounts();
        result.append("Остаток по балансу у клиента ").append(client.getName())
                .append(" составляет: " + System.lineSeparator());

        for (Account account : accounts) {
            result.append("Номер счета: ").append(account.getAccountNumber())
                    .append(" остаток: " + account.getBalance()).append(" " + account.getCurrency())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
