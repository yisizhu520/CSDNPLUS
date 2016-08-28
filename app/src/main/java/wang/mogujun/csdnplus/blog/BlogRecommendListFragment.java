package wang.mogujun.csdnplus.blog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.view.LazyBaseFragment;
import wang.mogujun.ext.utils.TipUtils;
import wang.mogujun.uikit.decorator.BorderDividerItemDecoration;
import wang.mogujun.uikit.loadmore.LoadMoreViewFactory;

/**
 * Created by WangJun on 2016/8/28.
 */
public class BlogRecommendListFragment extends
        LazyBaseFragment<BlogRecommendListContract.View,BlogRecommendListContract.Presenter>
        implements BlogRecommendListContract.View,BlogRecyclerAdapter.BlogItemClickListener{

    @BindView(R.id.data_rv)
    RecyclerView mDataRv;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    @BindView(R.id.ptr_frame)
    PtrFrameLayout mPtrFrame;

    @BindDimen(R.dimen.spacing_small)
    int mDividerBorderWidth;

    protected BlogRecyclerAdapter mAdapter;

    public static BlogRecommendListFragment newInstance() {
        BlogRecommendListFragment fragment = new BlogRecommendListFragment();
        return fragment;
    }

    @Override
    public BlogRecommendListContract.Presenter createPresenter() {
        return new BlogRecommendListPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRefreshView();
        initListView();
    }

    private void initRefreshView() {
        final StoreHouseHeader header = new StoreHouseHeader(getActivity());
        //header.setBackgroundColor(Color.BLACK);
        header.setPadding(0, mDividerBorderWidth, 0, mDividerBorderWidth);
        header.initWithString(getString(R.string.app_name));
        mPtrFrame.setHeaderView(header);
        mPtrFrame.addPtrUIHandler(header);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                presenter.loadNewData();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mDataRv, header);
            }
        });
    }

    private void initListView() {
        mDataRv.addItemDecoration(
                new BorderDividerItemDecoration(mDividerBorderWidth,
                        mDividerBorderWidth));
        mDataRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new BlogRecyclerAdapter(null,this);
        mDataRv.setAdapter(mAdapter);
        View loadMoreView = LoadMoreViewFactory.createLoadMoreView(getActivity(),1);
        mAdapter.setLoadingView(loadMoreView);
        mAdapter.openLoadMore(DomainConstants.DEFAULT_PAGE_SIZE, true);
        mAdapter.setOnLoadMoreListener(() -> presenter.loadMoreData());
        mDataRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        //TODO 需要抽取到GlideUtil类的方法里么
                        Glide.with(getActivity()).resumeRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Glide.with(getActivity()).pauseRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        Glide.with(getActivity()).pauseRequests();
                        break;

                }
            }
        });
    }


    @Override
    public void onFirstUserVisible() {
        super.onFirstUserVisible();
        mPtrFrame.post(() -> mPtrFrame.autoRefresh());
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_common_refresh_list;
    }

    @Override
    public void showLoading() {
        //TODO 需要区分自动下拉刷新与加载loadingView的情况么
    }

    @Override
    public void hideLoading() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void showNewData(List<BlogRecommendListInfo> data) {
        mAdapter.setNewData(data);
        mAdapter.openLoadMore(data.size(),true);
    }

    @Override
    public void showNewDataError(String msg) {
        TipUtils.showSnack(getActivity(), msg);
    }

    @Override
    public void showMoreData(List<BlogRecommendListInfo> data) {
        mAdapter.notifyDataChangedAfterLoadMore(data, true);
    }

    @Override
    public void showMoreDataError(String msg) {
        TipUtils.showSnack(getActivity(), msg);
//        TextView tv = new TextView(getActivity());
//        tv.setTextColor(Color.BLACK);
//        tv.setText("加载更多失败了");
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, DimenUtils.dp2px(getActivity(),48));
//        tv.setLayoutParams(lp);
//        mAdapter.addFooterView(tv);
        mAdapter.notifyDataChangedAfterLoadMore(true);
    }

    @Override
    public void showNoMoreData() {
        TipUtils.showToast(getActivity(), "厉害厉害，都被你看光了，满足了吧o(*￣︶￣*)o");
        mAdapter.notifyDataChangedAfterLoadMore(false);
    }

    @Override
    public void showEmptyView() {
        mEmptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        mEmptyLayout.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onContentClick(View view, BlogRecommendListInfo item) {

    }

    @Override
    public void onAvatarClick(View v, BlogRecommendListInfo item) {

    }
}
