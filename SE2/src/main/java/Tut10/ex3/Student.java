package Tut10.ex3;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName())
                .append(System.lineSeparator())
                .append("Faculty Number: ").append(this.getFacultyNumber())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
