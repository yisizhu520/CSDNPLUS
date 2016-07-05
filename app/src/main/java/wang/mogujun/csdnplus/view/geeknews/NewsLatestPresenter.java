package wang.mogujun.csdnplus.view.geeknews;

import java.util.List;

import javax.inject.Inject;

import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.domain.interactor.geeknews.GetLatestNewsUseCase;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.csdnplus.view.CSDNSubscriber;
import wang.mogujun.ext.utils.CollectionUtils;


/**
 * Created by WangJun on 2016/6/26.
 */
public class NewsLatestPresenter extends NewsListContract.Presenter {

    @Inject
    GetLatestNewsUseCase mGetLatestNewsUseCase;

    private String mLastId;

    @Inject
    public NewsLatestPresenter(){
        CSDNApplication.getInstance().getNewsComponent().inject(this);
    }

    @Override
    public void loadNewData() {
        getView().showLoading();
        getView().hideEmptyView();
        mGetLatestNewsUseCase
                .setLastId("-")
                .setDirection(DomainConstants.DIRECTION_DOWN)
                .setActivities_count(0);
        mGetLatestNewsUseCase.execute(new CSDNSubscriber<List<NewsListInfo>>(){

            @Override
            protected void onErrorMsg(String errorMsg) {
                super.onErrorMsg(errorMsg);
                getView().hideLoading();
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                getView().hideLoading();
            }

            @Override
            public void onNext(List<NewsListInfo> newsLatestListInfos) {
                super.onNext(newsLatestListInfos);
                if(CollectionUtils.isEmpty(newsLatestListInfos)){
                    getView().showEmptyView();
                }else{
                    //TODO 将新数据缓存到本地数据库,应该在repository层里做
                    getView().showNewData(newsLatestListInfos);
                    mLastId = newsLatestListInfos.get(newsLatestListInfos.size()-1).get_id();
                }


            }
        });
    }

    @Override
    public void loadMoreData() {
        mGetLatestNewsUseCase
                .setLastId(mLastId)
                .setDirection(DomainConstants.DIRECTION_UP)
                .setActivities_count(0);
        mGetLatestNewsUseCase.execute(new CSDNSubscriber<List<NewsListInfo>>(){

            @Override
            protected void onErrorMsg(String errorMsg) {
                super.onErrorMsg(errorMsg);
                getView().showMoreDataError(errorMsg);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onNext(List<NewsListInfo> newsLatestListInfos) {
                super.onNext(newsLatestListInfos);
                if(CollectionUtils.isEmpty(newsLatestListInfos)){
                    getView().showNoMoreData();
                }else{
                    //TODO 将新数据缓存到本地数据库,应该在repository层里做
                    getView().showMoreData(newsLatestListInfos);
                    mLastId = newsLatestListInfos.get(newsLatestListInfos.size()-1).get_id();
                }


            }
        });
    }
}
