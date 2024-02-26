package com.company;

import java.util.ArrayList;

public class Intersection extends TrafficElement {
    ArrayList<RoadSegment> roads;

    protected Intersection(Point pos) {
        super(pos);
    }
}
