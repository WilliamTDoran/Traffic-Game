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

        Vehicle result;
        String color = vehicleColor();

        if (select <= 6) //car
        {
            int numDoors = (rand.nextInt(1) + 1) * 2; //2 or 4
            result = new Car(stat, color, 1.0, 1.0, 1.0, new Reputation(), new DamageStatus(100.0), numDoors);
        }
        else if (select == 9) //bus
        {

        }
        else //truck
        {

        }

        return null;
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
