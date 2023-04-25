package Tut10.ex3;

public class Worker extends Human {
    private double weekSalary;
    private int workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public int getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(int workHoursPerDay) {
        if (workHoursPerDay > 12 || workHoursPerDay < 1) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    public double getSalaryPerHour() {
        return weekSalary / 6 / workHoursPerDay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName())
                .append(System.lineSeparator())
                .append(String.format("Week salary: %.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(this.getWorkHoursPerDay())
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.getSalaryPerHour()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
