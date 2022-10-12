package dev.kuhaneck.entities;

import java.sql.Date;

public class ManagerApp {
    private int appId;
    private Date submissionDate;
    private Date dueDate;
    private String location;
    private String status;
    private String time;
    private String description;
    private double cost;
    private String workRelation;

  private int gradeFormatId;
  private int courseTypeId;
    private Manager manager;

    public ManagerApp() {
    }

    public ManagerApp(int appId, Date submissionDate, Date dueDate, String location, String status, String time,
                       String description, double cost, String workRelation, int courseTypeId,
                       int gradeFormatId, Manager manager) {
        this.appId = appId;
        this.submissionDate = submissionDate;
        this.dueDate = dueDate;
        this.location = location;
        this.status = status;
        this.time = time;
        this.description = description;
        this.cost = cost;
        this.workRelation = workRelation;
        this.gradeFormatId = gradeFormatId;
        this.courseTypeId = courseTypeId;
        this.manager = manager;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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

    public int getGradeFormatId() {
        return gradeFormatId;
    }

    public void setGradeFormatId(int gradeFormatId) {
        this.gradeFormatId = gradeFormatId;
    }

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
