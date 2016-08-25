package wang.mogujun.csdnplus.di.component;

/**
 * Created by WangJun on 2016/6/7.
 */

import dagger.Component;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.di.module.NewsModule;
import wang.mogujun.csdnplus.geeknews.NewsDetailPresenter;
import wang.mogujun.csdnplus.geeknews.NewsLatestPresenter;
import wang.mogujun.csdnplus.geeknews.NewsListPresenter;
import wang.mogujun.csdnplus.geeknews.NewsMainPresenter;

@PerFragment
@Component(dependencies = {ApplicationComponent.class}, modules = {NewsModule.class})
public interface NewsComponent{

//    void inject(NewsMainFragment fragment);
//
//    void inject(NewsLatestListFragment fragment);

    void inject(NewsMainPresenter presenter);

    void inject(NewsLatestPresenter presenter);

    void inject(NewsListPresenter presenter);

    void inject(NewsDetailPresenter presenter);

}
