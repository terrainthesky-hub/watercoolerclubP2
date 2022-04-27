package com.watercooler.daos;

import com.watercooler.entities.UsernamePasswordApplicant;
import com.watercooler.entities.UsernamePasswordCompany;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;

public class UsernamePasswordCompanyDAOImp implements UsernamePasswordCompanyDAOInterface {




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

    @Override
    public int verifyUsernamePasswordCompany(UsernamePasswordCompany UnPw) {
        try(Connection connection = DatabaseConnection.createConnection()){
            int counter = 0;
            String sql = "select company_id from usernames_passwords_company where company_username = ? and company_password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, UnPw.getCompanyUsername());
            ps.setString(2, UnPw.getCompanyPassword());
            ResultSet rs = ps.executeQuery(); // executeQuery returns a result set object with the results
            if (rs.next()) {
                return rs.getInt("company_id");
            }
            else {
                return 0;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return 0;
        }

    }

}
