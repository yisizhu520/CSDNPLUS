package wang.mogujun.csdnplus.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.data.net.ApiService;
import wang.mogujun.csdnplus.data.net.api.NewsApi;
import wang.mogujun.csdnplus.data.net.api.UserApi;

/**
 * Created by WangJun on 2016/6/7.
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    UserApi provideUserApi() {
        return (UserApi) createApi(UserApi.class);
    }

    @Singleton
    @Provides
    NewsApi provideNewsApi() {
        return (NewsApi) createApi(NewsApi.class);
    }

    private <T> T createApi(Class<T> clazz) {
        return ApiService.getInstance().createApi(clazz);
    }






}
