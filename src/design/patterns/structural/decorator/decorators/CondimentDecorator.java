package design.patterns.structural.decorator.decorators;

import design.patterns.structural.decorator.beverages.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
