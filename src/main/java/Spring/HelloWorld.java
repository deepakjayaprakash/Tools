package Spring;

import lombok.Data;

/**
 * Created by deepak.jayaprakash on 09/11/18.
 */
@Data
public class HelloWorld {
    int data;

    public void printHello() {
        System.out.println("hello world" + data);
    }

    public void onDestroy() {
        System.out.println("HelloWorld onDestroy");
    }

    public void onCreate() {
        System.out.println("HelloWorld onCreate");
    }

}
