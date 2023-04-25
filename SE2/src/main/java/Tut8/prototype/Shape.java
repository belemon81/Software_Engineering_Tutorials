package Tut8.prototype;

// Create the Shape abstract class implementing Cloneable interface.
public abstract class Shape implements Cloneable {

    protected String type;
    private String id;

    // TODO: Declare void abstract method: draw()
    abstract void draw();

    // TODO: Implement GETTERs & SETTERs methods for given attributes

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
