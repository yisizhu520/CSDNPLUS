package wang.mogujun.csdnplus.blog;

import java.util.List;

import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.view.mvp.MvpRxBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/8/28.
 */
public class BlogRecommendListContract {

    //TODO 像这类的列表view完全可以抽象出一个父类，复用
    public interface View extends MvpView {

        void showLoading();

        void hideLoading();

        void showNewData(List<BlogRecommendListInfo> data);

        void showNewDataError(String msg);

        void showMoreData(List<BlogRecommendListInfo> data);

        void showMoreDataError(String msg);

        void showNoMoreData();

        void showEmptyView();

        void hideEmptyView();

    }

    public static abstract class Presenter extends MvpRxBasePresenter<View> {

        public abstract void loadNewData();

        public abstract void loadMoreData();

    }



}
