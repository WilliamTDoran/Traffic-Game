package com.company;

public class Point {
    private double x;
    private double y;

    public double X() { return x; }

    public double Y() { return y; }

    public Point(double X, double Y) {
        x = X;
        y = Y;
    }

    public boolean lessThan(Point p) {
        return (x - p.X() <= 0) && y - p.Y() <= 0;
    }
}
