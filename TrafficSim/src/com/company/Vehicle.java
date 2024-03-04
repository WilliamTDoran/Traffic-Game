package com.company;

public abstract class Vehicle
{
    private MovementStatus movementStatus;
    public MovementStatus MovementStatus() {return movementStatus;};
    private String color;
    private Double size;
    private Double weight;
    private Double maxSpeed;

    protected String type;
    public String getType() { return type; }

    public Double getMaxSpeed() { return maxSpeed; }

    private Reputation reputation;
    private DamageStatus damageStatus;

    public Double getWeight() { return weight; }
    public MovementStatus getMovementStatus() { return movementStatus; }

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

    public void move(boolean moving)
    {
        if (moving)
        {
            movementStatus.setSpeed(maxSpeed);
        }
        else
        {
            movementStatus.setSpeed(0.0);
        }

        movementStatus.updatePosition();
    }

    public void AlterReputation(Double deltaRep)
    {
        reputation.setNiceness(reputation.getNiceness() + deltaRep);
    }
}
