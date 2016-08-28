package wang.mogujun.csdnplus.blog.domain.repository;

import java.util.List;

import rx.Observable;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListReqBean;

/**
 * Created by WangJun on 2016/8/29.
 */
public interface BlogRepository {

    Observable<List<BlogRecommendListInfo>> getRecommendBlogList(BlogRecommendListReqBean reqBean);

}
