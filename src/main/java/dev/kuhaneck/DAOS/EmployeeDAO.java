package dev.kuhaneck.DAOS;

import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO implements  GenericDAO<Employee> {


    @Override
    public Employee getById(int id) {
        try(Connection connection =ConnectionUtil.createConnection()){
            String sql="select * from project1.employees where employee_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_funds_remaining")
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }


    public Employee getEmployeeByUsername(String username){

        String sql ="select * from project1.employees where username =?";
        try(Connection connection = ConnectionUtil.createConnection()){

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_funds_remaining")


                );
            }




        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee create(Employee employee) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into project1.employees values (default,?,?,?,?,?) returning *";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUsername());
            ps.setString(4, employee.getPassword());
            ps.setDouble(5, employee.getReimbursementAmount());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_funds_remaining")
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee eUpdate) {

        String sql ="update project1.employees set first_name = ?, last_name=?,username =?, pass=?, reimbursement_funds_remaining = ? " +
                "where employee_id = ?";

        try(Connection connection =ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, eUpdate.getFirstName());
            ps.setString(2, eUpdate.getLastName());
            ps.setString(3, eUpdate.getUsername());
            ps.setString(4, eUpdate.getPassword());
            ps.setDouble(5,eUpdate.getReimbursementAmount());
            ps.setInt(6, eUpdate.getEmployeeId());

            ps.execute();



        }catch(SQLException e){

            e.printStackTrace();
        }

    }


    @Override
    public void delete(int id) {
        String sql = " delete from project1.employees where id  = ?";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void updateEmployeeFund(double funds, int id){

        String sql = "update project1.employees set reimbursement_funds_remaining = ? where employee_id =?";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1,funds);
            ps.setInt(2, id);

            ps.execute();



        }catch(SQLException e ){
            e.printStackTrace();
        }


    }
}
