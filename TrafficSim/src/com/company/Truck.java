package com.company;

final public class Truck extends Vehicle
{
    private Double cargo;

    public Truck(MovementStatus ms, String color, Double size, Double weight, Double maxSpeed, Reputation rep, DamageStatus ds, Double cargo)
    {
        super(ms, color, size, weight, maxSpeed, rep, ds);
        this.cargo = cargo;
        type = "Truck";
    }
}
