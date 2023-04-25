package Tut8.factory;

import java.io.IOException;
import java.util.Scanner;

/* Create the CourseInformation class to generate information about the duration
 * and fee of the course by using the Admission class to get the object of
 * sub-classes by passing the required information like the course being applied for */
class CourseInformation {
    public static void main(String args[]) throws IOException {
        //TODO: Create new Admission object
        Admission admission = new Admission();
        //TODO: Get user's input for the course's name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input course's name: ");
        String courseName = scanner.nextLine();
        //TODO: Create new course with created Admission
        Course newCourse = admission.admittingCourse(courseName);
        //TODO: Display the require duration in semesters, required fee per semester and for whole course
        newCourse.getDuration();
        newCourse.getFeePerSemester();
        newCourse.calculateTotalFee();
        scanner.close();
    }
}  