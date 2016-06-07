package wang.mogujun.csdnplus.data.net.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;

/**
 * Created by WangJun on 2016/6/5.
 */
public interface UserApi {

    @FormUrlEncoded
    @POST("v3/login")
    Observable<CSDNResponse> login(@Field("username") String username, @Field("password") String encodePwd);



}
