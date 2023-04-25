package Tut10.ex1;

import java.util.Scanner;

public class PersonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input age: ");
        int age = Integer.valueOf(scanner.nextLine());
        System.out.print("Input address: ");
        String address = scanner.nextLine();
        try {
            Child child = new Child(name, age, address);
            System.out.println(child.toString());
            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
