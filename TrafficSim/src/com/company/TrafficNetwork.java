package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrafficNetwork {
    private ArrayList<RoadSegment> roads;
    public ArrayList<RoadSegment> getRoads() {return roads;}
    private ArrayList<Intersection> intersections;

    public ArrayList<Intersection> getIntersections() {
        return intersections;
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
                String data = readFile.nextLine().toLowerCase();
                if (data.startsWith("<intersect>")) { // new intersection
                    try {
                        intersectionNames.add(data.substring(11,data.indexOf("<\\intersect>")).trim());
                        int start = data.indexOf("<x>") + 3;
                        int end = data.indexOf("<\\x>");
                        int x = Integer.parseInt(data.substring(start, end).trim());
                        start = data.indexOf("<x>")+3;
                        end = data.indexOf("<\\x>");
                        int y = Integer.parseInt(data.substring(start, end).trim());
                        Point point = new Point(x, y);
                        intersections.add(new Intersection(point));
                    } catch (NumberFormatException e) {
                        System.out.println("Data set \"" + data + "\" does not contain valid data entries");
                    }
                } else if (data.startsWith("<connect>")){ // connects 2 intersections
                    try {
                        int end = data.indexOf("<intersect>");
                        String intersectionFrom = data.substring(9, end).trim();
                        int start = end+11;
                        end = data.indexOf("<\\connect>");
                        String intersectionTo = data.substring(start, end).trim();
                        int numLanes = Integer.parseInt(data.substring(end+10).trim());
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
                        if (intersections.get(start).getMapPosition().X() == intersections.get(end).getMapPosition().X() || intersections.get(start).getMapPosition().Y() == intersections.get(end).getMapPosition().Y()) {
                            roads.add(new RoadSegment(intersections.get(start), intersections.get(end), numLanes));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Data set \"" + data + "\" does not contain valid data entries");
                    }
                }
            }
            readFile.close();
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

    public int checkNumberVehiclesInLane(Lane lane, ArrayList<Vehicle> vehicles) {
        int numVehicles = 0;
        for (int i = 0; i < vehicles.stream().count(); i++) {
            if (lane.equals(vehicles.get(i).MovementStatus().getPosition().getTrafficElement())) {
                numVehicles++;
            }
        }
        return numVehicles;
    }

    public int checkNumberVehiclesAtIntersection(Intersection intersection, ArrayList<Vehicle> vehicles) {
        int numVehicles = 0;
        for (int i = 0; i < vehicles.stream().count(); i++) {
            if (intersection.equals(vehicles.get(i).MovementStatus().getPosition().getTrafficElement())) {
                numVehicles++;
            }
        }
        return numVehicles;
    }

    public int checkNumberVehiclesInIntersection(Intersection intersection, ArrayList<Vehicle> vehicles) {
        return checkNumberVehiclesAtIntersection(intersection, vehicles);
    }
}
