package wang.mogujun.csdnplus.domain.model;


/**
 * 响应结果
 *
 */
public class CSDNResponse {

    private int code;
    private Object data;
    private String message;
    private String sessionExpired;
    private String sessionId;

    public int getCode() {
        return this.code;
    }

    public Object getData() {
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

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public void setSessionExpired(String sessionExpired) {
        this.sessionExpired = sessionExpired;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}