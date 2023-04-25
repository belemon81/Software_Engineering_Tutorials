package Tut8.singleton;

//Create the FIT class with getInstance method()
public class FIT {
    private static FIT instance = null;
    public String text;

    private FIT() {
        text = "Faculty of Information Technology - Hanoi University";
    }

    // TODO: Implement the getInstance method
    public static FIT getInstance() {
        /*
         * if 'instance' is equal to null, set 'instance' as a new object
         * otherwise, return 'instance'
         */
        if (instance == null) {
            instance = new FIT();
        }
        return instance;
    }

    // TODO: Implement 2 below methods
    public String toUpper() {
        // Set the given text to upper case
        return text.toUpperCase();

    }

    public String toLower() {
        // Set the given text to lower case
        return text.toLowerCase();
    }
}
