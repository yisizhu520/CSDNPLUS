package wang.mogujun.csdnplus.data.net.api;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import rx.Observable;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;

/**
 * Created by WangJun on 2016/6/25.
 */
public interface NewsApi {

    @FormUrlEncoded
    @GET("api/geek/all_community")
    Observable<List<NewsColumn>> getNewsColumns();

    @FormUrlEncoded
    @GET("api/v2/index/latest_news")
    Observable<List<NewsLatestListInfo>> getLatestNews(
            @Field("lastId") String lastId,
            @Field("direction") String direction,
            @Field("size") String size,
            @Field("activities_count") int activities_count
            );

    @FormUrlEncoded
    @GET("api/geek/comms_with_id")
    Observable<List<NewsListInfo>> getColumnNews(
            @Field("page") int page,
            @Field("comid") int comid
    );


}
