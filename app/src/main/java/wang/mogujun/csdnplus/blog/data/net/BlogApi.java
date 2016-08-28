package wang.mogujun.csdnplus.blog.data.net;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;

/**
 * Created by WangJun on 2016/8/29.
 */
public interface BlogApi {

    @GET("api/blog/bole")
    Observable<CSDNResponse> getRecommendBlogList(
            @QueryMap Map<String,String> params
    );
















}
