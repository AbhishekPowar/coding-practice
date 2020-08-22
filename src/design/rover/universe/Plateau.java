package design.rover.universe;

public class Plateau {
    private final Coordinate topRightCoordinates;
    private final Coordinate bottomLeftCoordinates;

    public Plateau(final int topRightXCoordinate, final int topRightYCoordinate) {
        topRightCoordinates = new Coordinate(topRightXCoordinate, topRightYCoordinate);
        bottomLeftCoordinates = new Coordinate(0, 0);
    }

    public boolean isWithinBound(Coordinate coordinate) {
        return bottomLeftCoordinates.isOutsideBound(coordinate) && topRightCoordinates.isWithBound(coordinate);
    }
}
