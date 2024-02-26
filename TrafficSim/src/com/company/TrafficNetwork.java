package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrafficNetwork {
    ArrayList<RoadSegment> roads;
    ArrayList<Intersection> intersections;

    public static void main(String[] args) {
        TrafficNetwork tn = new TrafficNetwork();
    }

    public TrafficNetwork() {
        String filename = "src/com/company/TestNetwork.txt";
        try {
            File file = new File(filename);
            Scanner readFile = new Scanner(file);
            ArrayList<String> intersectionNames = new ArrayList<>();
            intersections = new ArrayList<>();
            while (readFile.hasNextLine()) {
                String data = readFile.nextLine();
                if (data.startsWith("[")) { // new intersection
                    try {
                        intersectionNames.add(data.substring(1,data.indexOf(']')));
                        int start = data.indexOf('(') + 1;
                        int end = data.indexOf(',');
                        int x = Integer.parseInt(data.substring(start, end));
                        start = end + 2;
                        end = data.indexOf(')');
                        int y = Integer.parseInt(data.substring(start, end));
                        Point point = new Point(x, y);
                        intersections.add(new Intersection(point));
                    } catch (NumberFormatException e) {
                        System.out.println("Data set \"" + data + "\" does not contain valid data entries");
                    }
                } else { // connects 2 intersections

                }
            }
            for (int i = 0; i< intersectionNames.size() && i < intersections.size(); i++) {
                System.out.println(intersectionNames.get(i) + ", " + intersections.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }



    public int checkNumberVehiclesInSegment(RoadSegment roadSegment) {
        return 0;
    }

    public int checkNumberVehiclesInLane(Lane lane) {
        return 0;
    }

    public int checkNumberVehiclesAtIntersection(Intersection intersection) {
        return 0;
    }

    public int checkNumberVehiclesInIntersection(Intersection intersection) {
        return 0;
    }
}
