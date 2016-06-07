package wang.mogujun.csdnplus.data.net;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import wang.mogujun.csdnplus.data.cache.LoginPrefs;

/**
 * Created by WangJun on 2016/6/5.
 */
public class HeaderParamInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        //请求定制：添加请求头
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("platform", "android")
                .addHeader("version", "1.9")//TODO 这里要改成从版本号里获取
                .addHeader("Host", "ms.csdn.net");

        String sessionId = LoginPrefs.getSessionId();
        //请求体定制：统一添加token参数
        if(original.body() instanceof FormBody){
            FormBody.Builder newFormBody = new FormBody.Builder();
            FormBody oidFormBody = (FormBody) original.body();
            for (int i = 0;i<oidFormBody.size();i++){
                newFormBody.addEncoded(oidFormBody.encodedName(i),oidFormBody.encodedValue(i));
            }

            newFormBody.add("SessionId",sessionId);
            requestBuilder.method(original.method(),newFormBody.build());
        } else if(original.method().equals("GET")){
            String originUrl = original.url().toString();
            StringBuilder sb = new StringBuilder(originUrl);
            if(originUrl.contains("?")){
                sb.append("&");
            }else{
                sb.append("?");
            }
            sb.append("?SessionId=").append(sessionId);
            requestBuilder.url(sb.toString());
        }

        Request request = requestBuilder.build();
        return chain.proceed(request);

    }


}
