package com.company;

public class Lane extends TrafficElement{
    double length;
    Direction direction;

    protected Lane(Point position, double length, Direction direction) {
        super(position);
        this.length = length;
        this.direction = direction;
    }
}
