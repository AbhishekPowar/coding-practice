package design.usecase.rover.command;

import design.usecase.rover.MarsRover;

public class RotateLeftCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnLeft();
    }
}
