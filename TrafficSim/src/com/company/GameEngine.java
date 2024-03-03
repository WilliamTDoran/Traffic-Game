package com.company;

import java.util.ArrayList;

public class GameEngine implements MovementControl {
    TrafficNetwork trafficNetwork;
    ArrayList<Vehicle> vehicles;
    Player player;
    MovementControl movementControl;
    ChallengeHandle challengeHandle;
    int turnCount;

    public static void main(String[] args) {
        GameEngine GE = new GameEngine();
        //tn.checkNumberVehiclesInSegment(tn.roads.get(0), );
    }

    GameEngine() {
        trafficNetwork = new TrafficNetwork();
        vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car(new MovementStatus(), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
    }


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
