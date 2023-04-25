package Tut8.abstract_factory;

/* Create a Factory generator/producer class to get factories
 * by passing an information such as Shape
 */
public class FactoryProducer {
    //TODO: implement the getFactory() method
    public static AbstractFactory getFactory(boolean rounded) {
        //check for 'rounded' status then return the correct Factory
        if (rounded == false) {
            return new ShapeFactory();
        } else {
            return new RoundedShapeFactory();
        }
    }
}
