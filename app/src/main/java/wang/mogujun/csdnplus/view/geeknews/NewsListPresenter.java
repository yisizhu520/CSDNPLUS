package wang.mogujun.csdnplus.view.geeknews;

import java.util.List;

import javax.inject.Inject;

import wang.mogujun.csdnplus.domain.interactor.geeknews.GetColumnNewsUseCase;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.csdnplus.view.CSDNSubscriber;
import wang.mogujun.ext.utils.CollectionUtils;

/**
 * Created by WangJun on 2016/7/3.
 */
public class NewsListPresenter extends NewsListContract.Presenter {


    private int mPageIndex = 1;

    private int mComid;

    @Inject
    GetColumnNewsUseCase mGetColumnNewsUseCase;

    public NewsListPresenter(int comid){
        mComid = comid;
    }

    @Override
    public void loadNewData() {
        getView().showLoading();
        getView().hideEmptyView();
        mGetColumnNewsUseCase.setPage(1).setComid(mComid);
        mGetColumnNewsUseCase.execute(new CSDNSubscriber<List<NewsListInfo>>(){

            @Override
            public void onCompleted() {
                super.onCompleted();
                getView().hideLoading();
            }

            @Override
            public void onNext(List<NewsListInfo> newsListInfos) {
                super.onNext(newsListInfos);
                if(CollectionUtils.isEmpty(newsListInfos)){
                    getView().showEmptyView();
                }else{
                    //TODO 将新数据缓存到本地数据库,应该在repository层里做
                    getView().showNewData(newsListInfos);
                }
            }

            @Override
            protected void onErrorMsg(String errorMsg) {
                super.onErrorMsg(errorMsg);
                getView().hideLoading();
                getView().showNewDataError(errorMsg);
            }
        });
    }

    @Override
    public void loadMoreData() {
        mGetColumnNewsUseCase.setPage(mPageIndex+1).setComid(mComid);
        mGetColumnNewsUseCase.execute(new CSDNSubscriber<List<NewsListInfo>>(){

            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onNext(List<NewsListInfo> newsListInfos) {
                super.onNext(newsListInfos);
                if(CollectionUtils.isEmpty(newsListInfos)){
                    getView().showNoMoreData();
                }else{
                    //TODO 将新数据缓存到本地数据库,应该在repository层里做
                    getView().showMoreData(newsListInfos);
                    mPageIndex++;
                }
            }

            @Override
            protected void onErrorMsg(String errorMsg) {
                super.onErrorMsg(errorMsg);
                getView().showMoreDataError(errorMsg);
            }
        });
    }

}
