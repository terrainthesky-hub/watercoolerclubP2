package com.watercooler.daos;

import com.watercooler.utilities.DatabaseConnection;
import com.watercooler.entities.SkillTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class CreateTestDAOImp implements CreateTestDAOInt {
    public static Logger logger = LogManager.getLogger(CreateTestDAOImp.class);

    @Override
    public int createSkillTestData(SkillTest test) {
        logger.info("BEGIN DAL function createSkillTestData with data:\n" + test);
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
            logger.info("FINISH DAL function createSkillTestData with result:\n" + rowcount);
            return rowcount;
        } catch (SQLException exception) {
            exception.printStackTrace();
            logger.error("ERROR with DAL function createSkillTestData with error: " + exception.getMessage());
            return 0;
        }
    }
}

