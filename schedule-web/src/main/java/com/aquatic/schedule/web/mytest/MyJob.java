package com.aquatic.schedule.web.mytest;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @className:com.aquatic.schedule.web.mytest.MyJob
 * @description:自定义Quartz任务
 * @version:v1.0.0
 * @date:2016年8月19日 下午4:05:58
 * @author:WangHao
 */
public class MyJob implements Job
{
	public MyJob()
	{
		// Instances of Job must have a public no-argument constructor.
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		JobDataMap data = context.getMergedJobDataMap();
		System.out.println("key1 = " + data.getString("key1"));
		System.out.println("key2 = " + data.getString("key2"));
	}

}
