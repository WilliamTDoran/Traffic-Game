package com.company;

public class Lane extends TrafficElement{
    private double length;
    private Direction direction;

    protected Lane(Point position, double length, Direction direction) {
        super(position);
        this.length = length;
        this.direction = direction;
    }
}
