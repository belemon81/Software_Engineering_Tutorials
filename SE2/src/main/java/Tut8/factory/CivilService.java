package Tut8.factory;

// Create the CivilService class that extends Course abstract class 
class CivilService extends Course {
    // TODO: Implement getDuration() method: set a specific duration and print value
    public void getDuration() {
        this.duration = 250;
        System.out.println("Civil Service duration: " + this.duration);
    }

    // TODO: Implement getFeePerSemester() method: set a specific fee and print value
    public void getFeePerSemester() {
        this.fee = 500;
        System.out.println("Civil Service fee: " + this.fee);
    }
}