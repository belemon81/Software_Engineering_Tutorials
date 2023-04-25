package Tut10.ex1;

//child - derived class
public class Child extends Person {
    public Child(String name, int age, String address) {
        super(name, age, address);
    }

    @Override
    public void setAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
