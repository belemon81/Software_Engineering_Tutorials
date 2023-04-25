package Tut10.ex3;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.charAt(0) < 'A' || firstName.charAt(0) > 'Z') {
            throw new IllegalArgumentException("Expected upper case letter! Argument: firstName");
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols! Argument: firstName");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.charAt(0) < 'A' || lastName.charAt(0) > 'Z') {
            throw new IllegalArgumentException("Expected upper case letter! Argument: lastName");
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols! Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("First Name: ").append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
