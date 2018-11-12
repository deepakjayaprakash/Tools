package Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by deepak.jayaprakash on 09/11/18.
 */
@Configuration
public class SampleConfig {
    @Bean(initMethod = "onCreate", destroyMethod = "onDestroy")
    @Scope("prototype")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}
