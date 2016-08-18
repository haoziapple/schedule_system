package com.aquatic.schedule.web.mytest;

import java.text.ParseException;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import com.aquatic.schedule.web.quartz.QuartzService;

/**
 * @className:com.aquatic.schedule.web.mytest.TestDynamicQuartz
 * @description:动态Quartz测试
 * @version:v1.0.0
 * @date:2016年8月18日 下午4:07:42
 * @author:WangHao
 */
public class TestDynamicQuartz
{
	private static SchedulerFactory sf = new StdSchedulerFactory();
	private static String JOB_GROUP_NAME = "ddlib";
	private static String TRIGGER_GROUP_NAME = "ddlibTrigger";

	/** 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名 */
	public static void addJob(String jobName, Job job, String cronExpression) throws SchedulerException, ParseException
	{
		addJob(jobName, null, jobName, null, job, cronExpression);
	}

	/**
	 * 添加一个定时任务
	 * 
	 * @param jobName
	 *            任务名
	 * @param jobGroupName
	 *            任务组名
	 * @param triggerName
	 *            触发器名
	 * @param triggerGroupName
	 *            触发器组名
	 * @param job
	 *            任务
	 * @param cronExpression
	 *            时间设置，参考quartz说明文档
	 */
	public static void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Job job,
			String cronExpression) throws SchedulerException, ParseException
	{
		if (StringUtils.isEmpty(jobGroupName))
		{
			jobGroupName = JOB_GROUP_NAME;
		}
		if (StringUtils.isEmpty(triggerGroupName))
		{
			triggerGroupName = TRIGGER_GROUP_NAME;
		}
		Scheduler sched = sf.getScheduler();
		// 任务名，任务组，任务执行类
		JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobName, jobGroupName).build();
		// 触发器名,触发器组,cron表达式
		CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
		sched.scheduleJob(jobDetail, trigger);
		// 启动
		if (!sched.isShutdown())
		{
			sched.start();
		}
	}

	/** 移除一个任务和触发器(使用默认的任务组名，触发器名，触发器组名) */
	public static void removeJob(String jobName, String triggerName) throws SchedulerException
	{
		removeJob(jobName, null, triggerName, null);
	}

	/** 移除一个任务和触发器 */
	public static void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName)
			throws SchedulerException
	{
		if (StringUtils.isEmpty(jobGroupName))
		{
			jobGroupName = JOB_GROUP_NAME;
		}
		if (StringUtils.isEmpty(triggerGroupName))
		{
			triggerGroupName = TRIGGER_GROUP_NAME;
		}
		Scheduler sched = sf.getScheduler();
		sched.pauseTrigger(new TriggerKey(triggerName, triggerGroupName));// 停止触发器
		sched.unscheduleJob(new TriggerKey(triggerName, triggerGroupName));// 移除触发器
		sched.deleteJob(new JobKey(jobName, jobGroupName));// 删除任务
	}

	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:dispatcher-servlet.xml", "classpath:mybatis.xml",
						"classpath:quartzContext.xml", "classpath:dynamicQuartz.xml" });
		JobDetail jobDetail2 = context.getBean("jobDetail", JobDetail.class);
		QuartzService quartzService = context.getBean("quartzService", QuartzService.class);
		quartzService.removeSchedule(jobDetail2.getKey().getName(), "st01SimpleTrigger");
		quartzService.setJobDetail(jobDetail2);
		quartzService.schedule("testTriggerName", "0/1 * * ? * * *");
	}
}
