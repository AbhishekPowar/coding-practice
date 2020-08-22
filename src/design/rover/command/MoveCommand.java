package design.rover.command;

import design.rover.MarsRover;

public class MoveCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.move();
    }
}
