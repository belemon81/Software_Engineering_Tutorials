package Tut8.factory;

// Create the Admission class to generate object of subclasses
class Admission {
    // use admittingCourse method to get object of type Course
    public Course admittingCourse(String courseName) {
        //TODO: if courseName is null => return null
        if (courseName == null) {
            return null;
        }
        //TODO: if courseName is similar to 1 of 3 sub-class's name => return corresponding objects
        if (courseName.trim().equalsIgnoreCase("Health")) return new Health();
        if (courseName.trim().equalsIgnoreCase("Computer")) return new Computer();
        if (courseName.trim().equalsIgnoreCase("Health")) return new CivilService();
        //return null for default
        return null;
    }
} 