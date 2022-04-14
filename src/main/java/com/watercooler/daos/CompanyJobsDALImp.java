package com.watercooler.daos;

import com.watercooler.entities.Applicant;
import com.watercooler.entities.Job;
import com.watercooler.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyJobsDALImp  implements CompanyJobsDAL {

    @Override
    public Job postJob(Job job){
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into job_table values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, job.getJobId());
            ps.setString(2, job.getTitle());
            ps.setString(3, job.getType());
            ps.setString(4, job.getDescription());
            ps.setInt(5, job.getCompanyId());
            ps.setString(6, job.getLocation());
            ps.setString(7, job.getCompanyName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            job.setJobId(rs.getInt("job_id"));
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };

    @Override
    public List<Job> viewJobs(int companyId){
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from job_table where company_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, -1);
            ResultSet rs = ps.executeQuery();
            List<Job> testJobs = new ArrayList<>();
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
                testJobs.add(job);
            }
            return testJobs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };

    @Override
    public List<Applicant> viewApplicants(int jobId){
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from applied_jobs where job_id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, jobId);
            ResultSet rs = ps.executeQuery();
            List<Applicant> applicants = new ArrayList<>();
            while (rs.next()){
                Applicant applicant = new Applicant(
                        rs.getInt("applicant_id"),
                        rs.getString("applicant_first_name"),
                        rs.getString("applicant_last_name"),
                        rs.getLong("applicant_phone_number"),
                        rs.getString("applicant_email"),
                        rs.getString("applicant_work_history"),
                        rs.getString("applicant_references"),
                        rs.getString("applicant_education")
                );
                applicants.add(applicant);
            }
            return applicants;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };

    @Override
    public int deleteJobs(int jobId){
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "delete from job_table where job_id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, jobId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    };
}
