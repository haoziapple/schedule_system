package com.aquatic.schedule.service.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.aquatic.schedule.service.http.HttpUtil;

/**
 * @className:com.aquatic.schedule.service.job.PostJob
 * @description:发送Post请求的定时任务
 * @version:v1.0.0
 * @date:2016年8月20日 下午3:16:06
 * @author:WangHao
 */
public class PostJob implements Job
{
	private static final String URLKEY = "url";

	private static final String BODYKEY = "body";

	public PostJob()
	{

	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		JobDataMap data = context.getMergedJobDataMap();
		String url = data.getString(URLKEY);
		String body = data.getString(BODYKEY);
		HttpUtil.post(url, body);
	}

}
