package com.company;

public abstract class TrafficElement {
    Point mapPosition;

    public Point getMapPosition() {
        return mapPosition;
    }

    public TrafficElement(Point position) {
        mapPosition = position;
    }
}
