package com.aquatic.schedule.web.bussiness.common;

import com.aquatic.schedule.dao.QuartzMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: com.aquatic.schedule.web.bussiness.common.CommonController
 * @description: 通用控制器
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/30 15:51
**/
@RestController
@RequestMapping("/")
public class CommonController {
    @Autowired
    private QuartzMapper quartzMapper;

    private static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "success";
    }

    @RequestMapping(value = "/api/allTriggers", method = {RequestMethod.GET, RequestMethod.POST})
    public List queryAllTriggers()
    {
        return quartzMapper.queryAllTriggers();
    }

    @RequestMapping(value = "/api/allJobs", method = {RequestMethod.GET, RequestMethod.POST})
    public List queryAllJobs() {
        return quartzMapper.queryAllJobs();
    }

    @RequestMapping(value = "/api/allCronTriggers", method = {RequestMethod.GET, RequestMethod.POST})
    public List queryAllCronTriggers()
    {
        return quartzMapper.queryAllCronTriggers();
    }


}
