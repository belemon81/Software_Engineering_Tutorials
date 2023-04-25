package Tut8.prototype;

// Create the Square concrete class which extends the Shape abstract class
public class Square extends Shape {
    // TODO: Declare the constructor
    public Square() {
        // Set type to be similar with class name
        this.type = "Square";
    }

    // TODO: Declare the draw() method
    @Override
    public void draw() {
        /*
         * Only print out the draw() method to test. No need to implement the real
         * drawing
         */
        System.out.println("Inside Square::draw() method.");
    }
}
