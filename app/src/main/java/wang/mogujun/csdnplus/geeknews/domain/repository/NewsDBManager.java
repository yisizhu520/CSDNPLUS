package wang.mogujun.csdnplus.geeknews.domain.repository;

import java.util.List;

import io.realm.Realm;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsListInfo;

/**
 * Created by WangJun on 2016/7/7.
 */
public class NewsDBManager {

    void addNews(List<NewsListInfo> data){
        Realm realm = Realm.getDefaultInstance();
        realm.copyToRealmOrUpdate(data);
        realm.close();
    }


}
