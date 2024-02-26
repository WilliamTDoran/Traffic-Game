package com.company;
import java.util.ArrayList;

public class Reputation
{
    private Double niceness;
    private ArrayList<Double> reputationHistory;

    public Double getNiceness() { return niceness; }

    public void setNiceness(double niceness)
    {
        Double oldNiceness = this.niceness;
        this.niceness = niceness;

        reputationHistory.add(oldNiceness);
    }
}
