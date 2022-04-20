package com.watercooler.apis;
import io.javalin.Javalin;

public class MainManagingJobsAPI {
    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.enableCorsForAllOrigins();
            javalinConfig.enableDevLogging();
        });

        ManagingJobsController controller = new ManagingJobsController();

        app.post("/createJobPost", controller.createJobPost);

        app.patch("/viewPostedJobs", controller.viewJobs);

        app.patch("/viewJobApplicants", controller.viewApplicants);

        app.delete("/deleteJobPost", controller.deleteJobPost);

        app.start();
    }
}
