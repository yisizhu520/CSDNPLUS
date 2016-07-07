package wang.mogujun.csdnplus.data.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Type;

import rx.Observable;
import wang.mogujun.csdnplus.data.exception.NetworkConnectionException;
import wang.mogujun.csdnplus.data.exception.ResponseException;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.ext.utils.JsonUtils;

/**
 * Created by WangJun on 2016/6/6.
 */
public class RepositoryUtils {

    private static Gson mGson;


    static {
        mGson = new GsonBuilder().setDateFormat(JsonUtils.DEFAULT_DATE_PATTERN).create();
    }

    public static <T> Observable<T> extractData(Observable<CSDNResponse> observable, Class<T> clazz) {
       return extractData(observable,(Type) clazz);
    }


    public static <T> Observable<T> extractData(Observable<CSDNResponse> observable, Type type) {
        return observable.flatMap(response -> {
            if (response == null) {
                return Observable.error(new NetworkConnectionException());
            } else if (response.getCode() == ResponseException.CODE_SUCCESS) {
                //Logger.json(mGson.toJson(response.getData()));
                return Observable.just(mGson.fromJson(mGson.toJson(response.getData()), type));
            } else {
                Logger.e("response error--code:%s,message:s",response.getCode(),response.getMessage());
                return Observable.error(new ResponseException(response));
            }
        });
    }

}
