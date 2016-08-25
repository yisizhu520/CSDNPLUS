package wang.mogujun.csdnplus.geeknews;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.geeknews.domain.model.CommunityDetailBean;
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
    private CommunityDetailBean communityDetailBean;
    private CommentInfoBean commentInfoBean;

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

    }

    @Override
    void addFavorite(String url, String username, String title) {

    }

    @Override
    void deleteFavorite(String url, String username, String title) {

    }

    @Override
    void doFollow(String username, String fans) {

    }

    @Override
    void unFollow(String username, String fans) {

    }
}
