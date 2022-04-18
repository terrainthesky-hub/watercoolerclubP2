package com.watercooler.daos;

import com.watercooler.entities.Job;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobSearchDAOImp implements JobSearchDAOInt{

    @Override
    public List<Job> selectJob(String jobLocation, String jobType) {

        try(Connection connection = DatabaseConnection.createConnection()){
            String append = "";
            if (jobLocation.equals("nothing") && !jobType.equals("nothing")) {
                append = " where job_type = " + "'" + jobType + "'";
            } else if (!jobLocation.equals("nothing") && jobType.equals("nothing")){
                append = " where job_location = " + "'" + jobLocation + "'";
            } else if (!jobLocation.equals("nothing") && !jobType.equals("nothing")){
                append = " where job_location = " + "'" + jobLocation + "'" + " and job_type = " + "'" + jobType + "'";
            } else if (jobLocation.equals("nothing") && jobType.equals("nothing")){
                append = ""; // should be better way to do this
            }

//            System.out.println(append);
//
            String sql = "select * from job_table" + append;
            System.out.println(sql);
            Statement s = connection.createStatement();
//            select * from job_table where job_location = 'testLocation4' and job_type = 'Technology'
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            List<Job> joblist = new ArrayList<>();
            while(rs.next()){
                Job job = new Job(
                        rs.getInt("job_id"),
                        rs.getString("job_title"),
                        rs.getString("job_type"),
                        rs.getString("job_description"),
                        rs.getInt("company_id"),
                        rs.getString("job_location"),
                        rs.getString("company_name")
                );
                joblist.add(job);
            }
            //rs.next();
            return joblist;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        JobSearchDAOImp JSDI = new  JobSearchDAOImp();
        List<Job> result = JSDI.selectJob("nothing","Technology");
        System.out.println(result.toString());
    }
}

