package com.company;

import java.util.Objects;

public abstract class TrafficElement {
    private final Point mapPosition;

    public Point getMapPosition() {
        return mapPosition;
    }

    public TrafficElement(Point position) {
        mapPosition = position;
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
