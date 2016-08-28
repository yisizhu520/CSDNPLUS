package wang.mogujun.csdnplus.di.component;

/**
 * Created by WangJun on 2016/6/7.
 */

import dagger.Component;
import wang.mogujun.csdnplus.blog.BlogRecommendListPresenter;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.di.module.BlogModule;

@PerFragment
@Component(dependencies = {ApplicationComponent.class}, modules = {BlogModule.class})
public interface BlogComponent {

    void inject(BlogRecommendListPresenter presenter);

}
