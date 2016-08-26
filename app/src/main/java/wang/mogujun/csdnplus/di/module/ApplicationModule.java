package wang.mogujun.csdnplus.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.BuildConfig;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.UIThread;
import wang.mogujun.csdnplus.data.executor.JobExecutor;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.geeknews.data.repository.NewsDataRepository;
import wang.mogujun.csdnplus.geeknews.domain.repository.NewsRepository;
import wang.mogujun.csdnplus.user.data.repository.UserDataRepository;
import wang.mogujun.csdnplus.user.domain.repository.UserRepository;
import wang.mogujun.csdnplus.view.CSDNNavigator;

/**
 * Created by WangJun on 2016/6/7.
 */
@Module
public class ApplicationModule {

    private final CSDNApplication mApplication;

    public ApplicationModule(CSDNApplication application){
        this.mApplication = application;
    }

    @Singleton
    @Provides
    Context provideApplicationContext(){
        return this.mApplication;
    }

    @Singleton
    @Provides
    EventBus provideEventBus(){
        //TODO 根据BuildConfig.DEBUG来设置
        return EventBus
                .builder()
                .throwSubscriberException(BuildConfig.DEBUG)
                .logNoSubscriberMessages(BuildConfig.DEBUG)
                .build();
    }

    @Singleton
    @Provides
    Gson provideGson(){
        Gson gson = new GsonBuilder().create();
        return gson;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Singleton
    @Provides
    CSDNNavigator provideNavigator() {
        return new CSDNNavigator();
    }

    @Singleton
    @Provides
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }

    @Singleton
    @Provides
    NewsRepository provideNewRepository(NewsDataRepository newsDataRepository) {
        return newsDataRepository;
    }






}
