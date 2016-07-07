package wang.mogujun.csdnplus.user.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import wang.mogujun.csdnplus.data.cache.SecurityUtils;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.user.data.net.UserApi;
import wang.mogujun.csdnplus.user.domain.repository.UserRepository;

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

}
