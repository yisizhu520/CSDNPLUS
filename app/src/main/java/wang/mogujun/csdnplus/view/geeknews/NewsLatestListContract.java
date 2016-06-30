package wang.mogujun.csdnplus.view.geeknews;

import java.util.List;

import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;
import wang.mogujun.uiframework.mvp.MvpBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsLatestListContract {

    interface View extends MvpView {

        void showLoading();

        void hideLoading();

        void showNewData(List<NewsLatestListInfo> data);

        void showNewDataError(String msg);

        void showMoreData(List<NewsLatestListInfo> data);

        void showMoreDataError(String msg);

        void showNoMoreData();

        void showEmptyView();

        void hideEmptyView();
    }

    static abstract class Presenter extends MvpBasePresenter<View> {

        public abstract void loadNewData();

        public abstract void loadMoreData(String lastId);

    }


}
