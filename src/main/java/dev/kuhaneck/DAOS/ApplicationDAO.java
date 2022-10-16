package dev.kuhaneck.DAOS;


import dev.kuhaneck.controllers.EmployeeController;
import dev.kuhaneck.entities.Employee;

import dev.kuhaneck.entities.Application;
import dev.kuhaneck.utils.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO implements GenericDAO<Application> {



    @Override//modify this like the current manager get by status
    public Application getById(int id) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select app_id, submission_date ,due_date ,course_status ,course_description\n" +
                    ",course_cost ,work_relation ,format,course_category, course_time, course_location  ,employee_id, first_name,last_name, reimbursement_funds_remaining from project1.applications a\n" +
                    "left join project1.gradeformat g on (a.grading_format= g.format_id)\n" +
                    "left join project1.course_type ct ON (a.type_of_course = ct.course_type_id)\n" +
                    "left join project1.employees e on (a.ein=e.employee_id) where a.app_id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();


            if(rs.next()){

                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDouble("reimbursement_funds_remaining")
                );

                Application application = new Application(
                        rs.getInt("app_id"),
                        rs.getString("submission_date"),
                        rs.getString("due_date"),
                        rs.getString("course_location"),
                        rs.getString("course_status"),
                        rs.getString("course_time"),
                        rs.getString("course_description"),
                        rs.getDouble("course_cost"),
                        rs.getString("work_relation"),
                        rs.getString("format"),
                        rs.getString("course_category"),
                        e

                );                        ps.close();

                return application;

            }


        }catch (SQLException e ){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<Application> getAll() {
        List<Application> appList = new ArrayList<>();
        String sql = "select app_id, submission_date ,due_date ,course_status ,course_description\n" +
                ",course_cost ,work_relation ,format,course_category, course_time, course_location  ,employee_id, first_name,last_name," +
                " reimbursement_funds_remaining from project1.applications a\n" +
                "left join project1.gradeformat g on (a.grading_format= g.format_id)\n" +
                "left join project1.course_type ct ON (a.type_of_course = ct.course_type_id)\n" +
                "left join project1.employees e on (a.ein=e.employee_id) where course_status like 'Under review%'";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDouble("reimbursement_funds_remaining")
                );
                appList.add( new Application( rs.getInt("app_id"),
                        rs.getString("submission_date"),
                        rs.getString("due_date"),
                        rs.getString("course_location"),
                        rs.getString("course_status"),
                        rs.getString("course_time"),
                        rs.getString("course_description"),
                        rs.getDouble("course_cost"),
                        rs.getString("work_relation"),
                        rs.getString("format"),
                        rs.getString("course_category"),
                        e)
                );



            }

            return appList;


        }catch (SQLException e){
            e.printStackTrace();
        }







        return null;
    }

    @Override
    public Application create(Application application) {
        return null;
    }

    @Override
    public void update(Application tUpdate) {

    }


    public Application createNew(Application application) {
        String sql ="with new_app as (insert into project1.applications values (default,to_date(?,'YYYY-MM-DD') ,to_date(?,'YYYY-MM-DD'),?,?,?,?,?,?,?,?,?) returning *)\n" +
                "select * from new_app a left join project1.gradeformat g on(a.grading_format=g.format_id)\n" +
                "left join project1.course_type ct on(a.type_of_course = ct.course_type_id)\n" +
                "left join project1.employees e on(a.ein=e.employee_id)\n";

        // Unsure how to add enums into the creation process without changing parameters.



        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,application.getSubmissionDate());
            ps.setString(2,application.getDueDate());
            ps.setString(3, application.getStatus());
            ps.setString(4, application.getLocation());
            ps.setString(5, application.getTime());
            ps.setString(6, application.getDescription());
            ps.setDouble(7, application.getCost());
            ps.setString(8, application.getWorkRelation());
            ps.setInt(9, application.getGradeFormatId());
            ps.setInt(10, application.getCourseTypeId());
            ps.setInt(11, application.getEmployee().getEmployeeId());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                application.setAppId(rs.getInt("app_id"));
                return application;

            }




        }catch (SQLException e){
            e.printStackTrace();
        }





        return null;
    }

    public void updated(String status, int id) {
        String sql = "update project1.applications set course_status =? where app_id = ?";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);
            System.out.println(status);
            ps.execute();
            ps.close();



        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    @Override
    public void delete(int id) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "delete * from project1.applications where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

        }catch(SQLException e){
            e.printStackTrace();
        }



    }
    public List<Application> getAllByEIN(int id){
        EmployeeDAO employeeDAO =new EmployeeDAO();
        Employee employee = new Employee();
        employee = employeeDAO.getById(id);

        List<Application> apps = new ArrayList<>();
        String sql = "select * from project1.applications where ein =?";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                apps.add(new Application(rs.getInt("app_id"),
                            rs.getString("submission_date"),
                            rs.getString("due_date"),
                            rs.getString("course_status"),
                            rs.getString("course_location"),
                            rs.getString("course_time"),
                            rs.getString("course_description"),
                            rs.getDouble("course_cost"),
                            rs.getString("work_relation"),
                            rs.getInt("grading_format"),
                            rs.getInt("type_of_course"),
                            employee
                ))


                ;

            }return apps;


        }catch (SQLException e){
            e.printStackTrace();
        }

    return null;
    }



}
