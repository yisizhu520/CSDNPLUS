package wang.mogujun.csdnplus.blog.data.repository;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import wang.mogujun.csdnplus.blog.data.net.BlogApi;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListReqBean;
import wang.mogujun.csdnplus.blog.domain.repository.BlogRepository;
import wang.mogujun.csdnplus.data.repository.RepositoryUtils;
import wang.mogujun.ext.utils.JsonUtils;

/**
 * Created by WangJun on 2016/8/29.
 */
public class BlogDataRepository implements BlogRepository {

    @Inject
    BlogApi mBlogApi;

    @Inject
    public BlogDataRepository() {
    }

    @Override
    public Observable<List<BlogRecommendListInfo>> getRecommendBlogList(BlogRecommendListReqBean reqBean) {
        return RepositoryUtils.extractData(
                mBlogApi.getRecommendBlogList(JsonUtils.convertBean2Map(reqBean)),
                new TypeToken<List<BlogRecommendListInfo>>() {}.getType()
        );
    }

}
