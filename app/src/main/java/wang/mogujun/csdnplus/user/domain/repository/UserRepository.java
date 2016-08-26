package wang.mogujun.csdnplus.user.domain.repository;

import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.FavoriteOperationReqBean;
import wang.mogujun.csdnplus.geeknews.domain.model.FollowOperationInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.UserRelationBean;

/**
 * Created by WangJun on 2016/6/5.
 */
public interface UserRepository {

    Observable<CSDNResponse> login(String username, String password);

    Observable<UserRelationBean> getRelationWith(String username);

    Observable<FavoriteOperationInfo> addFavorite(FavoriteOperationReqBean reqBean);

    Observable<FavoriteOperationInfo> deleteFavorite(FavoriteOperationReqBean reqBean);

    Observable<FollowOperationInfo> doFollow(String username, String fans);

    Observable<FollowOperationInfo> unFollow(String username, String fans);

}
