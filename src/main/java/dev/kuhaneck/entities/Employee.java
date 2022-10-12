package dev.kuhaneck.entities;

import io.javalin.http.Context;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double reimbursementAmount;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String username, String password, double reimbursementAmount) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.reimbursementAmount = reimbursementAmount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reimbursementAmount=" + reimbursementAmount +
                '}';
    }
    public Employee getEmployeeObject(Context ctx){
        Employee e = ctx.sessionAttribute("loggedInEmployee");

        return e;
    }
}
