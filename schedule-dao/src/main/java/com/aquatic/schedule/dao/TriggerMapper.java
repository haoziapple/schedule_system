package com.aquatic.schedule.dao;

import com.aquatic.schedule.bean.Page;
import com.aquatic.schedule.bean.TriggerBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface TriggerMapper {
    // TODO 验证mybatis是否能获取TriggerBean里的字段值
    List<TriggerBean> queryTriggers(Page<TriggerBean> page);
}
