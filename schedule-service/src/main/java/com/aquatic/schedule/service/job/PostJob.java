package com.aquatic.schedule.service.job;

import com.aquatic.schedule.service.SpringContextUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;

import com.aquatic.schedule.service.http.HttpUtil;

import java.util.Map;

import static com.aquatic.schedule.service.http.HttpUtil.post;

/**
 * @className:com.aquatic.schedule.service.job.PostJob
 * @description:发送Post请求的定时任务
 * @version:v1.0.0
 * @date:2016年8月20日 下午3:16:06
 * @author:WangHao
 */
public class PostJob implements Job {
    private static final Logger log = LogManager.getLogger(PostJob.class);

    // 请求url
    public static final String URLKEY = "url";

    // 请求体
    public static final String BODYKEY = "body";

    // 是否只请求一次
    public static final String ONCEKEY = "once";

    public PostJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getMergedJobDataMap();
        String url = data.getString(URLKEY);
        String body = data.getString(BODYKEY);
        String once = data.getString(ONCEKEY);
        log.debug("post request, url: {}, body: {}", url, body);
        Map<String, String> resultMap = HttpUtil.post(url, body);
        log.debug("post response: {}", resultMap);

        // 只执行一次，并且执行成功，自动删除任务
        if ("true".equals(once) && "200".equals(resultMap.get(HttpUtil.STATUS))) {
            try {
                context.getScheduler().pauseTrigger(context.getTrigger().getKey());
                context.getScheduler().unscheduleJob(context.getTrigger().getKey());
                context.getScheduler().deleteJob(context.getJobDetail().getKey());
            } catch (SchedulerException e) {
                log.error("移除任务异常", e);
            }
        }
    }

}
