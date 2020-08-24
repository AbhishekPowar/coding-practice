package design.usecase.businesshousegame.actors;

public class Player {
    private int amount;
    private int currentCell;
    private int turnsLeft;

    public Player() {
        this.amount = 1000;
        this.currentCell = -1;
        this.turnsLeft = 10;
    }

    public void collectFromBank(int amount) {
        Bank.getInstance().pay(this, amount);
    }

    public void payAmountToBank(int amount) {
        Bank.getInstance().earn(this, amount);
    }

    public void debitAmount(int amount) {
        this.amount -= amount;
    }

    public void creditAmount(int amount) {
        this.amount += amount;
    }

    public int getCurrentAmount() {
        return this.amount;
    }

    public void payRent(int rentAmount) {
        this.amount -= rentAmount;
    }

    public int getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(int currentCell) {
        this.currentCell = currentCell;
    }

    public void decrementTurn() {
        turnsLeft--;
    }
    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }

    @Override
    public String toString() {
        return "Player{" +
                "amount=" + amount +
                ", currentCell=" + currentCell +
                ", turnsLeft=" + turnsLeft +
                '}';
    }
}
