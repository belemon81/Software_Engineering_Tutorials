package Tut8.prototype;

import java.util.Hashtable;

/* Create the ShapeCache class to get concrete classes from database 
   and store them in a Hashtable. */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    /*
     * TODO: Implement the loadCache() method
     * For each shape run database query and
     * create shape shapeMap.put(shapeKey, shape);
     */
    public static void loadCache() {
        if (!shapeMap.containsKey("Rectangle")) shapeMap.put("Rectangle", new Rectangle());
        if (!shapeMap.containsKey("Circle")) shapeMap.put("Circle", new Circle());
        if (!shapeMap.containsKey("Square")) shapeMap.put("Square", new Square());
    }
}