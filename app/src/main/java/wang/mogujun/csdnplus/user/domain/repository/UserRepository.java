package wang.mogujun.csdnplus.user.domain.repository;

import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.geeknews.domain.model.UserRelationBean;

/**
 * Created by WangJun on 2016/6/5.
 */
public interface UserRepository {

    Observable<CSDNResponse> login(String username, String password);

    Observable<UserRelationBean> getRelationWith(String username);



}
