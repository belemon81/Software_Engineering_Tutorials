package Tut10.ex3;

import Tut10.ex2.Book;
import Tut10.ex2.GoldenEditionBook;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class HumanDemo {
    public static void main(String[] args) throws IllegalClassFormatException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input student's information:");
            String firstName = scanner.next();
            String lastName = scanner.next();
            String facultyNumber = scanner.next();
            scanner.nextLine();
            Student student = new Student(firstName,lastName,facultyNumber);

            System.out.println("Input worker's information");
            firstName = scanner.next();
            lastName = scanner.next();
            double weekSalary = scanner.nextDouble();
            int workHoursPerDay = scanner.nextInt();
            scanner.nextLine();
            Worker worker = new Worker(firstName,lastName,weekSalary,workHoursPerDay);
            System.out.println("\n" + student.toString());
            System.out.println(worker.toString());
        } catch (IllegalArgumentException error) {
            System.err.println(error.getMessage());
        }
    }
}
