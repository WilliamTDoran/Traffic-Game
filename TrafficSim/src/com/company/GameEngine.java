package com.company;

import java.util.ArrayList;

public class GameEngine implements MovementControl {
    private TrafficNetwork trafficNetwork;
    private ArrayList<Vehicle> vehicles;
    private Player player;
    private MovementControl movementControl;
    private ChallengeHandle challengeHandle;
    private int turnCount;

    public static void main(String[] args) {
        GameEngine GE = new GameEngine();
        //tn.checkNumberVehiclesInSegment(tn.roads.get(0), );
    }

    GameEngine() {
        trafficNetwork = new TrafficNetwork();
        vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(0).getLanes().get(0), trafficNetwork.getRoads().get(0).getLanes().get(0).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(0).getLanes().get(1), trafficNetwork.getRoads().get(0).getLanes().get(1).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(1).getLanes().get(0), trafficNetwork.getRoads().get(1).getLanes().get(0).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        System.out.println(trafficNetwork.checkNumberVehiclesInSegment(trafficNetwork.getRoads().get(0), vehicles) + " vehicles in the first road");
        System.out.println(trafficNetwork.checkNumberVehiclesInLane(trafficNetwork.getRoads().get(0).getLanes().get(0), vehicles) + " vehicles in the first lane");
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
