package Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by deepak.jayaprakash on 12/11/18.
 */
public class HelloWorldHelper {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldHelper.class);

    public void printStaticText() {
        System.out.println("Hello from HelloWorldHelper");
        logger.info("info log {}:"+ 1.0);
        logger.debug("debug log {}:"+ 2.0);
        logger.error("error log {}:"+ 3.0);
    }
}
