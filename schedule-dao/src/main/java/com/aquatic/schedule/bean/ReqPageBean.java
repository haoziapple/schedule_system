package com.aquatic.schedule.bean;

/**
 * @className: com.aquatic.schedule.bean.ReqPageBean
 * @description: 一般分页请求bean
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/30 13:59
 **/
public class ReqPageBean<T> extends ReqBean {
    //    每页条数，默认20
    private int pageSize = Page.DEFAULT_PAGE_SIZE;

    //    页码，默认1
    private int pageNum = 1;

    private int fromNum = (pageNum - 1) * pageSize;

    private int toNum = fromNum + pageSize - 1;

    public ReqPageBean() {
        super();
    }

    public ReqPageBean(T data) {
        super();
        this.setData(data);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "ReqPageBean{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                "} " + super.toString();
    }
}
