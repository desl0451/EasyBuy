package cn.easybuy.utils;

public class ReturnResult {
    private int status;
    private Object data;
    private String message = "操作成功";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回成功
     */
    public ReturnResult returnSuccess(Object obj) {
        this.status = 1;
        this.data = obj;
        return this;
    }

    /**
     * 返回失败
     */
    public ReturnResult returnFail(String message) {
        this.status=0;
        this.message=message;
        return this;
    }
}
