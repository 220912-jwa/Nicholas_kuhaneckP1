package dev.kuhaneck.entities;

public class Manager {
    private int managerId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double reimbursement_amount;


    public Manager() {
    }

    public Manager(int managerId, String firstName, String lastName, String username, String password, double reimbursement_amount) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.reimbursement_amount = reimbursement_amount;
    }

    public double getReimbursement_amount() {
        return reimbursement_amount;
    }

    public void setReimbursement_amount(double reimbursement_amount) {
        this.reimbursement_amount = reimbursement_amount;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
