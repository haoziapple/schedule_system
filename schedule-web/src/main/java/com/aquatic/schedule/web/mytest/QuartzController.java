package com.aquatic.schedule.web.mytest;

import com.aquatic.schedule.dao.QuartzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @className: com.aquatic.schedule.web.mytest.QuartzController
 * @description: quartz定时器Controller
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/21 15:22
 **/
@RestController
@RequestMapping("/")
public class QuartzController {

    @Autowired
    private QuartzMapper quartzMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "success";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return Integer.toString(quartzMapper.get());
    }

    @RequestMapping(value = "/allTriggers", method = RequestMethod.GET)
    public List queryAllTriggers()
    {
        return quartzMapper.queryAllTriggers();
    }

    @RequestMapping(value = "/allCron", method = RequestMethod.GET)
    public List queryAllCronTriggers()
    {
        return quartzMapper.queryAllCronTriggers();
    }

    @RequestMapping(value = "/allJobs", method = RequestMethod.GET)
    public List queryAllJobs()
    {
        return quartzMapper.queryAllJobs();
    }
}
