package design.usecase.rover.command;

import design.usecase.rover.MarsRover;

public interface ICommand {
    void execute(MarsRover marsRover);
}
