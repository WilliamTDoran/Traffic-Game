package com.company;

public abstract class Vehicle
{
    private MovementStatus movementStatus;
    private String color;
    private Double size;
    private Double weight;
    private Double maxSpeed;
    private Reputation reputation;
    private DamageStatus damageStatus;

    public Vehicle(MovementStatus ms, String color, Double size, Double weight, Double maxSpeed, Reputation rep, DamageStatus ds)
    {
        movementStatus = ms;
        this.color = color;
        this.size = size;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        reputation = rep;
        damageStatus = ds;
    }

    public void move()
    {

    }
}
