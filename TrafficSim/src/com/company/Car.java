package com.company;

final public class Car extends Vehicle
{
    private Double numberDoors;

    public Car(MovementStatus ms, String color, Double size, Double weight, Double maxSpeed, Reputation rep, DamageStatus ds, Double nd)
    {
        super(ms, color, size, weight, maxSpeed, rep, ds);
        numberDoors = nd;
        type = "Car";
    }
}
