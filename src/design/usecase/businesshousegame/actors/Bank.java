package design.usecase.businesshousegame.actors;

public class Bank {
    private int amount;
    private static Bank _instance;

    private Bank() {
        this.amount = 5000;
    }

    public static Bank getInstance() {
        if(_instance == null)
            _instance = new Bank();
        return _instance;
    }

    public void earn(Player player, int amount) {
        player.debitAmount(amount);
        this.amount += amount;
    }

    public void pay(Player player, int amount) {
        this.amount -= amount;
        player.creditAmount(amount);
    }

    public int getAmount() {
        return this.amount;
    }
}
