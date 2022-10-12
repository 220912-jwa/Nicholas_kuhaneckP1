package dev.kuhaneck.entities;

import java.sql.Date;

public class Application {

    private int appId;
    private String submissionDate;
    private String dueDate;
    private String location;
    private String status;
    private String time;
    private String description;
    private double cost;
    private String workRelation;
    private int gradeFormatId;
    private int courseTypeId;

    private Employee employee;

    public Application() {
    }

    public Application(int appId, String submissionDate, String dueDate, String location, String status, String time,
                       String description, double cost, String workRelation, int courseType,
                       int gradingFormat, Employee employee) {
        this.appId = appId;
        this.submissionDate = submissionDate;
        this.dueDate = dueDate;
        this.location = location;
        this.status = status;
        this.time = time;
        this.description = description;
        this.cost = cost;
        this.workRelation = workRelation;
        this.gradeFormatId = gradingFormat;
        this.courseTypeId = courseType;
        this.employee = employee;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getWorkRelation() {
        return workRelation;
    }

    public void setWorkRelation(String workRelation) {
        this.workRelation = workRelation;
    }



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public int getGradeFormatId() {
        return gradeFormatId;
    }

    public void setGradeFormatId(int gradeFormatId) {
        this.gradeFormatId = gradeFormatId;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appId=" + appId +
                ", submissionDate=" + submissionDate +
                ", dueDate=" + dueDate +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", workRelation='" + workRelation + '\'' +
                ", gradeFormatId=" + gradeFormatId +
                ", courseTypeId=" + courseTypeId +
                ", employee=" + employee +
                '}';
    }
}
