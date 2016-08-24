package wang.mogujun.csdnplus.geeknews.domain.model;

import java.io.Serializable;

/**
 * 响应结果
 * @param <T>
 */
public class ResponseResultBean<T>
        implements Serializable {
    public static final int CODE_BAD_REQUEST = 4000;
    public static final int CODE_SUCCESS = 2000;
    public static final int CODE_UNAUTHORIZED = 4001;
    private static final long serialVersionUID = 1L;
    public int code;
    public T data;
    public String message;
    public String sessionExpired;
    public String sessionId;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getSessionExpired() {
        return this.sessionExpired;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setData(T paramT) {
        this.data = paramT;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setSessionExpired(String paramString) {
        this.sessionExpired = paramString;
    }

    public void setSessionId(String paramString) {
        this.sessionId = paramString;
    }
}