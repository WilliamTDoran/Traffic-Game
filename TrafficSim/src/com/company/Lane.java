package com.company;

public class Lane extends TrafficElement{
    private double length;
    private Direction direction;
    private RoadSegment road;

    public Direction getDirection() { return direction; }
    public RoadSegment getRoad() { return road; }

    protected Lane(Point position, double length, Direction direction, RoadSegment road) {
        super(position);
        this.length = length;
        this.direction = direction;
        this.road = road;
        type = "Lane";
    }

    public boolean pointOnLane(Position pos) {
        float dir = 1;
        switch (getDirection()) {
        case South:
            dir = -1;
        case North:
            if (pos.getTrafficElement() == this && length > dir * pos.getPoint().Y()-this.getMapPosition().Y() && dir * pos.getPoint().Y()>this.getMapPosition().Y()) {
                return true;
            }
            break;
        case West:
            dir = -1;
        case East:
            if (pos.getTrafficElement() == this && length > dir * pos.getPoint().X()-this.getMapPosition().X() && dir * pos.getPoint().X()>this.getMapPosition().X()) {
                return true;
            }
            break;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}
