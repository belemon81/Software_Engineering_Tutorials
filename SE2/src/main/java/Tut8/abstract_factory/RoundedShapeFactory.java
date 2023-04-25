package Tut8.abstract_factory;

/* Create RoundedShapeFactory class extending AbstractFactory to generate
 * object of concrete class based on given information.
 */

public class RoundedShapeFactory extends AbstractFactory {
    // TODO: Implement the getShape() method
    @Override
    public Shape getShape(String shapeType) {
        /*
         * check for the shape type is equal to 'Rectangle' or 'Square' (ignore case)
         * then return the corresponding type
         */
        if (shapeType.equalsIgnoreCase("Rectangle")) return new RoundedRectangle();
        if (shapeType.equalsIgnoreCase("Square")) return new RoundedSquare();
        return null;
    }
}