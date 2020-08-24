package design.usecase.businesshousegame.model;

import design.usecase.businesshousegame.actors.Player;
import design.usecase.businesshousegame.enums.HotelType;

public class Hotel implements Cell {

    private Player currentOwner;
    private HotelType hotelType;
    private int hotelAccountAmount;

    public Hotel() {
        this.hotelType = HotelType.Sentinel;
        this.hotelAccountAmount = 0;
    }

    @Override
    public void apply(Player player) {
        int currentAmount = player.getCurrentAmount();

        if(player.getCurrentAmount() < hotelType.getRent())
            return;

        if(currentOwner == null)
            this.assignHotel(player);
        else if(!currentOwner.equals(player))
            this.collectRent(player);
        else if(currentAmount >= hotelType.upgrade().getValue())
            this.upgradeAndCreditAmountToHotel(hotelType, hotelType.upgrade());
    }

    public void upgradeAndCreditAmountToHotel(HotelType currentHotelType, HotelType upgradeHotelType) {
        int deltaAmount = upgradeHotelType.getValue() - currentHotelType.getValue();
        this.hotelType = upgradeHotelType;
        this.currentOwner.debitAmount(deltaAmount);
        creditAmountToHotel(deltaAmount);
    }

    public void assignHotel(Player player) {
        this.setCurrentOwner(player);
        this.upgradeAndCreditAmountToHotel(this.hotelType, hotelType.upgrade());
    }
    public void creditAmountToHotel(int creditAmount) {
        this.hotelAccountAmount += creditAmount;
    }

    public void collectRent(Player player) {
        int rentAmount = this.hotelType.getRent();
        player.payRent(rentAmount);
        this.currentOwner.creditAmount(rentAmount);
    }

    public void setCurrentOwner(Player player) {
        this.currentOwner = player;
    }

    public Player getCurrentOwner() {
        return currentOwner;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public int getHotelAccountAmount() {
        return hotelAccountAmount;
    }
}
