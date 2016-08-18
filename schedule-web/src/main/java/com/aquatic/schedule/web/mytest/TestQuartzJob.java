package com.aquatic.schedule.web.mytest;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @className:com.aquatic.schedule.web.mytest.TestQuartzJob
 * @description:Quartz任务测试
 * @version:v1.0.0
 * @date:2016年8月18日 上午10:21:36
 * @author:WangHao
 */
public class TestQuartzJob extends QuartzJobBean
{

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException
	{
		Trigger trigger = jobexecutioncontext.getTrigger();
		String triggerDesc = trigger.toString();
		System.out.println("MyQuartzJobBean" + triggerDesc);
	}

}
