package com.aquatic.schedule.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @className: com.aquatic.schedule.bean.ResultBean
 * @description: 一般返回bean
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/30 14:10
 **/
public class ResultBean<T> implements Serializable {
    public static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;

    private int code = SUCCESS;

    private String msg = "success";

    private String id;

    private String errTrace = "";

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
        this.errTrace = Arrays.asList(e.getStackTrace()).toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrTrace() {
        return errTrace;
    }

    public void setErrTrace(String errTrace) {
        this.errTrace = errTrace;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
