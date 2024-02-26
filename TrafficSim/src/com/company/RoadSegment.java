package com.company;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class RoadSegment {
    ArrayList<Intersection> intersections;
    ArrayList<Lane> lanes;

    public RoadSegment(Intersection from, Intersection to, int lanes) {
        intersections = new ArrayList<>();
        this.lanes = new ArrayList<Lane>();

        intersections.add(from);
        intersections.add(to);

        double length = from.mapPosition.x-to.mapPosition.x + from.mapPosition.y-to.mapPosition.y;
        Direction direction;
        if (length <= 0 && from.mapPosition.x == to.mapPosition.x) {
            direction = Direction.South;
        } else if (length <= 0 && from.mapPosition.y == to.mapPosition.y) {
            direction = Direction.West;
        } else if (length >= 0 && from.mapPosition.y == to.mapPosition.y) {
            direction = Direction.East;
        } else {//if (length >= 0 && from.mapPosition.x == to.mapPosition.x) {
            direction = Direction.North;
        }
        length = abs(length);

        for (int i=0; i<lanes; i++) {
            this.lanes.add(new Lane(from.mapPosition, length, direction));
        }
        System.out.println("New road created between " + from + ", & " + to + ", with "+lanes + " lanes");
    }
}
