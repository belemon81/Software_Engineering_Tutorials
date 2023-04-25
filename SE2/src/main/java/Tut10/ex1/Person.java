package Tut10.ex1;

//base - parent - super class
public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.setName(name);
        this.setAge(age);
        this.setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d, Address: %s", this.getName(), this.getAge(), this.getAddress()));
        return sb.toString();
    }

    //    private boolean validateAge(int age) {
//        return age >= 1;
//    }
}
