package design.rover;

import design.rover.command.ICommand;
import design.rover.parser.StringCommandParser;
import design.rover.universe.Coordinate;
import design.rover.universe.Direction;
import design.rover.universe.Plateau;

import java.util.List;

/**
 * Repository Link: <a>https://github.com/priyaaank/MarsRover</a>
 */
public class MarsRover {

    private final Plateau plateau;
    private Direction currentDirection;
    private Coordinate currentCoordinate;

    public MarsRover(final Plateau plateau, final Direction direction, final Coordinate coordinate) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinate = coordinate;
    }

    public void run(final String commandString) {
        List<ICommand> commands = new StringCommandParser(commandString).parse();
        for(ICommand command: commands)
            command.execute(this);
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.rotateLeft();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.rotateRight();
    }

    public void move() {
        Coordinate newCoordinate = this.currentCoordinate.newCoordinateWithStep(this.currentDirection.getStepSizeOnXAxis(), this.currentDirection.getStepSizeOnYAxis());
        if(plateau.isWithinBound(newCoordinate))
            this.currentCoordinate = newCoordinate;
    }
}
