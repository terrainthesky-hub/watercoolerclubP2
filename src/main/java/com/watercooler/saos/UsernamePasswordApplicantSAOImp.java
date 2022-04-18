package com.watercooler.saos;

import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class UsernamePasswordApplicantSAOImp implements UsernamePasswordApplicantSAOInterface {

    @Override
    public UsernamePasswordApplicant createAccountApplicant(UsernamePasswordApplicant createdApplicant) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into usernames_passwords_applicant values(default, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, createdApplicant.getApplicantUsername());
            ps.setString(2, createdApplicant.getApplicantPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            createdApplicant.setApplicantId(rs.getInt("applicant_id"));
            return createdApplicant;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsernamePasswordApplicant selectApplicantById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from usernames_passwords_applicant where applicant_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery(); // executeQuery returns a result set object with the results
            rs.next();
            UsernamePasswordApplicant usernamePasswordApplicant = new UsernamePasswordApplicant(
                    rs.getInt("applicant_id"),
                    rs.getString("applicant_username"),
                    rs.getString("applicant_password")
            );
            return usernamePasswordApplicant;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
