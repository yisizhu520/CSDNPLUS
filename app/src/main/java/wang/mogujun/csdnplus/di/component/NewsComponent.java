package wang.mogujun.csdnplus.di.component;

/**
 * Created by WangJun on 2016/6/7.
 */

import dagger.Component;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.di.module.ActivityModule;
import wang.mogujun.csdnplus.di.module.NewsModule;
import wang.mogujun.csdnplus.view.geeknews.NewsLatestListFragment;
import wang.mogujun.csdnplus.view.geeknews.NewsMainFragment;

@PerFragment
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class, NewsModule.class})
public interface NewsComponent extends ActivityComponent{

    void inject(NewsMainFragment fragment);

    void inject(NewsLatestListFragment fragment);

}
