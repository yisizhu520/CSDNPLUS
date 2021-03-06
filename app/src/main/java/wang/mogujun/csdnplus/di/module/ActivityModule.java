package wang.mogujun.csdnplus.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.di.PerFragment;

/**
 * Created by WangJun on 2016/6/7.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @PerFragment
    @Provides
    Activity activity() {
        return this.mActivity;
    }


}
