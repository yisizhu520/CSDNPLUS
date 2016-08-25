package wang.mogujun.csdnplus.user.data.net;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;

/**
 * Created by WangJun on 2016/6/5.
 */
public interface UserApi {

    @FormUrlEncoded
    @POST("v3/login")
    Observable<CSDNResponse> login(@Field("username") String username, @Field("password") String encodePwd);

    @GET("api/user/relation")
    Observable<CSDNResponse> getRelationWith(
            @Query("page") String username
    );




}
