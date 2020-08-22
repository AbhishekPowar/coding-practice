package design.rover.command;

import design.rover.MarsRover;

public interface ICommand {
    void execute(MarsRover marsRover);
}
