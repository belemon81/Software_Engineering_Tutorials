package Tut8.singleton;

//Create the FIT_Test for testing purpose
public class FIT_Test {
    //TODO: Implement the main() method
    public static void main(String args[]) {
        //Create 2 new instances (objects) by calling getInstance() method
        FIT fit = FIT.getInstance();
        FIT fit1 = FIT.getInstance();
        //With 1st instance, display given text in upper case
        System.out.println(fit.toUpper());
        //With 2nd instance, display given text in lower case
        System.out.println(fit.toLower());
    }
}
