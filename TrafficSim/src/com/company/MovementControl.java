package com.company;

import java.util.ArrayList;

public interface MovementControl {
    public ArrayList<Vehicle> updateVehiclesPosition(TrafficNetwork network, ArrayList<Vehicle> vehicles);

    public ArrayList<Vehicle> checkRegion(Vehicle vehicle, ArrayList<Vehicle> vehicles);

    public Position validateMoveChoice(Vehicle vehicle, Position newPosition);

    public ArrayList<TrafficElement> probeMapSurroundings(Vehicle vehicle);
}
