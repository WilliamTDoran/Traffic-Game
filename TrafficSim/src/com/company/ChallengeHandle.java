package com.company;

import java.util.ArrayList;

public class ChallengeHandle {

    //Find the closest car in the intersection
    private Vehicle findNeighbours(Vehicle vehicle) {
        Position VehiclePosition = vehicle.MovementStatus().getPosition();
        ArrayList<Vehicle> vehicles = GameEngine.instance.checkRegion(vehicle, GameEngine.instance.getListVehicles());
        Vehicle closest = null;
        double distanceToClosest = Double.MAX_VALUE;
        for (int i=0; i<vehicles.size(); i++) {
            Position pos = vehicles.get(i).getMovementStatus().getPosition();
            if (pos.getPoint().X() == VehiclePosition.getPoint().X() && pos.getPoint().Y() == VehiclePosition.getPoint().Y())
                continue;
            double posDistance = pos.getPoint().X() * pos.getPoint().X() + pos.getPoint().Y() * pos.getPoint().Y();
            posDistance -= VehiclePosition.getPoint().X() * VehiclePosition.getPoint().X() + VehiclePosition.getPoint().Y() * VehiclePosition.getPoint().Y();
            posDistance = Math.abs(posDistance);
            if (posDistance < distanceToClosest) 
            {
                closest = vehicles.get(i);
                distanceToClosest = posDistance;
                continue;
            }
        }
        if (closest != null) return closest;
        return closest;
    }

    public TrafficNetwork runChallenge(Vehicle vehicle, TrafficNetwork trafficNetwork) {
        Vehicle neighbour = findNeighbours(vehicle);
        if (neighbour == null) return trafficNetwork;

        return trafficNetwork;
    }
}
