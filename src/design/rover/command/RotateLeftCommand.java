package design.rover.command;

import design.rover.MarsRover;

public class RotateLeftCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnLeft();
    }
}
