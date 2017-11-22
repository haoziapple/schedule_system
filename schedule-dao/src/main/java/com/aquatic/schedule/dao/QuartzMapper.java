package com.aquatic.schedule.dao;

import java.util.List;
import java.util.Map;

/**
 * @className: com.aquatic.schedule.dao.QuartzMapper
 * @description: quartz数据库Mapper类
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/21 15:36
**/
public interface QuartzMapper {
    int get();

    List<Map<String,String>> queryAllTriggers();

    List<Map<String,String>> queryAllCronTriggers();

    List<Map<String,String>> queryAllJobs();
}
