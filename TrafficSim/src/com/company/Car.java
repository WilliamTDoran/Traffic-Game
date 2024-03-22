package com.company;

final public class Car extends Vehicle
{
    private int numberDoors;

    public Car(MovementStatus ms, String color, Double size, Double weight, Double maxSpeed, Reputation rep, DamageStatus ds, int nd)
    {
        super(ms, color, size, weight, maxSpeed, rep, ds);
        numberDoors = nd;
        type = "Car";
    }
}
