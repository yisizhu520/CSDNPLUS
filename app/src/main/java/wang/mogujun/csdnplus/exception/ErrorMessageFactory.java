package wang.mogujun.csdnplus.exception;

import android.content.Context;

import com.orhanobut.logger.Logger;

import retrofit2.adapter.rxjava.HttpException;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.data.exception.NetworkConnectionException;
import wang.mogujun.csdnplus.data.exception.NotFoundException;
import wang.mogujun.csdnplus.data.exception.ResponseException;
import wang.mogujun.ext.utils.StringUtils;

public class ErrorMessageFactory {
    private static final String TAG = "ErrorMessageFactory";

    private ErrorMessageFactory() {
    }

    public static String create(Context context, Exception exception) {
        if (StringUtils.isNotEmpty(exception.getMessage())) {
            Logger.e(exception.getMessage());
        }
        String message = context.getString(R.string.exception_message_generic);
        if (exception instanceof NetworkConnectionException) {
            return context.getString(R.string.exception_message_no_connection);
        }
        if (exception instanceof NotFoundException) {
            return context.getString(R.string.exception_message_not_found);
        }
        if (exception instanceof ResponseException) {
            return exception.getMessage();
        }
        if (exception instanceof HttpException) {
            return exception.getMessage();
        }
        return message;
    }
}