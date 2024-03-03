package com.company;

import java.util.ArrayList;
import java.util.Random;

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
        int numberOfCars = 5;
        Random rand = new Random();
        for (int i = 0; i < numberOfCars; i++) {
            int road = rand.nextInt((int)trafficNetwork.getRoads().stream().count());
            Lane lane = trafficNetwork.getRoads().get(road).getLanes().get(rand.nextInt((int)trafficNetwork.getRoads().get(road).getLanes().stream().count()));
            vehicles.add(new Car(new MovementStatus(new Position(lane, lane.getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        }
        /*vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(0).getLanes().get(0), trafficNetwork.getRoads().get(0).getLanes().get(0).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(0).getLanes().get(0), trafficNetwork.getRoads().get(0).getLanes().get(0).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(0).getLanes().get(1), trafficNetwork.getRoads().get(0).getLanes().get(1).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getRoads().get(1).getLanes().get(0), trafficNetwork.getRoads().get(1).getLanes().get(0).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        vehicles.add(new Car(new MovementStatus(new Position(trafficNetwork.getIntersections().get(0), trafficNetwork.getIntersections().get(0).getMapPosition())), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
        System.out.println(trafficNetwork.checkNumberVehiclesInSegment(trafficNetwork.getRoads().get(0), vehicles) + " vehicles in the first road");
        System.out.println(trafficNetwork.checkNumberVehiclesInLane(trafficNetwork.getRoads().get(0).getLanes().get(0), vehicles) + " vehicles in the first lane");
        System.out.println(trafficNetwork.checkNumberVehiclesInIntersection(trafficNetwork.getIntersections().get(0), vehicles) + " vehicles in the first intersection");*/
    }


    public ArrayList<Vehicle> updateVehiclesPosition(TrafficNetwork network, ArrayList<Vehicle> vehicles) {
        for (int i = 0; i < vehicles.stream().count(); i++) {
            Position newPos = new MovementStatus(vehicles.get(i)).getPosition();
            vehicles.get(i).move(validateMoveChoice(vehicles.get(i), newPos));
        }
        return vehicles;
    }

    public ArrayList<Vehicle> checkRegion(Vehicle vehicle, ArrayList<Vehicle> vehicles) {
        ArrayList<Vehicle> vehiclesInSameRegion = new ArrayList<Vehicle>();
        for (int i = 0; i < vehicles.stream().count(); i++) {
            if (vehicle.getMovementStatus().getPosition().getTrafficElement() == vehicles.get(i).getMovementStatus().getPosition().getTrafficElement()) {
                vehiclesInSameRegion.add(vehicles.get(i));
            }
        }
        return vehiclesInSameRegion;
    }

    public boolean validateMoveChoice(Vehicle vehicle, Position newPosition)
    {
        Position oldPos = vehicle.getMovementStatus().getPosition();
        TrafficElement element = oldPos.getTrafficElement();
        TrafficElement newElement = newPosition.getTrafficElement();
        if (element.equals(newElement)) {
            ArrayList<Vehicle> otherCars = checkRegion(vehicle, vehicles);
            for (int i = 0; i < otherCars.stream().count(); i++) {
                if (vehicle == vehicles.get(i)) continue;
                return !(oldPos.getPoint().lessThan(otherCars.get(i).getMovementStatus().getPosition().getPoint())
                        && otherCars.get(i).getMovementStatus().getPosition().getPoint().lessThan(newPosition.getPoint()));
            }
        } else {

        }
        return false;
    }

    public ArrayList<TrafficElement> probeMapSurroundings(Vehicle vehicle) {
        return null;
    }

    private void updateSimulationTurn() {

    }

    private void promptPlayer() {

    }
}
