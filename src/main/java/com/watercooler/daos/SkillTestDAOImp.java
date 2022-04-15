package com.watercooler.daos;

import com.watercooler.entities.SkillTest;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillTestDAOImp implements SkillTestDAOInt {

    @Override
    public List<SkillTest> getAllSkillTests() {
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sqlString = "select * from skill_test_table";
            Statement sqlStatement = connection.createStatement();
            sqlStatement.execute(sqlString);
            ResultSet resultSet = sqlStatement.getResultSet();
            List<SkillTest> skillTests = new ArrayList<>();
            while (resultSet.next()) {
                SkillTest skillTest = new SkillTest(
                        resultSet.getInt("skill_test_id"),
                        resultSet.getString("question_one"),
                        resultSet.getString("answer_one"),
                        resultSet.getString("question_two"),
                        resultSet.getString("answer_two"),
                        resultSet.getString("question_three"),
                        resultSet.getString("answer_three"),
                        resultSet.getInt("company_id")
                );
                skillTests.add(skillTest);
            }
            return skillTests;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public SkillTest getSpecificSkillTests(int testId) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sqlString = "select * from skill_test_table where skill_test_id = ?";
            PreparedStatement sqlPrepared = connection.prepareStatement(sqlString);
            sqlPrepared.setInt(1, testId);
            ResultSet result = sqlPrepared.executeQuery();
            result.next();
            SkillTest skillTest = new SkillTest(
                    result.getInt("skill_test_id"),
                    result.getString("question_one"),
                    result.getString("answer_one"),
                    result.getString("question_two"),
                    result.getString("answer_two"),
                    result.getString("question_three"),
                    result.getString("answer_three"),
                    result.getInt("company_id")
            );
            return skillTest;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public int placePassingApplicant(int testId, int individualId) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sqlString = "insert into passed_skill_tests values(?, ?)";
            PreparedStatement sqlPrepared = connection.prepareStatement(sqlString);
            sqlPrepared.setInt(1, individualId);
            sqlPrepared.setInt(2, testId);
            int rowcount = sqlPrepared.executeUpdate();
            return rowcount;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }
}
