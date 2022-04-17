import org.testng.annotations.Test;
import org.testng.Assert;
import com.watercooler.daos.JobSearchDAOImp;
import java.util.List;




public class JobSearchDAOTests {

    JobSearchDAOImp jobSearchDAO = new JobSearchImp();

    @Test
    public void selectJob(String jobLocation, String jobType) {
        List<Job> jobList = jobSearchDAO.selectJob('testTitle2', 'testLocation2');
        Assert.assertNotEquals(jobList.size(), 0);

    }









    public List<Job> selectJob(String jobLocation, String jobType) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String append = "";
            if (jobLocation.equals("nothing") && !jobType.equals("nothing")) {
                append = " where job_type = " + jobType;
            } else if (!jobLocation.equals("nothing") && jobType.equals("nothing")){
                append = " where job_location = " + jobLocation;
            } else if (!jobLocation.equals("nothing") && !jobType.equals("nothing")){
                append = " where job_location = " + jobLocation + " and job_type = " + jobType;
            }
            String sql = "select * from job_table" + append;
            Statement s = connection.createStatement();
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
                        rs.getString("company_name)")
                );
                joblist.add(job);
            }
            //rs.next();
            return joblist;
        } catch(SQLException e){
            e.printStackTrace();
            return null;



}