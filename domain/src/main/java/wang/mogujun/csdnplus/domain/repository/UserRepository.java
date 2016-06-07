package wang.mogujun.csdnplus.domain.repository;

import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;

/**
 * Created by WangJun on 2016/6/5.
 */
public interface UserRepository {

    Observable<CSDNResponse> login(String username, String password);


}
