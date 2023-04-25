package Tut9.adapter.round;

/**
 * RoundHoles are compatible with RoundPegs.
 */
public class RoundHole {
    //TODO: Declare an attribute: name = radius, type = double
    private double radius;

    //TODO: Declare the constructor with a parameter
    public RoundHole(double radius) {
        this.radius = radius;
    }

    //TODO: Implement getRadius() method
    public double getRadius() {
        return radius;
    }

    //TODO: Implement fits() method
    public boolean fits(RoundPeg peg) {
        boolean result = false;
        //if getRadius() of RoundHole >= getRadius() of RoundPeg => return true
        //else return false
        result = getRadius() >= peg.getRadius();
        return result;
    }
}
