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

    @GET("api/v2/geek/detail")
    Observable<CSDNResponse> getHeadlineDetail(
            @Query("id") int id
    );

    @GET("api/geek/community_detail")
    Observable<CSDNResponse> getCommunityDetail(
            @Query("childcommunityid") String childcommunityid
    );

    @GET("api/index/news_newest_comment")
    Observable<CSDNResponse> getCommentList(
            @Query("url") String url,
            @Query("pageno") int pageno,
            @Query("pagesize") int pagesize
    );

    @GET("api/index/news_newest_comment")
    Observable<CSDNResponse> doDetailUpDown(
            @Query("article_id") int article_id,
            @Query("status") int status
    );



}
