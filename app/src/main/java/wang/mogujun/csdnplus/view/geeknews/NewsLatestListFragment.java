package wang.mogujun.csdnplus.view.geeknews;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrFrameLayout;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;
import wang.mogujun.csdnplus.view.LazyBaseFragment;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsLatestListFragment extends
        LazyBaseFragment<NewsLatestListContract.View, NewsLatestListContract.Presenter>
        implements NewsLatestListContract.View {

    @BindView(R.id.data_rv)
    RecyclerView mDataRv;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    @BindView(R.id.ptr_frame)
    PtrFrameLayout mPtrFrame;

    @Inject
    NewsLatestPresenter mNewsLatestPresenter;

    public static NewsLatestListFragment newInstance() {
        return new NewsLatestListFragment();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_common_refresh_list;
    }

    @Override
    public NewsLatestListContract.Presenter createPresenter() {
        return mNewsLatestPresenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNewData(List<NewsLatestListInfo> data) {

    }

    @Override
    public void showNewDataError(String msg) {

    }

    @Override
    public void showMoreData(List<NewsLatestListInfo> data) {

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

}
