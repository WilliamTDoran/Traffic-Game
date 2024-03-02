package com.company;
import java.util.ArrayList;
import java.lang.Math;

public class DamageStatus
{
    private Double currentStatus;
    private ArrayList<Double> sufferedDamageHistory;
    private ArrayList<Double> generatedDaageHistory;

    public DamageStatus(Double maxHealth)
    {
        currentStatus = maxHealth;
    }

    public Double getCurrentStatus() { return currentStatus; }

    public void updateDamageStatus(Double damage)
    {
        currentStatus -= damage;
    }

    private Double calculateTotalDamage(Vehicle ownVehicle, Vehicle otherVehicle)
    {
        return ownVehicle.getMovementStatus().getSpeed() * ownVehicle.getWeight() * otherVehicle.getMovementStatus().getSpeed() * otherVehicle.getWeight();
    }

    public Double calculateSufferedDamage(Vehicle ownVehicle, Vehicle otherVehicle)
    {
        Double totalDamage = calculateTotalDamage(ownVehicle, otherVehicle);

        Double totalWeight = ownVehicle.getWeight() + otherVehicle.getWeight();
        Double weightPortion = ownVehicle.getWeight() / totalWeight;

        return totalDamage * weightPortion;
    }

    public Double calculateGeneratedDamage(Vehicle ownVehicle, Vehicle otherVehicle)
    {
        return calculateTotalDamage(ownVehicle, otherVehicle) - calculateSufferedDamage(ownVehicle, otherVehicle);
    }
}
