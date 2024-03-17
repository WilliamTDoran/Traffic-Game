package com.company;

import java.util.Objects;

public abstract class TrafficElement {
    private final Point mapPosition;
    protected String type;

    public String getType() { return  type; }
    public Point getMapPosition() { return mapPosition; }

    public TrafficElement(Point position) {
        mapPosition = position;
    }

    public boolean pointCompare(Point other)
    {
        double xDiff = Math.abs(mapPosition.X() - other.X());
        double yDiff = Math.abs(mapPosition.Y() - other.Y());

        return (xDiff < 0.5 && yDiff < 0.5);
    }

    @Override
    public String toString() {
        return "("+mapPosition.X()+","+mapPosition.Y()+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficElement that = (TrafficElement) o;
        return Objects.equals(mapPosition, that.mapPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapPosition);
    }
}
