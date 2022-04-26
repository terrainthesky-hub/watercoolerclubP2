package com.watercooler.daos;

import com.watercooler.entities.SkillTest;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SkillTestDAOImp implements SkillTestDAOInt {
    public static Logger logger = LogManager.getLogger(SkillTestDAOImp.class);

    @Override
    public List<SkillTest> getAllSkillTests() {
        logger.info("BEGIN DAL function getAllSkillTests");
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
            logger.info("FINISH DAL function getAllSkillTests with result:\n" + skillTests);
            return skillTests;
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error("ERROR with DAL function getAllSkillTests with error: " + exception.getMessage());
            return null;
        }
    }

    @Override
    public SkillTest getSpecificSkillTest(int testId) {
        logger.info("BEGIN DAL function getSpecificSkillTest with information:\n" + testId);
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
            logger.info("FINISH DAL function getSpecificSkillTest with result:\n" + skillTest);
            return skillTest;
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error("ERROR with DAL function getSpecificSkillTest with error: " + exception.getMessage());
            return null;
        }
    }

    @Override
    public int placePassingApplicant(int testId, int individualId) {
        logger.info("BEGIN DAL function placePassingApplicant with information:\n" + testId + "\n" + individualId);
        try(Connection connection = DatabaseConnection.createConnection()) {
            String sqlString = "insert into passed_skill_tests values(?, ?)";
            PreparedStatement sqlPrepared = connection.prepareStatement(sqlString);
            sqlPrepared.setInt(1, individualId);
            sqlPrepared.setInt(2, testId);
            int rowcount = sqlPrepared.executeUpdate();
            logger.info("FINISH DAL function placePassingApplicant with result:\n" + rowcount);
            return rowcount;
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error("ERROR with DAL function placePassingApplicant with error: " + exception.getMessage());
            return 0;
        }
    }
}
