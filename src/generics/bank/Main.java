package generics.bank;

public class Main {
    public static void main(String[] args) {
        ClientUtils utils = new ClientUtils();
        RandomClientFactory clientFactory = new RandomClientFactory();
        Client client = clientFactory.nextClient();
        System.out.println(utils.printBalance(client));
    }
}
