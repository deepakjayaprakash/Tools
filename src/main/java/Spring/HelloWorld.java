package Spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by deepak.jayaprakash on 09/11/18.
 */
@Data
public class HelloWorld {
    int data;

    @Autowired
    HelloWorldHelper helloWorldHelper;

    @Value("${testkey}")
    String testValue;

    public void printHello() {
        System.out.println("hello from HelloWorld" + data+"testvalue"+ testValue);
        helloWorldHelper.printStaticText();
    }

    public void onDestroy() {
        System.out.println("HelloWorld onDestroy");
    }

    public void onCreate() {
        System.out.println("HelloWorld onCreate");
    }

}
