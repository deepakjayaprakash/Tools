package HTTPUtils;

import com.netflix.config.ConfigurationManager;
import io.netty.handler.codec.http.HttpMethod;
import org.apache.commons.configuration.AbstractConfiguration;
import org.asynchttpclient.*;

import java.util.concurrent.CompletableFuture;

/**
 * Created by deepak.jayaprakash on 31/10/18.
 */
public class HTTPCaller {
    private static DefaultAsyncHttpClient client = new DefaultAsyncHttpClient(new DefaultAsyncHttpClientConfig.Builder()
            .setConnectTimeout(10000)
            .build());

    public static Request buildRequest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setMethod(HttpMethod.GET.name());
        requestBuilder.setUrl("http://www.google.com");
        requestBuilder.setRequestTimeout(4000);
        return requestBuilder.build();
    }

    public static void syncCall() {
        Request request = buildRequest();
        try {
            Response response = client.executeRequest(request).get();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void asyncCall() {
        CompletableFuture<Response> partial = client.executeRequest(buildRequest()).toCompletableFuture();
        partial.handle((response, throwable) -> {
            if (throwable != null) {
                System.out.println("exception " + throwable);
                return new Response.ResponseBuilder().build();
            } else {
                System.out.println("response" + response);
                return response;
            }
        });
    }

    public static void main(String[] args) {
//        syncCall();
//        asyncCall();
//        client.close(); // if you dont close this then program does not terminate
        hystrixCall();
    }

    public static void hystrixCall() {
        try {
            AbstractConfiguration configInstance = ConfigurationManager.getConfigInstance();
            configInstance.setProperty(
                    "hystrix.command.CommandExecutor.execution.timeout.enabled", true);
            configInstance.setProperty(
                    "hystrix.command.CommandExecutor.execution.isolation.thread.timeoutInMilliseconds", 200);
            // set other configs here
            Response response = new CommandExecutor(buildRequest()).execute();
            System.out.println(response);
            CommandExecutor.closeClient();
        } catch (Exception e) {
            System.out.println("Hystrix Exception");
            e.printStackTrace();
        }
    }
}
