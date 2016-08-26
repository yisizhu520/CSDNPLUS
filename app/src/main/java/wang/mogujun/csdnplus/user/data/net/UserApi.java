package wang.mogujun.csdnplus.user.data.net;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
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
            @Query("username") String username
    );

    @GET("api/favorite/add_favorite")
    Observable<CSDNResponse> addFavorite(
            @QueryMap Map<String, String> params
    );

    @GET("api/favorite/do_delete_favorite")
    Observable<CSDNResponse> deleteFavorite(
            @QueryMap Map<String, String> params
    );

    @POST("api/user/doFollow")
    @FormUrlEncoded
    Observable<CSDNResponse> doFollow(
            @Field("username") String username,
            @Field("fans") String fans
    );

    @POST("api/user/unFollow")
    @FormUrlEncoded
    Observable<CSDNResponse> unFollow(
            @Field("username") String username,
            @Field("fans") String fans
    );

}
