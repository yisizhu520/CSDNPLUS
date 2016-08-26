package wang.mogujun.csdnplus.geeknews.data.net;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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

    @GET("api/index/{url_type}")
    Observable<CSDNResponse> doDetailUpDown(
            @Path("url_type") String url_type,
            @Query("article_id") int article_id,
            @Query("status") int status
    );

    @GET("api/index/news_comment_up")
    Observable<CSDNResponse> doCommentUp(
            @Query("username") String username,
            @Query("id") String commentId
    );

    @GET("api/index/news_comment_down")
    Observable<CSDNResponse> doCommentDown(
            @Query("username") String username,
            @Query("id") String commentId
    );

    @POST("api/index/news_add_comment")
    @FormUrlEncoded
    Observable<CSDNResponse> addComment(
            @Body Map<String, String> params
    );





}
