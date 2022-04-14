package com.watercooler.daos;

import com.watercooler.entities.SkillTest;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class SkillTestDAOImp implements SkillTestDAOInt {

    @Override
    public List<SkillTest> getAllSkillTests() {
        try(Connection connection = DatabaseConnection.createConnection()) {
            return null;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public SkillTest getSpecificSkillTests(int testId) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            return null;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public int placePassingApplicant(int testId, int individualId) {
        try(Connection connection = DatabaseConnection.createConnection()) {
            return 0;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0;
        }
    }
}
