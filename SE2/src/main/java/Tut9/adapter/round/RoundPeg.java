package Tut9.adapter.round;

/**
 * RoundPegs are compatible with RoundHoles.
 */
public class RoundPeg {
    //TODO: Declare an attribute: name = radius, type = double
    private double radius;

    //TODO: Declare the empty constructor
    public RoundPeg() {
    }

    //TODO: Declare another constructor with a parameter
    public RoundPeg(double radius) {
        this.radius = radius;
    }

    //TODO: Implement getRadius() method
    public double getRadius() {
        return radius;
    }
}
