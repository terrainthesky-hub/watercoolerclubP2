package com.watercooler.saos;

import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;

public class UsernamePasswordCompanySAOImp implements UsernamePasswordCompanySAOInterface{




    @Override
    public UsernamePasswordCompany createAccountCompany(UsernamePasswordCompany createCompany) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into usernames_passwords_company values(default, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, createCompany.getCompanyUsername());
            ps.setString(2, createCompany.getCompanyPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            createCompany.setCompanyId(rs.getInt("company_id"));
            return createCompany;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsernamePasswordCompany selectCompanyAccountById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from usernames_passwords_company where company_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery(); // executeQuery returns a result set object with the results
            rs.next();
            UsernamePasswordCompany usernamePasswordCompany = new UsernamePasswordCompany(
                    rs.getInt("company_id"),
                    rs.getString("company_username"),
                    rs.getString("company_password")
            );
            return usernamePasswordCompany;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
