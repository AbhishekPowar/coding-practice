package design.usecase.reservation;

import java.util.Comparator;
import java.util.TreeSet;

public class Room {
    private final int capacity;
    private final String name;
    private final TreeSet<Slot> blockedSlots;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.blockedSlots = new TreeSet<>(Comparator.comparing(Slot::getStartDate).thenComparing(Slot::getEndDate));
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable(Slot slot) {
        if(blockedSlots == null || blockedSlots.isEmpty())
            return true;

        for(Slot blocked: blockedSlots)
            if(isOverlappingSlots(slot, blocked))
                return false;
        return true;
    }

    public void bookSlot(Slot slot) {
        if(isAvailable(slot))
            blockedSlots.add(slot);
        else
            throw new IllegalArgumentException("Slot not Available");
    }

    public int getCapacity() {
        return capacity;
    }

    public void clearSlot(Slot slot) {

        if(blockedSlots == null || blockedSlots.isEmpty())
            return;

        boolean found = false;
        for(Slot blockedSlot: blockedSlots)
            if(blockedSlot.equals(slot)) {
                found = true;
                break;
            }
        if(found)
            this.blockedSlots.remove(slot);
    }

    private boolean isOverlappingSlots(Slot slot1, Slot slot2) {
        if(slot1.getStartDate().compareTo(slot2.getStartDate()) <= 0) {
            return slot1.getEndDate().compareTo(slot2.getStartDate()) >= 0 && slot1.getEndDate().compareTo(slot2.getEndDate()) <= 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
