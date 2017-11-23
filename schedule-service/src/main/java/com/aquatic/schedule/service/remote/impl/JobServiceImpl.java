package com.aquatic.schedule.service.remote.impl;

import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquatic.schedule.service.job.PostJob;
import com.aquatic.schedule.service.quartz.QuartzService;
import com.aquatic.schedule.service.remote.JobService;

/**
 * @className:com.aquatic.schedule.service.remote.impl.JobServiceImpl
 * @description:远程调用的JobService实现类
 * @version:v1.0.0
 * @date:2016年8月20日 下午3:49:13
 * @author:WangHao
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    private static final Logger log = LogManager.getLogger(JobServiceImpl.class);

    @Autowired
    private QuartzService quartzService;

    @Override
    public int addSimpleJob(String jobName, String groupName, String triggerName, Map<String, String> map,
                            Date startTime, Date endTime, int repeatCount, long repeatInterval) {
        JobDetail job = JobBuilder.newJob(PostJob.class).usingJobData(new JobDataMap(map))
                .withIdentity(jobName, groupName).build();
        try {
            if (log.isInfoEnabled())
                log.info("addSimpleJob, triggerName:{}, startTime:{}, endTime:{}, repeatCount:{}, repeatInterval:{}, jobMap:{}", triggerName, startTime, endTime, repeatCount, repeatInterval, map);
            quartzService.schedule(triggerName, startTime, endTime, repeatCount, repeatInterval, job);
        } catch (Exception e) {
            log.error("添加简单定时任务异常", e);
            return -1;
        }
        return 0;
    }

    @Override
    public int addCronJob(String jobName, String groupName, String triggerName, Map<String, String> map,
                          String cronExpression) {
        JobDetail job = JobBuilder.newJob(PostJob.class).usingJobData(new JobDataMap(map))
                .withIdentity(jobName, groupName).build();
        try {
            if (log.isInfoEnabled())
                log.info("addCronJob, triggerName:{}, cronExpression:{}, jobMap:{}", triggerName, cronExpression, map);
            quartzService.schedule(triggerName, cronExpression, job);
        } catch (Exception e) {
            log.error("添加cron定时任务异常", e);
            return -1;
        }
        return 0;
    }

    @Override
    public int removeJob(String jobName, String triggerName) {
        try {
            if (log.isInfoEnabled())
                log.info("removeJob, jobName:{}, triggerName:{}", jobName, triggerName);
            quartzService.removeSchedule(jobName, triggerName);
        } catch (Exception e) {
            log.error("删除定时任务异常", e);
            return -1;
        }
        return 0;
    }
}
