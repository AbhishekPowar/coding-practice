package design.reservation;

import java.time.LocalDateTime;
import java.util.Objects;

public class Slot {

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public Slot(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Slot of(LocalDateTime startTime, LocalDateTime endTime) {
        return new Slot(startTime, endTime);
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return startDate.equals(slot.startDate) &&
                endDate.equals(slot.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
