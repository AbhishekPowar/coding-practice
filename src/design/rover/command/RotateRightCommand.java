package design.rover.command;

import design.rover.MarsRover;

public class RotateRightCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnRight();
    }
}
