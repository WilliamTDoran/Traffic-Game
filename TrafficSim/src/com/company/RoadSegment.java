package com.company;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.abs;

public class RoadSegment {
    private final ArrayList<Intersection> intersections;

    public ArrayList<Intersection> getIntersections() {
        return intersections;
    }

    private final ArrayList<Lane> lanes;

    public ArrayList<Lane> getLanes() {
        return lanes;
    }

    public RoadSegment(Intersection from, Intersection to, int lanes) {
        intersections = new ArrayList<>();
        this.lanes = new ArrayList<Lane>();

        intersections.add(from);
        intersections.add(to);

        double length = from.getMapPosition().X() - to.getMapPosition().X() + from.getMapPosition().Y() - to.getMapPosition().Y();
        Direction direction;
        if (length <= 0 && from.getMapPosition().X() == to.getMapPosition().X()) {
            direction = Direction.South;
        } else if (length <= 0 && from.getMapPosition().Y() == to.getMapPosition().Y()) {
            direction = Direction.West;
        } else if (length >= 0 && from.getMapPosition().Y() == to.getMapPosition().Y()) {
            direction = Direction.East;
        } else {//if (length >= 0 && from.mapPosition.x == to.mapPosition.x) {
            direction = Direction.North;
        }
        length = abs(length);

        for (int i = 0; i < lanes; i++) {
            this.lanes.add(new Lane(from.getMapPosition(), length, direction));
        }
        System.out.println("New road created between " + from + ", & " + to + ", with " + lanes + " lanes");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() == lanes.get(0).getClass()) {
            for (int i = 0; i < lanes.stream().count(); i++) {
                if (Objects.equals(lanes.get(i), o)) return true;
            }
        }
        if (o == null || getClass() != o.getClass()) return false;
        RoadSegment that = (RoadSegment) o;
        boolean equals = false;
        return Objects.equals(lanes, that.lanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lanes);
    }
}
