package Tut8.prototype;

//Create the Circle concrete class which extends the Shape abstract class
public class Circle extends Shape {
    // TODO: Declare the constructor
    public Circle() {
        // Set type to be similar with class name
        this.type = "Circle";
    }

    // TODO: Declare the draw() method
    @Override
    public void draw() {
        /*
         * Only print out the draw() method to test. No need to implement the real
         * drawing
         */
        System.out.println("Inside Circle::draw() method.");
    }
}
