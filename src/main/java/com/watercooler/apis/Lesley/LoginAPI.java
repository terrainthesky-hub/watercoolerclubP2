package com.watercooler.apis.Lesley;

import com.watercooler.daos.UsernamePasswordApplicantDAOImp;
import com.watercooler.daos.UsernamePasswordApplicantDAOInterface;
import com.watercooler.daos.UsernamePasswordCompanyDAOImp;
import com.watercooler.daos.UsernamePasswordCompanyDAOInterface;
import com.watercooler.saos.UsernamePasswordApplicantSAOImp;
import com.watercooler.saos.UsernamePasswordApplicantSAOInterface;
import com.watercooler.saos.UsernamePasswordCompanySAOImp;
import com.watercooler.saos.UsernamePasswordCompanySAOInterface;
import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginAPI {

    public static Logger logger = LogManager.getLogger(LoginAPI.class);

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        UsernamePasswordApplicantDAOInterface appDAO = new UsernamePasswordApplicantDAOImp();
        UsernamePasswordApplicantSAOInterface appSAO = new UsernamePasswordApplicantSAOImp(appDAO);
        UsernamePasswordCompanyDAOInterface compDAO = new UsernamePasswordCompanyDAOImp();
        UsernamePasswordCompanySAOInterface compSAO = new UsernamePasswordCompanySAOImp(compDAO);
        JavalinController controller = new JavalinController(appSAO, compSAO);


//        UsernamePasswordApplicantDAOInterface DAO = new UsernamePasswordApplicantDAOImp();
//        UsernamePasswordCompanySAOInterface SAO = new UsernamePasswordApplicantDAOImp(UsernamePasswordApplicantDAOImp);


//        JavalinController controller = new JavalinController();

        app.post("/login/applicant", controller.UnPwApplicantVerify);

        app.post("/login/company", controller.UnPwCompanyVerify);

        app.post("/create/applicant", controller.UnPwApplicantCreate);

        app.post("/create/company", controller.UnPwCompanyCreate);

//        app.post("/get/applicant/By{id}", controller.UnPwApplicantGet);
//
//        app.post("/get/company/By{id}", controller.UnPwCompanyGet);

        app.start();

    } // main end
}
