package Tut8.factory;

// Create the abstract class called Course
abstract class Course {
    protected int duration; //in semesters
    protected double fee; //in dollars ($)

    // TODO: Declare 2 void abstract methods: getDuration(), getFeePerSemester()
    abstract public void getDuration();

    abstract public void getFeePerSemester();

    // TODO: Declare void method: calculateTotalFee(). Total = duration * fee
    public void calculateTotalFee() {
        System.out.printf("Total fee: %.2f", duration * fee);
    }

}