package dev.kuhaneck.DAOS;

import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ManagerDAO implements GenericDAO<Manager> {



    @Override
    public Manager getById(int id) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = " select * from managers where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Manager(
                        rs.getInt("manager_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_amount")
                );



            }



        }catch (SQLException e){
            e.printStackTrace();
        }




        return null;
    }

    public Manager getManagerByUsername(String username){
        String sql="select * from project1.managers where username =?";
        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs =ps.executeQuery();

            if(rs.next()){

                return new Manager(
                        rs.getInt("manager_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_amount")
                );



            }


        }catch(SQLException e){
            e.printStackTrace();
        }



        return null;
    }


    @Override
    public List<Manager> getAll() {
        return null;
    }

    @Override
    public Manager create(Manager manager) {
        try(Connection connection = ConnectionUtil.createConnection()) {
            String sql = "insert into project1.managers values (default,?,?,?,?, ?) returning *";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,manager.getFirstName());
            ps.setString(2,manager.getLastName());
            ps.setString(3, manager.getUsername());
            ps.setString(4, manager.getPassword());
            ps.setDouble(5,manager.getReimbursement_amount());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Manager(
                        rs.getInt("manager_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getDouble("reimbursement_amount")
                );

            }

        }catch (SQLException e) {
            e.printStackTrace();

        }
        return null;


    }

    @Override
    public void update(Manager mUpdate) {
        String sql = "update project1.managers set first_name=?,last_name=?,username = ?, pass=?, reimbursement_amount=? where manager_id =?";

        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mUpdate.getFirstName());
            ps.setString(2, mUpdate.getLastName());
            ps.setString(3, mUpdate.getUsername());
            ps.setString(4, mUpdate.getPassword());
            ps.setInt(5, mUpdate.getManagerId());

            ps.execute();



        }catch(SQLException e){
            e.printStackTrace();
        }




    }

    @Override
    public void delete(int id) {
        String sql ="delete from project1.managers where id =?";

        try(Connection connection = ConnectionUtil.createConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


}
