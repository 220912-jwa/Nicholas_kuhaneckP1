package dev.kuhaneck.DAOS;

import dev.kuhaneck.entities.ManagerApp;
import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ManagerAppDAO implements GenericDAO<ManagerApp>{
    @Override
    public ManagerApp getById(int id) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select from project1.managerapps a\n" +
                    "left join grading_format g on (a.grading_format= g.format_id)\n" +
                    "left join course_type ct ON (a.type_of_course = ct.course_type_id)\n" +
                    "left join managers m on (a.m_id=m.manager_id)  where a.app_id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Manager m = new Manager(
                        rs.getInt("manager_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_amount")
                );

                ManagerApp managerApp = new ManagerApp(
                        rs.getInt("app_id"),
                        rs.getString("submission_date"),
                        rs.getString("due_date"),
                        rs.getString("course_location"),
                        rs.getString("course_status"),
                        rs.getString("course_time"),
                        rs.getString("course_description"),
                        rs.getDouble("course_cost"),
                        rs.getString("work_relation"),
                        rs.getInt("grading_format"),
                        rs.getInt("type_of_course"),
                        m


                );
                return managerApp;

            }


        }catch (SQLException e ){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public ManagerApp create(ManagerApp managerApp) {
        return managerApp;
    }


    public ManagerApp createManagerApp(ManagerApp managerApp) {
        String sql ="with new_app as (insert into project1.managerapps values (default,to_date(?,'YYYY-MM-DD') ,to_date(?,'YYYY-MM-DD'),?,?,?,?,?,?,?,?,?) returning *)\n" +
                "select * from new_app a left join project1.gradeformat g on(a.grading_format=g.format_id)\n" +
                "left join project1.course_type ct on(a.type_of_course = ct.course_type_id)\n" +
                "left join project1.managers e on(a.m_id=e.manager_id)\n";




        try(Connection connection = ConnectionUtil.createConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, managerApp.getSubmissionDate());
            ps.setString(2, managerApp.getDueDate());
            ps.setString(3, managerApp.getStatus());
            ps.setString(4, managerApp.getLocation());
            ps.setString(5, managerApp.getTime());
            ps.setString(6, managerApp.getDescription());
            ps.setDouble(7, managerApp.getCost());
            ps.setString(8, managerApp.getWorkRelation());
            ps.setInt(9, managerApp.getGradeFormatId());
            ps.setInt(10, managerApp.getCourseTypeId());
            ps.setInt(11, managerApp.getManager().getManagerId());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                managerApp.setAppId(rs.getInt("app_id"));
                return managerApp;

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(ManagerApp mUpdate) {
        String sql = "update project1.managerapps set status =? where app_id = ?";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mUpdate.getStatus());
            ps.setInt(2, mUpdate.getAppId());
            ps.execute();



        }catch (SQLException e){
            e.printStackTrace();
        }


    }






    @Override
    public void delete(int id) {

    }
}
