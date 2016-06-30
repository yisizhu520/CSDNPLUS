package wang.mogujun.csdnplus.view.geeknews;

import java.util.List;

import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.uiframework.mvp.MvpBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsListContract {

    interface View extends MvpView {

        void showLoading();

        void hideLoading();

        void showNewData(List<NewsListInfo> data);

        void showNewDataError(String msg);

        void showMoreData(List<NewsListInfo> data);

        void showMoreDataError(String msg);

        void showNoMoreData();

    }

    abstract class Presenter extends MvpBasePresenter<View> {

        abstract void loadNewData();

        abstract void loadMoreData();

    }


}
