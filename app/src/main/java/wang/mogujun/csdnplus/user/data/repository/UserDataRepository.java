package wang.mogujun.csdnplus.user.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import wang.mogujun.csdnplus.data.cache.SecurityUtils;
import wang.mogujun.csdnplus.data.repository.RepositoryUtils;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationReqBean;
import wang.mogujun.csdnplus.geeknews.domain.model.FollowOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.UserRelationBean;
import wang.mogujun.csdnplus.user.data.net.UserApi;
import wang.mogujun.csdnplus.user.domain.repository.UserRepository;
import wang.mogujun.ext.utils.JsonUtils;

/**
 * Created by WangJun on 2016/6/6.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    @Inject
    protected UserApi mUserApi;

    @Inject
    public UserDataRepository(){}

    @Override
    public Observable<CSDNResponse> login(String username, String password) {
        String encodePwd = SecurityUtils.DESEncrypt(password);
        return mUserApi.login(username,encodePwd);
    }

    @Override
    public Observable<UserRelationBean> getRelationWith(String username) {
        return RepositoryUtils.extractData(mUserApi.getRelationWith(username),UserRelationBean.class);
    }

    @Override
    public Observable<FavoriteOperationInfo> addFavorite(FavoriteOperationReqBean reqBean) {
        return RepositoryUtils.extractData(
                mUserApi.addFavorite(JsonUtils.convertBean2Map(reqBean)), FavoriteOperationInfo.class
        );
    }

    @Override
    public Observable<FavoriteOperationInfo> deleteFavorite(FavoriteOperationReqBean reqBean) {
        return RepositoryUtils.extractData(
                mUserApi.deleteFavorite(JsonUtils.convertBean2Map(reqBean)), FavoriteOperationInfo.class
        );
    }

    @Override
    public Observable<FollowOperationInfo> doFollow(String username, String fans) {
        return RepositoryUtils.extractData(
                mUserApi.doFollow(username,fans), FollowOperationInfo.class
        );
    }

    @Override
    public Observable<FollowOperationInfo> unFollow(String username, String fans) {
        return RepositoryUtils.extractData(
                mUserApi.unFollow(username,fans), FollowOperationInfo.class
        );
    }


}
