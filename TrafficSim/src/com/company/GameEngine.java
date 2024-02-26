package com.company;

import java.util.ArrayList;

public class GameEngine implements MovementControl {
    TrafficNetwork trafficNetwork;
    ArrayList<Vehicle> vehicles;
    Player player;
    MovementControl movementControl;
    ChallengeHandle challengeHandle;
    int turnCount;


    public ArrayList<Vehicle> updateVehiclesPosition(TrafficNetwork network, ArrayList<Vehicle> vehicles) {
        return null;
    }

    public ArrayList<Vehicle> checkRegion(Vehicle vehicle, ArrayList<Vehicle> vehicles) {
        return null;
    }

    public Position validateMoveChoice(Vehicle vehicle, Position newPosition) {
        return newPosition;
    }

    public ArrayList<TrafficElement> probeMapSurroundings(Vehicle vehicle) {
        return null;
    }

    private void updateSimulationTurn() {

    }

    private void promptPlayer() {

    }
}
