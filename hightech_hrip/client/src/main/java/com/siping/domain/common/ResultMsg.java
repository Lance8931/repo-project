package com.siping.domain.common;

import java.io.Serializable;

public class ResultMsg implements Serializable {

    private static final long serialVersionUID = -9197926144517133339L;

    /**
     * 处理成功标记
     */
    private boolean success;
    /**
     * 返回的消息
     */
    private String msg;

    public ResultMsg() {
    }

    public ResultMsg(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
