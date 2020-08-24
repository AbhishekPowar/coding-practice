package design.usecase.businesshousegame.enums;

public enum HotelType {

    Sentinel(0, 0) {
        @Override
        public HotelType upgrade() {
            return Silver;
        }
    },
    Silver(200, 50) {
        @Override
        public HotelType upgrade() {
            return Gold;
        }
    },
    Gold(300, 150) {
        @Override
        public HotelType upgrade() {
            return Platinum;
        }
    },
    Platinum(500, 300) {
        @Override
        public HotelType upgrade() {
            return Platinum;
        }
    };

    private final int value;
    private final int rent;

    public abstract HotelType upgrade();

    HotelType(int value, int rent) {
        this.value = value;
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }
    public int getValue() {
        return value;
    }
}
