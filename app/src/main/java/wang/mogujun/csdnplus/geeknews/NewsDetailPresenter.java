package wang.mogujun.csdnplus.geeknews;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.geeknews.domain.model.CommunityDetailBean;
import wang.mogujun.csdnplus.geeknews.domain.model.DetailUpDownInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationReqBean;
import wang.mogujun.csdnplus.geeknews.domain.model.FollowOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsDetail;
import wang.mogujun.csdnplus.geeknews.domain.model.UserRelationBean;
import wang.mogujun.csdnplus.geeknews.domain.repository.NewsRepository;
import wang.mogujun.csdnplus.user.domain.repository.UserRepository;
import wang.mogujun.csdnplus.view.CSDNSubscriber;
import wang.mogujun.ext.utils.CollectionUtils;

/**
 * Created by WangJun on 2016/8/25.
 */
public class NewsDetailPresenter extends NewsDetailContract.Presenter {

    @Inject
    NewsRepository mNewsRepository;
    @Inject
    UserRepository mUserRepository;

    private UserRelationBean userRelationBean;
    private NewsDetail headlineInfoBean;

    public NewsDetailPresenter(){
        CSDNApplication.getInstance().getNewsComponent().inject(this);
    }


    @Override
    void loadDetail(String username, int articleId, String url, String type) {
        //TODO 应该有操作符可以结合Observable的
        getView().showLoadingView();
        Subscription s = mUserRepository.getRelationWith(username)
                .concatMap(userRelation -> {
                    userRelationBean = userRelation;
                    return mNewsRepository.getNewsDetail(articleId);
                })
                .concatMap(newsDetail -> {
                    headlineInfoBean = newsDetail;
                    return mNewsRepository.getCommunityDetail(newsDetail.getForum_id());
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<CommunityDetailBean>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().hideLoadingView();
                        getView().showLoadDetailFail();
                    }

                    @Override
                    public void onNext(CommunityDetailBean communityDetailBean) {
                        super.onNext(communityDetailBean);
                        getView().showAuthorInfo(userRelationBean);
                        getView().showDetail(headlineInfoBean);
                        getView().showCommunityInfo(communityDetailBean);
                        getView().hideLoadingView();

                    }
                });
        add(s);
    }

    private int mCommentPage = 1;

    @Override
    void loadComments(String url, int articleId, String type) {
        //FIXME type有三种 hackernews，content_center(不知道在哪里用？)，和普通的原地址
        if (type.contains("hackernews")) {
            url = DomainConstants.API_HACKERNEWS + articleId;
        }
        Subscription s = mNewsRepository.getCommentList(url, 1, DomainConstants.DEFAULT_COMMENT_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<CommentInfoBean>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showNewCommentsFail();

                    }

                    @Override
                    public void onNext(CommentInfoBean commentInfoBean) {
                        super.onNext(commentInfoBean);
                        if(CollectionUtils.isEmpty(commentInfoBean.getData())){
                            getView().showNewCommentsEmpty();
                        }else{
                            getView().showNewComments(commentInfoBean);
                        }
                        mCommentPage = 1;
                    }
                });
        add(s);

    }

    @Override
    void loadMoreComments(String url, int articleId, String type) {
        //FIXME type有三种 hackernews，content_center(不知道在哪里用？)，和普通的原地址
        if (type.contains("hackernews")) {
            url = DomainConstants.API_HACKERNEWS + articleId;
        }
        Subscription s = mNewsRepository.getCommentList(url, mCommentPage+1, DomainConstants.DEFAULT_COMMENT_SIZE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<CommentInfoBean>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showMoreCommentsFail();

                    }

                    @Override
                    public void onNext(CommentInfoBean commentInfoBean) {
                        super.onNext(commentInfoBean);
                        if(CollectionUtils.isEmpty(commentInfoBean.getData())){
                            getView().showNoMoreComments();
                        }else{
                            getView().showMoreComments(commentInfoBean);
                            mCommentPage++;
                        }
                    }
                });
        add(s);
    }

    @Override
    void doDetailUpDown(int articleId, String typeStr, int status) {
        getView().showLoadingView();
        String url_type;
        if(typeStr.contains("hackernews")){
            url_type = "geek_up_down";
        }else{
            url_type = "news_up_down";
        }
        Subscription s = mNewsRepository.doDetailUpDown(url_type,articleId,status)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<DetailUpDownInfo>(){

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showUpArticleFail();
                        getView().hideLoadingView();
                    }

                    @Override
                    public void onNext(DetailUpDownInfo resultBean) {
                        getView().showUpArticleSuccess(resultBean);
                        getView().hideLoadingView();
                    }

                });
        add(s);
    }

    @Override
    void addFavorite(String url, String username, String title) {
        getView().showLoadingView();
        FavoriteOperationReqBean reqBean = new FavoriteOperationReqBean();
        reqBean.setUrl(url).setUsername(username).setTitle(title);
        Subscription s = mUserRepository.addFavorite(reqBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<FavoriteOperationInfo>(){

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showCollectFail();
                        getView().hideLoadingView();
                    }

                    @Override
                    public void onNext(FavoriteOperationInfo resultBean) {
                        getView().showCollectSuccess(resultBean);
                        getView().hideLoadingView();
                    }

                });
        add(s);

    }

    @Override
    void deleteFavorite(String url, String username, String title) {
        getView().showLoadingView();
        FavoriteOperationReqBean reqBean = new FavoriteOperationReqBean();
        reqBean.setUrl(url).setUsername(username).setTitle(title);
        Subscription s = mUserRepository.addFavorite(reqBean)
                .flatMap(favoriteOperationInfo -> {
                    FavoriteOperationReqBean reqBean1 = new FavoriteOperationReqBean();
                    reqBean1.setId(favoriteOperationInfo.getData().getId()).setUsername(username);
                    return mUserRepository.deleteFavorite(reqBean1);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<FavoriteOperationInfo>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showUnCollectFail();
                        getView().hideLoadingView();
                    }

                    @Override
                    public void onNext(FavoriteOperationInfo resultBean) {
                        getView().showUnCollectSuccess(resultBean);
                        getView().hideLoadingView();
                    }
                });
        add(s);
    }

    @Override
    void doFollow(String username, String fans) {
        getView().showLoadingView();
        Subscription s = mUserRepository.doFollow(username,fans)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<FollowOperationInfo>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showAddFollowFail();
                        getView().hideLoadingView();
                    }

                    @Override
                    public void onNext(FollowOperationInfo resultBean) {
                        getView().showAddFollowSuccess(resultBean);
                        getView().hideLoadingView();
                    }
                });
        add(s);
    }

    @Override
    void unFollow(String username, String fans) {
        getView().showLoadingView();
        Subscription s = mUserRepository.unFollow(username,fans)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<FollowOperationInfo>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showAddFollowFail();
                        getView().hideLoadingView();
                    }


                    @Override
                    public void onNext(FollowOperationInfo resultBean) {
                        getView().showAddFollowSuccess(resultBean);
                        getView().hideLoadingView();
                    }
                });
        add(s);
    }
}
