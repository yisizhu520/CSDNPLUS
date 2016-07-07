package wang.mogujun.csdnplus.geeknews.data.net;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;

/**
 * Created by WangJun on 2016/6/25.
 */
public interface NewsApi {

    @GET("api/geek/all_community")
    Observable<CSDNResponse> getNewsColumns();

    @GET("api/v2/index/latest_news")
    Observable<CSDNResponse> getLatestNews(
            @Query("lastId") String lastId,
            @Query("direction") String direction,
            @Query("size") int size,
            @Query("activities_count") int activities_count
    );

    @GET("api/geek/comms_with_id")
    Observable<CSDNResponse> getColumnNews(
            @Query("page") int page,
            @Query("comid") int comid
    );


}
