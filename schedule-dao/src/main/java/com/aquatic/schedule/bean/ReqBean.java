package com.aquatic.schedule.bean;

/**
 * @className: com.aquatic.schedule.bean.ReqBean
 * @description: 一般请求bean
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/30 13:56
 **/
public class ReqBean<T> {
    private T data;

    public ReqBean() {
        super();
    }

    public ReqBean(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReqBean{" +
                "data=" + data +
                '}';
    }
}
