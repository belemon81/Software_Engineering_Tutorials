package Tut9.adapter.square;

/**
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 */
public class SquarePeg {
    //TODO: Declare an attribute: name = width, type = double
    private double width;

    //TODO: Declare the constructor with a parameter
    public SquarePeg(double width) {
        this.width = width;
    }

    //TODO: Implement getWidth() method
    public double getWidth() {
        return width;
    }

    //TODO: Implement getSquare() method
    public double getSquare() {
        double result = 0;
        //TODO: result = width^2
        result = Math.pow(width, 2);
        return result;
    }
}
