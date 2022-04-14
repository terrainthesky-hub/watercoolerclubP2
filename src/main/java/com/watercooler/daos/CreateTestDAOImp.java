package com.watercooler.daos;

import com.watercooler.utilities.DatabaseConnection;
import com.watercooler.entities.SkillTest;

import java.sql.*;

public class CreateTestDAOImp implements CreateTestDAOInt {
    @Override
    public int createSkillTestData(SkillTest test) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sqlStatement = "insert into skill_test_table values(default, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sqlPrepared = connection.prepareStatement(sqlStatement);
            sqlPrepared.setString(1, test.getQuestionOne());
            sqlPrepared.setString(2, test.getAnswerOne());
            sqlPrepared.setString(3, test.getQuestionTwo());
            sqlPrepared.setString(4, test.getAnswerTwo());
            sqlPrepared.setString(5, test.getQuestionThree());
            sqlPrepared.setString(6, test.getAnswerThree());
            sqlPrepared.setInt(7, test.getCompanyId());
            int rowcount = sqlPrepared.executeUpdate();
            return rowcount;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }
}

