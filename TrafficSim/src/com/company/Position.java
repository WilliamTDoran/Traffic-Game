package com.company;

public class Position {
    private TrafficElement trafficElement;
    private Point coordinate;

    public TrafficElement getTrafficElement() {
        return trafficElement;
    }

    public Point getPoint() {
        return coordinate;
    }

    public Position(TrafficElement element, Double x, Double y) {
        coordinate = new Point(x, y);
        trafficElement = element;
    }
    public Position(TrafficElement element, Point position) {
        coordinate = position;
        trafficElement = element;
    }
}
