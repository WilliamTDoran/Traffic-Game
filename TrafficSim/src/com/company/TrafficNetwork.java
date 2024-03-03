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
        //tn.checkNumberVehiclesInSegment(tn.roads.get(0), );
    }

    public TrafficNetwork() {
        String filename = "src/com/company/TestNetwork.txt";
        try {
            File file = new File(filename);
            Scanner readFile = new Scanner(file);
            ArrayList<String> intersectionNames = new ArrayList<>();
            intersections = new ArrayList<>();
            roads = new ArrayList<>();
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
                    try {
                        int end = data.indexOf(',');
                        String intersectionFrom = data.substring(0, end);
                        int start = end;
                        end = data.indexOf(',', start+1);
                        String intersectionTo = data.substring(start+2, end);
                        int numLanes = Integer.parseInt(data.substring(end+2));
                        start = -1;
                        end = -1;
                        for (int i = 0; i< intersectionNames.size() && i < intersections.size(); i++) {
                            if (intersectionTo.equals(intersectionNames.get(i))) {
                                end = i;
                                if (start != -1) break;
                            } else if (intersectionFrom.equals(intersectionNames.get(i))) {
                                start = i;
                                if (end != -1) break;
                            }
                        }
                        if (intersections.get(start).mapPosition.x == intersections.get(end).mapPosition.x || intersections.get(start).mapPosition.y == intersections.get(end).mapPosition.y) {
                            roads.add(new RoadSegment(intersections.get(start), intersections.get(end), numLanes));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Data set \"" + data + "\" does not contain valid data entries");
                    }
                }
            }
            /*for (int i = 0; i< intersectionNames.size() && i < intersections.size(); i++) {
                System.out.println(intersectionNames.get(i) + ", " + intersections.get(i));
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }



    public int checkNumberVehiclesInSegment(RoadSegment roadSegment, ArrayList<Vehicle> vehicles) {
        int numVehicles = 0;
        for (int i = 0; i < vehicles.stream().count(); i++) {
            if (roadSegment.equals(vehicles.get(i).MovementStatus().getPosition().getTrafficElement())) {
                numVehicles++;
            }
        }
        return numVehicles;
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
