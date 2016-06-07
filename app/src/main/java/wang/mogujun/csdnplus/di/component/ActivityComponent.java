package wang.mogujun.csdnplus.di.component;

import android.app.Activity;

import dagger.Component;
import wang.mogujun.csdnplus.di.PerActivity;
import wang.mogujun.csdnplus.di.module.ActivityModule;

/**
 * Created by WangJun on 2016/6/7.
 */
@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity activity();

}
