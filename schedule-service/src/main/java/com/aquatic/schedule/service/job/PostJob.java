package com.aquatic.schedule.service.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
    public static final String URLKEY = "url";

    public static final String BODYKEY = "body";

    public PostJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getMergedJobDataMap();
        String url = data.getString(URLKEY);
        String body = data.getString(BODYKEY);
        log.debug("post request, url: {}, body: {}", url, body);
        Map<String, String> resultMap = HttpUtil.post(url, body);
        log.debug("post response: {}", resultMap);
    }

}
