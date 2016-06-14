package wang.mogujun.csdnplus.di.module;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.UIThread;
import wang.mogujun.csdnplus.data.executor.JobExecutor;
import wang.mogujun.csdnplus.data.repository.UserDataRepository;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.repository.UserRepository;

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
                .throwSubscriberException(true)
                .logNoSubscriberMessages(true)
                .build();
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
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }






}
