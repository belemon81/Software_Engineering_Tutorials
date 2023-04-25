package Tut8.factory;

// Creating the Health class that extends Course abstract class 
class Health extends Course {
    // TODO: Implement getDuration() method: set a specific duration and print value
    public void getDuration() {
        this.duration = 400;
        System.out.println("Health duration: " + this.duration);
    }

    // TODO: Implement getFeePerSemester() method: set a specific fee and print value
    public void getFeePerSemester() {
        this.fee = 800;
        System.out.println("Health fee: " + this.fee);
    }
}// end of Health class.