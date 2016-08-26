package wang.mogujun.csdnplus.geeknews;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.data.cache.LoginPrefs;
import wang.mogujun.csdnplus.event.DetailChangeEvent;
import wang.mogujun.csdnplus.event.DetailMenuClickEvent;
import wang.mogujun.csdnplus.event.DetailMenuToggleEvent;
import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.geeknews.domain.model.CommunityDetailBean;
import wang.mogujun.csdnplus.geeknews.domain.model.DetailUpDownInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.DetailUpDownReqBean;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FollowOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsDetail;
import wang.mogujun.csdnplus.geeknews.domain.model.UserRelationBean;
import wang.mogujun.csdnplus.utils.DrawableUtil;
import wang.mogujun.csdnplus.utils.GlideUtils;
import wang.mogujun.csdnplus.view.MvpBaseFragment;
import wang.mogujun.csdnplus.widget.CSDNWebView;
import wang.mogujun.ext.utils.DateUtils;
import wang.mogujun.ext.utils.TipUtils;
import wang.mogujun.uikit.BadgeView;

/**
 * Created by WangJun on 2016/8/24.
 */
public class NewsDetailFragment extends
        MvpBaseFragment<NewsDetailContract.View,NewsDetailContract.Presenter> implements NewsDetailContract.View{


    @BindView(R.id.avatarIV) ImageView mAvatarIV;
    @BindView(R.id.progressBar) View mProgressBar;
    @BindView(R.id.authorInfoLayout) View mAuthorInfoLayout;
    @BindView(R.id.commentLayout) View mCommentLayout;
    @BindView(R.id.nameTV) TextView mNameTV;
    @BindView(R.id.dateTV) TextView mDateTV;
    @BindView(R.id.followBtn) Button mFollowBtn;
    @BindView(R.id.readCountTV) TextView mReadCountTV;
    @BindView(R.id.titleTV) TextView mTitleTV;
    @BindView(R.id.contentWV) CSDNWebView mContentWV;
    @BindView(R.id.topicDescTV) TextView mTopicDescTV;
    @BindView(R.id.moreTopicLayout) RelativeLayout mMoreTopicLayout;
    @BindView(R.id.commentLV) RecyclerView mCommentLV;
    @BindView(R.id.toolbarLayout) View mToolbarLayout;
    @BindView(R.id.menuIV) View mMenuIV;
    @BindView(R.id.detailSV)
    ScrollView mDetailSV;
    @BindView(R.id.operationLayout) View mOperationLayout;
    @BindView(R.id.writeCommentTV) TextView mWriteCommentTV;
    @BindView(R.id.upIV) ImageView mUpIV;
    @BindView(R.id.collectIV) ImageView mCollectIV;
    @BindView(R.id.commentIV) ImageView mCommentIV;
    @BindView(R.id.ptr_frame) PtrFrameLayout mRefreshLayout;

    @BindColor(R.color.black) int mNormalIconColor;
    @BindColor(R.color.colorAccent) int mSelectedIconColor;
    @BindDimen(R.dimen.default_icon_size) int mIconSize;
    @BindColor(R.color.gray) int mGrayColor;
    @BindColor(R.color.colorAccent) int mAccentColor;
    @BindDimen(R.dimen.spacing_small) int mDividerBorderWidth;

    private String mUsername;
    private int mArticleId;
    private String mUrl;
    private String mType;

    private BadgeView mCommentBadge;
    private BadgeView mUpBadge;
    private int mFavoriteId;

    private NewsDetail mDetail;

    private HeadlineCommentAdapter mCommentAdapter;
    
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    //TODO 是否应该将这些参数转化成一个类或者json字符串来传输更好一些？
    public static NewsDetailFragment newInstance( String username, int articleId, String url, String type){
        NewsDetailFragment f = new NewsDetailFragment();
        Bundle b = new Bundle();
        b.putString(NewsDetailActivity.EXTRA_USERNAME, username);
        b.putInt(NewsDetailActivity.EXTRA_ARTICLEID, articleId);
        b.putString(NewsDetailActivity.EXTRA_URL, url);
        b.putString(NewsDetailActivity.EXTRA_TYPE, type);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUsername = getArguments().getString(NewsDetailActivity.EXTRA_USERNAME);
        mArticleId = getArguments().getInt(NewsDetailActivity.EXTRA_ARTICLEID, -1);
        mUrl = getArguments().getString(NewsDetailActivity.EXTRA_URL);
        mType = getArguments().getString(NewsDetailActivity.EXTRA_TYPE);
    }

    @NonNull
    @Override
    public NewsDetailContract.Presenter createPresenter() {
        return new NewsDetailPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.news_detail_frag;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRefreshView();
        initCommentView();
        initOperationLayout();

        mRefreshLayout.post(() -> mRefreshLayout.autoRefresh(true));
    }

    private void initRefreshView() {
        final StoreHouseHeader header = new StoreHouseHeader(getActivity());
        //header.setBackgroundColor(Color.BLACK);
        header.setPadding(0, mDividerBorderWidth, 0, mDividerBorderWidth);
        header.initWithString(getString(R.string.app_name));
        mRefreshLayout.setHeaderView(header);
        mRefreshLayout.addPtrUIHandler(header);
        mRefreshLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                presenter.loadDetail(mUsername, mArticleId, mUrl, mType);
                //TODO 如何加上加载更多评论
                //presenter.loadMoreComments(mUrl, mArticleId, mType);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mDetailSV, header);
            }
        });
    }


    private void initCommentView() {
        //MARK 让recyclerView自动计算布局的大小，支持wrap_content
        LinearLayoutManager llm = new LinearLayoutManager(mActivity);
        llm.setAutoMeasureEnabled(true);
        mCommentLV.setLayoutManager(llm);
        mCommentLV.setNestedScrollingEnabled(false);
//        mCommentLV.addItemDecoration(new HorizontalDividerItemDecoration
//                .Builder(mActivity)
//                .colorResId(R.color.white_light)
//                .build());
        mCommentAdapter = new HeadlineCommentAdapter(mActivity, null);
        mCommentLV.setAdapter(mCommentAdapter);
    }

    private void initOperationLayout() {
        //为操作栏里的点赞、评论、收藏等图标设置图标和selector
        Drawable normalRes = DrawableUtil.getIconDrawable(
                MaterialDesignIconic.Icon.gmi_comment_outline, mNormalIconColor, mIconSize);
        Drawable selectedRes = DrawableUtil.getIconDrawable(
                MaterialDesignIconic.Icon.gmi_comment, mSelectedIconColor, mIconSize);
        StateListDrawable sld = DrawableUtil.newSelector(normalRes, selectedRes);
        mCommentIV.setImageDrawable(sld);
        normalRes = DrawableUtil.getIconDrawable(
                MaterialDesignIconic.Icon.gmi_favorite_outline, mNormalIconColor, mIconSize);
        selectedRes = DrawableUtil.getIconDrawable(
                MaterialDesignIconic.Icon.gmi_favorite, mSelectedIconColor, mIconSize);
        sld = DrawableUtil.newSelector(normalRes, selectedRes);
        mUpIV.setImageDrawable(sld);
        normalRes = DrawableUtil.getIconDrawable(
                MaterialDesignIconic.Icon.gmi_bookmark_outline, mNormalIconColor, mIconSize);
        selectedRes = DrawableUtil.getIconDrawable(
                MaterialDesignIconic.Icon.gmi_bookmark, mSelectedIconColor, mIconSize);
        sld = DrawableUtil.newSelector(normalRes, selectedRes);
        mCollectIV.setImageDrawable(sld);

    }


    //@OnClick(R.id.readSrcTV)
    void onReadSrcClick() {
        //TODO 跳去阅读原文
    }

    @OnClick(R.id.toolbarLayout)
    void toolbarClick() {
        //TODO 提示点击toolbar可以跳转到顶部
        mDetailSV.smoothScrollTo(0, 0);
    }

    @OnClick(R.id.menuIV)
    void onMenuClick() {
        getEventBus().post(new DetailMenuToggleEvent());
    }

    @OnClick(R.id.commentIV)
    void onCommentIconClick() {
        mDetailSV.smoothScrollTo(mDetailSV.getScrollX(), mCommentLayout.getTop());
    }

    @OnClick(R.id.upIV)
    void onUpIconClick() {
        presenter.doDetailUpDown(mArticleId, mType, DetailUpDownReqBean.STATUS_UP);
    }



    @OnClick(R.id.collectIV)
    void onCollectIconClick() {
        if (mCollectIV.isSelected()) {//已收藏
            presenter.deleteFavorite(mUrl, LoginPrefs.getUserName(), mDetail.getTitle());
        } else {
            presenter.addFavorite(mUrl, LoginPrefs.getUserName(), mDetail.getTitle());
        }
    }

    @OnClick(R.id.followBtn)
    void onFollowBtnClick() {
        if (mFollowBtn.getTag().equals(0)) {//未关注
            presenter.doFollow(mDetail.getUsername(), LoginPrefs.getUserName());
        } else {
            presenter.unFollow(mDetail.getUsername(), LoginPrefs.getUserName());
        }
    }

    @Subscribe
    void onDrawerMenuClick(DetailMenuClickEvent event) {
        switch (event.getIndex()) {
            //TODO onDrawerMenuClick
            case DetailMenuFragment.MENU_POSITION_TYPEFONT://字体大小

                break;
            case DetailMenuFragment.MENU_POSITION_NIGHTMODE://夜间模式

                break;
            case DetailMenuFragment.MENU_POSITION_READSRC://阅读原文

                break;
            case DetailMenuFragment.MENU_POSITION_MORETOPIC://相关话题

                break;
            case DetailMenuFragment.MENU_POSITION_SHARE://分享一下

                break;
            case DetailMenuFragment.MENU_POSITION_COLLECT://收藏一个
                onCollectIconClick();
                break;
        }
    }


    @Override
    public void showLoadingView() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        mProgressBar.setVisibility(View.GONE);
        mRefreshLayout.refreshComplete();
    }

    @Override
    public void showAuthorInfo(UserRelationBean author) {
        // 关注按钮的处理
        if (author.getSucc() == -1) {//自己发布的文章
            mFollowBtn.setVisibility(View.GONE);
        } else {
            setFollowBtnState(author.getStatus());
        }
        //TODO 动画效果
//        ObjectAnimator.ofFloat(mAuthorInfoLayout, "translationY", -300, 0f).setDuration(500).start();
        //ObjectAnimator.ofFloat(mAuthorInfoLayout, "alpha", 0f, 1f).setDuration(500).start();
        mAuthorInfoLayout.setVisibility(View.VISIBLE);
    }

    private void setFollowBtnState(int status) {
        if (status == 1) {//已经关注
            mFollowBtn.setText("已关注");
            mFollowBtn.setBackgroundColor(mGrayColor);
            mFollowBtn.setTag(1);
        } else {//getStatus() == 0 未关注
            mFollowBtn.setText("未关注");
            mFollowBtn.setBackgroundColor(mAccentColor);
            mFollowBtn.setTag(0);
        }
    }

    @Override
    public void showDetail(NewsDetail detail) {
        mDetail = detail;

        GlideUtils.displayCircleAvatar(mAvatarIV, detail.getAvatar());
        mDateTV.setText(DateUtils.getFlexibleDate(detail.getCreated_time()));
        mNameTV.setText(mUsername);

        mTitleTV.setText(detail.getTitle());
        mReadCountTV.setText("阅读量：" + detail.getClick_num());
        mContentWV.loadDataWithWrap(detail.getBody(), 0);
        presenter.loadComments(mUrl, mArticleId, mType);

        mCommentBadge = new BadgeView(mActivity);
        mCommentBadge.setTargetView(mCommentIV);
        mCommentBadge.setBadgeCount(detail.getComment_num());
        mUpBadge = new BadgeView(mActivity);
        mUpBadge.setTargetView(mUpIV);
        mUpBadge.setBadgeCount(detail.getSupport_num());
        mUpIV.setSelected(detail.getDing_cai() == 1);//TODO 定义状态常量
        mCollectIV.setSelected(detail.getIs_fav() == 1);
        getEventBus().post(
                new DetailChangeEvent(DetailChangeEvent.EVENT_COLLECT, detail.getIs_fav()));

        mOperationLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void showCommunityInfo(CommunityDetailBean community) {
        //更多JAVA话题：18130篇
        mTopicDescTV.setText(getString(R.string.topic_desc, community.getName(), community.getGeekCount()));
        mMoreTopicLayout.setVisibility(View.VISIBLE);
    }


    @Override
    public void showNewComments(final CommentInfoBean commentInfo) {
        mCommentAdapter.setData(commentInfo.getData());
        mCommentLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void showNewCommentsFail() {
        //TODO 加载评论失败的处理
        showToast("加载评论失败");
    }

    @Override
    public void showNewCommentsEmpty() {
        //TODO 评论为空的时候的处理
        showToast("评论为空");
    }

    @Override
    public void showLoadDetailFail() {
        mRefreshLayout.refreshComplete();
        TipUtils.showSnack(mOperationLayout, "文章内容加载失败(。﹏。*)", "重试", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadDetail(mUsername, mArticleId, mUrl, mType);
            }
        });
    }

    @Override
    public void showCollectSuccess(FavoriteOperationInfo resultBean) {
        if (resultBean.getSuccess() == 1) {
            mFavoriteId = resultBean.getData().getId();
            mCollectIV.setSelected(true);
            getEventBus().post(
                    new DetailChangeEvent(DetailChangeEvent.EVENT_COLLECT, 1));
            showToast("收藏成功，记得常去温习一下收藏夹( ╯▽╰)");
        } else {
            showCollectFail();
        }
    }

    @Override
    public void showCollectFail() {
        showToast("收藏竟然失败了！还有比这更痛苦的事么？(ーー゛)");
    }

    @Override
    public void showUnCollectSuccess(FavoriteOperationInfo resultBean) {
        if (resultBean.getSuccess() == 1) {
            mCollectIV.setSelected(false);
            getEventBus().post(
                    new DetailChangeEvent(DetailChangeEvent.EVENT_COLLECT, 0));
            showToast("取消收藏成功，看样子这篇文章你已完全掌握了呀Ψ(￣∀￣)Ψ");
        } else {
            showUnCollectFail();
        }
    }

    @Override
    public void showUnCollectFail() {
        showToast("这文章有毒啊，取消收藏失败了！(ーー゛)");
    }


    @Override
    public void showAddFollowSuccess(FollowOperationInfo resultBean) {
        if(resultBean.getSucc() == 1){
            setFollowBtnState(1);
            showToast("关注成功，跟随TA的脚步一起成长吧(╯▽╰)");
        }else{
            showAddFollowFail();
        }
    }

    @Override
    public void showAddFollowFail() {
        showToast("关注失败啦，难不成TA如此高冷？(￢_￢)");
    }

    @Override
    public void showCancelFollowSuccess(FollowOperationInfo resultBean) {
        if(resultBean.getSucc() == 1){
            setFollowBtnState(0);
            showToast("已取消关注，从此TA一步一步走，而你坐车╮(╯_╰)╭");
        }else{
            showAddFollowFail();
        }
    }

    @Override
    public void showCancelFollowFail() {
        showToast("取消关注失败啦，看样子你们分不开咯(¯﹃¯)");
    }

    @Override
    public void showMoreComments(CommentInfoBean commentInfo) {
        mCommentAdapter.addAll(commentInfo.getData());
        //mRefreshLayout.finishRefreshLoadMore();
    }

    @Override
    public void showNoMoreComments() {
        showToast("评论都加载完哒");
        //mRefreshLayout.finishRefreshLoadMore();
    }

    @Override
    public void showMoreCommentsFail() {
        //TODO 加载更多评论失败处理
        showToast("加载更多评论失败");
    }

    @Override
    public void showUpArticleSuccess(DetailUpDownInfo resultBean) {
        //TODO 所有的状态数值都应该定义成常量!
        //getStatus() == 1 已点赞 -1：已取消点赞
        if (resultBean.getInfo() != null) {
            if (resultBean.getStatus() == 1) {
                mCommentBadge.setBadgeCount(resultBean.getInfo().getComment());
                mUpBadge.setBadgeCount(resultBean.getInfo().getDing());
                mUpIV.setSelected(true);
            } else if (resultBean.getStatus() == -1) {
                mCommentBadge.setBadgeCount(resultBean.getInfo().getComment());
                mUpBadge.setBadgeCount(resultBean.getInfo().getDing());
                mUpIV.setSelected(false);
            } else {
                Logger.e("文章点赞的第三种情况");
            }
        } else {
            showUpArticleFail();
        }

    }

    @Override
    public void showUpArticleFail() {
        showToast("哎哟，手气不好，点赞居然都失败了ค(TㅅT)");
    }

    @Override
    public void showDownArticleSucess() {
        showToast("文章点赞成功");
    }

    @Override
    public void showDownArticleFail() {
        showToast("文章点赞失败");
    }





}
