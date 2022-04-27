package com.watercooler.apis.Lesley;

import com.watercooler.daos.Lesley.UsernamePasswordApplicantDAOImp;
import com.watercooler.daos.Lesley.UsernamePasswordApplicantDAOInterface;
import com.watercooler.daos.Lesley.UsernamePasswordCompanyDAOImp;
import com.watercooler.daos.Lesley.UsernamePasswordCompanyDAOInterface;
import com.watercooler.saos.Lesley.UsernamePasswordApplicantSAOImp;
import com.watercooler.saos.Lesley.UsernamePasswordApplicantSAOInterface;
import com.watercooler.saos.Lesley.UsernamePasswordCompanySAOImp;
import com.watercooler.saos.Lesley.UsernamePasswordCompanySAOInterface;
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

        app.start();

    } // main end
}
