package HTTPUtils;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

/**
 * Created by deepak.jayaprakash on 15/11/18.
 */
public class CommandExecutor extends HystrixCommand<Response> {

    private Request request;

    private static DefaultAsyncHttpClient client = new DefaultAsyncHttpClient(new DefaultAsyncHttpClientConfig.Builder()
            .setConnectTimeout(10000)
            .build());

    public CommandExecutor(Request request) {
        super(HystrixCommandGroupKey.Factory.asKey("CommandExecutor"));
        HystrixThreadPoolKey.Factory.asKey("CommandExecutor");
        this.request = request;
    }

    @Override
    protected Response run() throws Exception {
        return client.executeRequest(request).get();
    }

    protected static void closeClient() {
        client.close();
    }
}
