package Tut8.factory;

// Create the Computer class that extends Course abstract class 
class Computer extends Course {
    // TODO: Implement getDuration() method: set a specific duration and print value
    public void getDuration() {
        this.duration = 500;
        System.out.println("Computer duration: " + this.duration);
    }

    // TODO: Implement getFeePerSemester() method: set a specific fee and print value
    public void getFeePerSemester() {
        this.fee = 1000;
        System.out.println("Computer fee: " + this.fee);
    }
} 
