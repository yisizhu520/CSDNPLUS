package wang.mogujun.csdnplus.view.geeknews;

import java.util.List;

import javax.inject.Inject;

import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.domain.interactor.geeknews.GetLatestNewsUseCase;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;
import wang.mogujun.csdnplus.view.CSDNSubscriber;
import wang.mogujun.ext.utils.CollectionUtils;


/**
 * Created by WangJun on 2016/6/26.
 */
public class NewsLatestPresenter extends NewsLatestListContract.Presenter {

    @Inject
    GetLatestNewsUseCase mGetLatestNewsUseCase;

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
        mGetLatestNewsUseCase.execute(new CSDNSubscriber<List<NewsLatestListInfo>>(){

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
            public void onNext(List<NewsLatestListInfo> newsLatestListInfos) {
                super.onNext(newsLatestListInfos);
                if(CollectionUtils.isEmpty(newsLatestListInfos)){
                    getView().showEmptyView();
                }else{
                    //TODO 将新数据缓存到本地数据库,应该在repository层里做
                    getView().showNewData(newsLatestListInfos);
                }


            }
        });
    }

    @Override
    public void loadMoreData(String lastId) {
        mGetLatestNewsUseCase
                .setLastId(lastId)
                .setDirection(DomainConstants.DIRECTION_UP)
                .setActivities_count(0);
        mGetLatestNewsUseCase.execute(new CSDNSubscriber<List<NewsLatestListInfo>>(){

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
            public void onNext(List<NewsLatestListInfo> newsLatestListInfos) {
                super.onNext(newsLatestListInfos);
                if(CollectionUtils.isEmpty(newsLatestListInfos)){
                    getView().showNoMoreData();
                }else{
                    //TODO 将新数据缓存到本地数据库,应该在repository层里做
                    getView().showMoreData(newsLatestListInfos);
                }


            }
        });
    }
}
