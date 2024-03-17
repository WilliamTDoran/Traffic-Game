package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameEngine implements MovementControl {
    private TrafficNetwork trafficNetwork;
    private ArrayList<Vehicle> vehicles;
    private Player player;
    private MovementControl movementControl;
    private ChallengeHandle challengeHandle;
    private int turnCount;

    private Scanner scanner = new Scanner(System.in);

    GameEngine() {
        trafficNetwork = new TrafficNetwork();
        vehicles = new ArrayList<Vehicle>();
        int numberOfCars = 5; //does not include the player
        Random rand = new Random();
        for (int i = 0; i < numberOfCars + 1; i++) {
            int road = rand.nextInt((int)trafficNetwork.getRoads().stream().count());
            Lane lane = trafficNetwork.getRoads().get(road).getLanes().get(rand.nextInt((int)trafficNetwork.getRoads().get(road).getLanes().stream().count()));
            vehicles.add(new Car(new MovementStatus(new Position(lane, lane.getMapPosition()), 0.0, lane.getDirection()), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));

            if (i == numberOfCars)
            {
                player = new Player(new Car(new MovementStatus(new Position(lane, lane.getMapPosition()), 0.0, lane.getDirection()), "Red", 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), 2.0));
            }
        }

        while (true)
        {
            updateSimulationTurn();
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
        ArrayList<Vehicle> vehiclesInSameRegion = new ArrayList<>();
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
            ArrayList<Vehicle> otherCars = checkRegion(vehicle, vehicles);
            for (int i = 0; i < otherCars.stream().count(); i++) {
                if (vehicle == otherCars.get(i)) continue;
                if (oldPos.getPoint().lessThan(otherCars.get(i).getMovementStatus().getPosition().getPoint())) return false;
            }
            otherCars = checkRegion(new Car(new MovementStatus(newPosition, 0.0, vehicle.getMovementStatus().getDirection()), "Imaginary", 0.0, vehicle.getWeight(), 0.0, new Reputation(), new DamageStatus(1.0), 1.0), vehicles);
            for (int i = 0; i < otherCars.stream().count(); i++) {
                if (oldPos.getPoint().lessThan(otherCars.get(i).getMovementStatus().getPosition().getPoint())) return false;
            }
            return true;
        }
        return false;
    }

    public ArrayList<TrafficElement> probeMapSurroundings(Vehicle vehicle) {
        TrafficElement element = vehicle.getMovementStatus().getPosition().getTrafficElement();
        ArrayList<TrafficElement> near = new ArrayList<>();
        boolean found = false;
        if (element.getClass() == Lane.class) {
            for (int i = 0; i < trafficNetwork.getRoads().stream().count(); i++) {
                for (int j = 0; j < trafficNetwork.getRoads().get(i).getLanes().stream().count(); j++) {
                    if (((Lane)element).equals(trafficNetwork.getRoads().get(i).getLanes().get(j))) {
                        for (int k = 0; k < trafficNetwork.getRoads().get(i).getLanes().stream().count(); k++) {
                            near.add(trafficNetwork.getRoads().get(i).getLanes().get(k));
                        }
                        for (int k = 0; k < trafficNetwork.getRoads().get(i).getIntersections().stream().count(); k++) {
                            near.add(trafficNetwork.getRoads().get(i).getIntersections().get(k));
                        }
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        } else { // if it's an intersection
            for (int i = 0; i < ((Intersection)element).getRoads().stream().count(); i++) {
                for (int j = 0; j < ((Intersection)element).getRoads().get(i).getLanes().stream().count(); j++) {
                    near.add(((Intersection)element).getRoads().get(i).getLanes().get(j));
                }
            }
        }
        return near;
    }

    private void updateSimulationTurn() {
        int numberOfTurns = 100;
        for (turnCount = 0; turnCount < numberOfTurns; turnCount++) {
            promptPlayer();
            updateVehiclesPosition(trafficNetwork, vehicles);
            updateSimulationTurn();
        }
    }

    private void promptPlayer() {
        Double playerSpeed = player.getVehicle().getMovementStatus().getSpeed();
        Direction playerDirection = player.getVehicle().getMovementStatus().getDirection();
        boolean atIntersection = false;

        System.out.println("You are at position " + player.getVehicle().getMovementStatus().toString() + ". You are moving " + playerDirection + " at " + playerSpeed + " kph.");

        System.out.println("There is: ");
        ArrayList<TrafficElement> surroundings = probeMapSurroundings(player.getVehicle());
        for (int i = 0; i < surroundings.stream().count(); i++)
        {
            if (surroundings.get(i).getType().equals("Intersection") && surroundings.get(i).pointCompare(player.getVehicle().getMovementStatus().getPosition().getPoint()))
                atIntersection = true;
            System.out.println("     A(n) " + surroundings.get(i).getType() + " at " + surroundings.get(i).toString());
        }

        System.out.println("The other vehicles on your lane are: ");
        ArrayList<Vehicle> competition = checkRegion(player.getVehicle(), vehicles);
        for (int i = 0; i < competition.stream().count(); i++)
        {
            System.out.println("     A " + competition.get(i).getType() + " at " + competition.get(i).getMovementStatus().toString() + ", moving " + competition.get(i).getMovementStatus().getDirection() + "ward at " + competition.get(i).getMovementStatus().getSpeed() + " kph.");
        }

        System.out.println("Type D for drive, B for brake, or L or R for turning left or right (if applicable)");

        String input = scanner.nextLine();

        switch(input)
        {
            case("D"):
                Position newPos = new MovementStatus(player.getVehicle()).getPosition();
                player.getVehicle().move(validateMoveChoice(player.getVehicle(), newPos));
                break;
            case("B"):
                player.getVehicle().move(false);
                break;
            case("L"):
                break;
            case("R"):
                break;
        }
    }
}
