package wang.mogujun.csdnplus.view.geeknews;

import java.util.List;

import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.uiframework.mvp.MvpBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsMainContract {

    interface View extends MvpView{

        void showLoading();

        void hideLoading();

        void showNewsColumns(List<NewsColumn> data);

        void showError(String msg);

    }

    static abstract class Presenter extends MvpBasePresenter<View>{
        public abstract void getNewsColumns();
    }


}
