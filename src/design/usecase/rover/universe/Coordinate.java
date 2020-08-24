package design.usecase.rover.universe;

public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Coordinate newCoordinateWithStep(int stepX, int stepY) {
        return new Coordinate(this.xCoordinate+stepX, this.yCoordinate + stepY);
    }

    public boolean isWithBound(Coordinate coordinate) {
        return this.xCoordinate >= coordinate.xCoordinate && this.yCoordinate >= coordinate.yCoordinate;
    }
    public boolean isOutsideBound(Coordinate coordinate) {
        return this.xCoordinate <= coordinate.xCoordinate && this.yCoordinate <= coordinate.yCoordinate;
    }
}
