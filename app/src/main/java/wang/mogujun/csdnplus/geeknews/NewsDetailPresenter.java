package wang.mogujun.csdnplus.geeknews;

/**
 * Created by WangJun on 2016/8/25.
 */
public class NewsDetailPresenter extends NewsDetailContract.Presenter {


    @Override
    void loadDetail(String username, int articleId, String url, String type) {

    }

    @Override
    void loadComments(String url, int articleId, String type) {

    }

    @Override
    void loadMoreComments(String url, int articleId, String type) {

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
