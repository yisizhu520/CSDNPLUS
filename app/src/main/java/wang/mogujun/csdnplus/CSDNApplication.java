package wang.mogujun.csdnplus;

import android.app.Application;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import wang.mogujun.csdnplus.data.cache.LoginPrefs;
import wang.mogujun.csdnplus.data.cache.UserDetailPrefs;
import wang.mogujun.csdnplus.di.component.ApplicationComponent;
import wang.mogujun.csdnplus.di.component.DaggerApplicationComponent;
import wang.mogujun.csdnplus.di.module.ApplicationModule;

/**
 * Created by WangJun on 2016/6/7.
 */
public class CSDNApplication extends Application {

    public static final String DEFAULT_LOG_TAG = "MOGUJUN";

    private ApplicationComponent mApplicationComponent;

    private static CSDNApplication mInstance;

    public static CSDNApplication getInstance(){
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //TODO 在ext包里构建基础preference
        LoginPrefs.init(this);
        UserDetailPrefs.init(this);
        initInjector();
        initLogger();
        initLeakCanary();
        initBlockCanary();

    }

    private void initInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }


    private void initBlockCanary() {

    }

    private void initLeakCanary() {

    }

    private void initLogger(){
        Logger
                .init(DEFAULT_LOG_TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(4)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(4)                // default 0
                .logTool(new AndroidLogTool()); // custom log tool, optional
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }




}
