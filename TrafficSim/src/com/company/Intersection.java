package com.company;

import java.util.ArrayList;

public class Intersection extends TrafficElement {
    private ArrayList<RoadSegment> roads;

    public ArrayList<RoadSegment> getRoads() {
        return roads;
    }

    protected Intersection(Point pos)
    {
        super(pos);
        type = "Intersection";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
