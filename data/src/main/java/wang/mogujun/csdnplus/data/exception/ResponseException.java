package wang.mogujun.csdnplus.data.exception;

import wang.mogujun.csdnplus.domain.model.CSDNResponse;

public class ResponseException extends Exception {

    public static final int CODE_BAD_REQUEST = 4000;
    public static final int CODE_SUCCESS = 2000;
    public static final int CODE_UNAUTHORIZED = 4001;

    private final int mStatusCode;

    public ResponseException(CSDNResponse response) {
        super(response.getMessage());
        this.mStatusCode = response.getCode();
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

}