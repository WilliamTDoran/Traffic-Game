package com.company;

import java.util.ArrayList;

public class RoadSegment {
    ArrayList<Intersection> intersections;
    ArrayList<Lane> lanes;

    public RoadSegment(Intersection from, Intersection to, int lanes) {
        System.out.println("New road created between " + from + ", & " + to + ", with "+lanes + " lanes");
    }
}
