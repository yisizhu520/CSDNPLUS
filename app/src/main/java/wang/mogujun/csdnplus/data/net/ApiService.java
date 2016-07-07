package wang.mogujun.csdnplus.data.net;

import android.util.Log;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by WangJun on 2016/6/5.
 */
public class ApiService {

    private static String MOBILE_CSDN_URL = "http://ms.csdn.net/";

    private static String TAG = "ApiService";
    //FIXME 应该可以用什么配置来代替这个变量，是DEBUG还是RELEASE
    private static final boolean IS_DEV = true;


    private Retrofit mRetrofit;

    private static ApiService mInstance;

    public static ApiService getInstance() {
        if (mInstance == null) {
            synchronized (ApiService.class) {
                if (mInstance == null) {
                    mInstance = new ApiService();
                }
            }
        }
        return mInstance;
    }

    private ApiService() {
        Builder builder = new Builder().baseUrl(MOBILE_CSDN_URL).addConverterFactory(GsonConverterFactory.create()).client(getClient());
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        this.mRetrofit = builder.build();
    }


    public <T> T createApi(Class<T> clazz) {
        return this.mRetrofit.create(clazz);
    }

    private OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        if (IS_DEV) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        // 如果使用到HTTPS，我们需要创建SSLSocketFactory，并设置到client
        SSLSocketFactory sslSocketFactory = null;
        try {
            // 这里直接创建一个不做证书串验证的TrustManager
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }};
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return new OkHttpClient.Builder()
                .addInterceptor(new HeaderParamInterceptor())
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .sslSocketFactory(sslSocketFactory)
                // 信任所有主机名
                .hostnameVerifier((hostname, session) -> true)
                .cookieJar(new CookieJar() {
                    private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(HttpUrl.parse(url.host()), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(HttpUrl.parse(url.host()));
                        return cookies != null ? cookies : new ArrayList<>();
                    }
                }).build();
    }


}
