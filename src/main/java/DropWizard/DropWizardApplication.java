package DropWizard;

import DropWizard.resource.SimpleAPI;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

/**
 * Created by deepak.jayaprakash on 31/10/18.
 */
public class DropWizardApplication extends Service<Configuration> {
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.addResource(SimpleAPI.class);
    }

    // command line arguments is "server"
    // to test hit this: curl -X GET "localhost:8080/simpleAPI/getTest"
    public static void main(String[] args) throws Exception {
        new DropWizardApplication().run(args);
    }
}
