package com.company;

final public class Bus extends Vehicle
{
    private Double numberPassengers;

    public Bus(MovementStatus ms, String color, Double size, Double weight, Double maxSpeed, Reputation rep, DamageStatus ds, Double np)
    {
        super(ms, color, size, weight, maxSpeed, rep, ds);
        numberPassengers = np;
    }
}
