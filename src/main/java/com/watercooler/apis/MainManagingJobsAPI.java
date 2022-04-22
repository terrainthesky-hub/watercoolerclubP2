package com.watercooler.apis;
import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainManagingJobsAPI {

    public static Logger logger = LogManager.getLogger(MainManagingJobsAPI.class);

    public static void main(String[] args) {
        logger.info("creating Javalin object now");
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.enableCorsForAllOrigins();
            javalinConfig.enableDevLogging();
        });
        logger.info("Javalin object created!");

        ManagingJobsController controller = new ManagingJobsController();

        app.post("/createJobPost", controller.createJobPost);

        app.patch("/viewPostedJobs", controller.viewJobs);

        app.patch("/viewJobApplicants", controller.viewApplicants);

        app.delete("/deleteJobPost", controller.deleteJobPost);

        logger.info("Starting web server");
        app.start();
    }
}
