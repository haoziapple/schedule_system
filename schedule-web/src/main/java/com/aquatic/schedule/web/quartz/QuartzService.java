package com.aquatic.schedule.web.quartz;

import java.util.Date;

import org.quartz.JobDetail;

/**
 * @className:com.aquatic.schedule.web.quartz.QuartzService
 * @description:Quart动态任务Service接口类
 * @version:v1.0.0
 * @date:2016年8月18日 上午11:27:21
 * @author:WangHao
 */
public interface QuartzService
{

	/**
	 * @Description:设定任务
	 * @param jobDetail
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016年8月18日 下午7:50:16
	 */
	public void setJobDetail(JobDetail jobDetail);

	/**
	 * 在startTime时执行调试，endTime结束执行调度，重复执行repeatCount次，每隔repeatInterval毫秒执行一次
	 * 
	 * @param triggerName
	 *            Quartz SimpleTrigger 名称
	 * @param startTime
	 *            调度开始时间
	 * @param endTime
	 *            调度结束时间
	 * @param repeatCount
	 *            重复执行次数
	 * @param repeatInterval
	 *            执行时间隔间
	 */
	void schedule(String triggerName, Date startTime, Date endTime, int repeatCount, long repeatInterval);

	/**
	 * @Description:根据cron表达式新建任务
	 * @param triggerName
	 * @param cronExpression
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016年8月18日 下午5:37:36
	 */
	void schedule(String triggerName, String cronExpression);

	/**
	 * 移除定时任务
	 * 
	 * @param name
	 *            Quartz SimpleTrigger 名称
	 */
	void removeSchedule(String jobName, String triggerName);
}
