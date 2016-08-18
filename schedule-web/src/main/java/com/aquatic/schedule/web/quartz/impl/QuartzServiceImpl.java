package com.aquatic.schedule.web.quartz.impl;

import java.util.Date;
import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import com.aquatic.schedule.web.quartz.QuartzService;

/**
 * @className:com.aquatic.schedule.web.quartz.impl.QuartzServiceImpl
 * @description:Quartz动态任务Service实现类
 * @version:v1.0.0
 * @date:2016年8月18日 下午7:48:54
 * @author:WangHao
 */
public class QuartzServiceImpl implements QuartzService
{
	/**
	 * Quartz执行器,通过spring注入
	 */
	private Scheduler scheduler;

	private JobDetail jobDetail;

	public void setJobDetail(JobDetail jobDetail)
	{
		this.jobDetail = jobDetail;
	}

	public void schedule(String triggerName, Date startTime, Date endTime, int repeatCount, long repeatInterval)
	{
		if (triggerName == null || triggerName.trim().equals(""))
		{
			triggerName = UUID.randomUUID().toString().replaceAll("-", "");
		}

		try
		{
			System.out.println("triggerName=" + triggerName + " startTime=" + startTime + " endTime=" + endTime
					+ " repeatCount=" + repeatCount + " repeatInterval=" + repeatInterval);
			SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
					.withIdentity(triggerName).startAt(startTime).endAt(endTime).withSchedule(SimpleScheduleBuilder
							.simpleSchedule().withIntervalInMilliseconds(repeatInterval).withRepeatCount(repeatCount))
					.build();
			// 启动计划任务时可以调用此处传入的参数
			simpleTrigger.getJobDataMap().put("传入参数key", "传入参数值");
			scheduler.scheduleJob(jobDetail, simpleTrigger);

		} catch (SchedulerException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void schedule(String triggerName, String cronExpression)
	{
		if (triggerName == null || triggerName.trim().equals(""))
		{
			triggerName = UUID.randomUUID().toString().replaceAll("-", "");
		}

		try
		{
			System.out.println("triggerName=" + triggerName + " cronExpression=" + cronExpression);
			// 触发器名,触发器组,cron表达式
			CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity(triggerName)
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
			// 启动计划任务时可以调用此处传入的参数
			trigger.getJobDataMap().put("传入参数key", "传入参数值");
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e)
		{
			throw new RuntimeException(e);
		}

	}

	public void removeSchedule(String jobName, String triggerName)
	{
		try
		{
			scheduler.pauseTrigger(new TriggerKey(triggerName));// 停止触发器
			scheduler.unscheduleJob(new TriggerKey(triggerName));// 移除触发器
			scheduler.deleteJob(new JobKey(jobName));// 删除任务
		} catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}

	public Scheduler getScheduler()
	{
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler)
	{
		this.scheduler = scheduler;
	}

	public JobDetail getJobDetail()
	{
		return jobDetail;
	}
	
}
