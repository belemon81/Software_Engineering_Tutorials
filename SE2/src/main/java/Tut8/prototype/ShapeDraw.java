package Tut8.prototype;

/* Create the ShapeDraw class which uses ShapeCache class 
to get clones of shapes stored in a Hashtable. */
public class ShapeDraw {
    // TODO: Implement the main() method for testing purpose
    public static void main(String[] args) {
        // run loadCache() method
        ShapeCache.loadCache();
        /*
         * create 3 cloned shapes with 3 different types
         * Hint: use getShape() & getType() methods
         */
        Shape rectangle = (Shape) ShapeCache.getShape("Rectangle").clone();
        Shape circle = (Shape) ShapeCache.getShape("Circle").clone();
        Shape square = (Shape) ShapeCache.getShape("Square").clone();

        rectangle.draw();
        circle.draw();
        square.draw();
    }
}