package cn.zsxmlv.common.exception;

/**
 * @author: zs
 * @description: 自定义异常
 * @date: 2019/1/17 16:26
 */
public class RRException extends RuntimeException {

    private String msg;
    private Integer code = 500;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, Integer code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(Throwable cause, String msg, Integer code) {
        super(cause);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
