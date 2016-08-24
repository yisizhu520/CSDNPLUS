package wang.mogujun.csdnplus.geeknews;

import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.geeknews.domain.model.CommunityDetailBean;
import wang.mogujun.csdnplus.geeknews.domain.model.DetailUpDownInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FollowOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.HeadlineDetailBean;
import wang.mogujun.csdnplus.geeknews.domain.model.UserRelationBean;
import wang.mogujun.uiframework.mvp.MvpBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/8/24.
 */
public class NewsDetailContract {

    interface View extends MvpView {

        void showLoadingView();

        void hideLoadingView();

        void showAuthorInfo(UserRelationBean author);

        void showDetail(HeadlineDetailBean detail);

        void showCommunityInfo(CommunityDetailBean community);

        void showNewComments(CommentInfoBean commentInfo);

        void showLoadDetailFail();

        void showCollectSuccess(FavoriteOperationInfo resultBean);

        void showCollectFail();

        void showUnCollectSuccess(FavoriteOperationInfo resultBean);

        void showUnCollectFail();

        void showAddFollowSuccess(FollowOperationInfo resultBean);

        void showAddFollowFail();

        void showCancelFollowSuccess(FollowOperationInfo resultBean);

        void showCancelFollowFail();

        void showMoreComments(CommentInfoBean commentInfo);

        void showNoMoreComments();

        void showUpArticleSuccess(DetailUpDownInfo resultBean);

        void showUpArticleFail();

        void showDownArticleSucess();

        void showDownArticleFail();

    }

    static abstract class Presenter extends MvpBasePresenter<View> {

        abstract  void loadDetail(String username, final int articleId, final String url, final String type);

        abstract void loadComments(String url, int articleId, String type);

        abstract void loadMoreComments(String url, int articleId, String type);

        abstract void doDetailUpDown(int articleId, String typeStr, int status);

        abstract void addFavorite(String url, String username, String title);

        abstract void deleteFavorite(String url, final String username, String title);

        abstract void doFollow(String username, String fans);

        abstract void unFollow(String username, String fans);

    }

}
