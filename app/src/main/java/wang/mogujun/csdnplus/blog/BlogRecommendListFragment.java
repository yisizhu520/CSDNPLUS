package wang.mogujun.csdnplus.blog;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import in.srain.cube.views.ptr.PtrFrameLayout;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.view.MvpBaseFragment;

/**
 * Created by WangJun on 2016/8/28.
 */
public class BlogRecommendListFragment extends
        MvpBaseFragment<BlogRecommendListContract.View,BlogRecommendListContract.Presenter>
        implements BlogRecommendListContract.View{

    @BindView(R.id.data_rv)
    RecyclerView mDataRv;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    @BindView(R.id.ptr_frame)
    PtrFrameLayout mPtrFrame;

    @BindDimen(R.dimen.spacing_small)
    int mDividerBorderWidth;

    @Override
    public BlogRecommendListContract.Presenter createPresenter() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNewData(List<BlogRecommendListInfo> data) {

    }

    @Override
    public void showNewDataError(String msg) {

    }

    @Override
    public void showMoreData(List<BlogRecommendListInfo> data) {

    }

    @Override
    public void showMoreDataError(String msg) {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void hideEmptyView() {

    }
}
