package com.company;

import java.util.Random;

public class VehicleFactory
{
    private Random rand;

    public VehicleFactory()
    {
        rand = new Random();
    }

    public Vehicle CreateVehicle(MovementStatus stat)
    {
        int select = rand.nextInt(10);

        Vehicle result = null;
        String color = vehicleColor();

        if (select <= 6) //car
        {
            int numDoors = (rand.nextInt(1) + 1) * 2; //2 or 4
            result = new Car(stat, color, 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), numDoors);
        }
        else if (select == 9) //bus
        {
            int numPassengers = rand.nextInt(40);
            result = new Bus(stat, color, 2.5, 6.0, 0.6, new Reputation(), new DamageStatus(400.0), numPassengers);
        }
        else //truck
        {
            double cargoAmount = rand.nextDouble() * 100;
            result = new Truck(stat, color, 4.0, 8.0, 0.8, new Reputation(), new DamageStatus(500.0), cargoAmount);
        }

        return result;
    }

    public Car CreateCar(MovementStatus stat)
    {
        String color = vehicleColor();
        int numDoors = (rand.nextInt(1) + 1) * 2; //2 or 4
        return new Car(stat, color, 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), numDoors);
    }
    public Bus CreateBus(MovementStatus stat)
    {
        String color = vehicleColor();
        int numPassengers = rand.nextInt(40);
        return new Bus(stat, color, 2.5, 6.0, 0.6, new Reputation(), new DamageStatus(400.0), numPassengers);
    }
    public Truck CreateTruck(MovementStatus stat)
    {
        String color = vehicleColor();
        double cargoAmount = rand.nextDouble() * 100;
        return new Truck(stat, color, 4.0, 8.0, 0.8, new Reputation(), new DamageStatus(500.0), cargoAmount);
    }

    private String vehicleColor()
    {
        int select = rand.nextInt(20);

        switch (select)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return "White"; //0-4, 25%

            case 5:
            case 6:
            case 7:
            case 8:
                return "Black"; //5-8, 20%

            case 9:
            case 10:
            case 11:
            case 12:
                return "Gray"; //9-12, 20%

            case 13:
            case 14:
                return "Silver"; //13-14, 10%

            case 15:
            case 16:
                return "Blue"; //15-16, 10%

            case 17:
            case 18:
                return "Red"; //17-18, 10%

            case 19:
                return "Brown"; //19, 5%

            case 20:
                return "Green"; //20, 5%
        }

        return "";
    }
}
