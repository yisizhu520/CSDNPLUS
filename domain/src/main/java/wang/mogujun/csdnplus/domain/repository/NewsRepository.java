package wang.mogujun.csdnplus.domain.repository;

import java.util.List;

import rx.Observable;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;

/**
 * Created by WangJun on 2016/6/25.
 */
public interface NewsRepository {

    Observable<List<NewsColumn>> getNewsColumns();

    Observable<List<NewsListInfo>> getLatestNews(String lastId,String direction,int size,int activities_count);

    Observable<List<NewsListInfo>> getColumnNews(int page, int comid);


}
