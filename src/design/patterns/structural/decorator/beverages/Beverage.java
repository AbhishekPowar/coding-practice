package design.patterns.structural.decorator.beverages;

public abstract class Beverage {

    public enum Size { TALL, GRAND, MEDIUM }

    private Size size = Size.TALL;
    protected String description = "Unknown Beverage";

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
