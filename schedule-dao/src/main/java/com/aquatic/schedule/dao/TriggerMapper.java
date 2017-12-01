package com.aquatic.schedule.dao;

import com.aquatic.schedule.bean.Page;
import com.aquatic.schedule.bean.ReqPageBean;
import com.aquatic.schedule.bean.TriggerBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface TriggerMapper {
    // 分页查询任务trigger
    List<TriggerBean> queryTriggers(ReqPageBean<TriggerBean> reqPageBean);

    // 查询任务trigger-总条数
    long queryCounts(ReqPageBean<TriggerBean> reqPageBean);
}
