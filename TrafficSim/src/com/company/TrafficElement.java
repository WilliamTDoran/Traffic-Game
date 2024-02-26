package com.company;

public abstract class TrafficElement {
    Point mapPosition;

    public Point getMapPosition() {
        return mapPosition;
    }

    public TrafficElement(Point position) {
        mapPosition = position;
    }

    @Override
    public String toString() {
        return "("+mapPosition.x+","+mapPosition.y+")";
    }
}
