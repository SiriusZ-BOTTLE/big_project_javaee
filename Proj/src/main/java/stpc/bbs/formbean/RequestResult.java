package stpc.bbs.formbean;

/**
 * web请求返回的结果对象, 通用类
 */
public class RequestResult {

    String msg="None";//返回消息
    Boolean success=false;//是否成功
    Object object=null;//返回对象

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
