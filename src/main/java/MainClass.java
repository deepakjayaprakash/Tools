import Spring.HelloWorld;
import Spring.SampleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by deepak.jayaprakash on 31/10/18.
 */
public class MainClass {
    public static void main(String[] args) {
//        System.out.println("hello world");
//        tryBasicSpring();
        tryAnnotationBasedSpring();
    }

    private static void tryAnnotationBasedSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("HelloWorld");
        helloWorld.setData(1);

        HelloWorld helloWorld2 = (HelloWorld) context.getBean("HelloWorld");
        helloWorld2.setData(2);

        System.out.println(helloWorld.getData());
        System.out.println(helloWorld2.getData());
        helloWorld.printHello();
    }

    //java based spring
    private static void tryBasicSpring() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SampleConfig.class);
        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.setData(1);
        HelloWorld helloWorld2 = applicationContext.getBean(HelloWorld.class);
        helloWorld2.setData(2);
        helloWorld.printHello();
        helloWorld2.printHello();
    }

}
