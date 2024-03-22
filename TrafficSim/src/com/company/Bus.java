package com.company;

final public class Bus extends Vehicle
{
    private int numberPassengers;

    public Bus(MovementStatus ms, String color, Double size, Double weight, Double maxSpeed, Reputation rep, DamageStatus ds, int np)
    {
        super(ms, color, size, weight, maxSpeed, rep, ds);
        numberPassengers = np;
        type = "Bus";
    }
}
