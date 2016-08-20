package com.aquatic.schedule.service.remote;

import java.util.Date;
import java.util.Map;

/**
 * @className:com.aquatic.schedule.service.remote.JobService
 * @description:quartz任务Service接口，供远程调用
 * @version:v1.0.0
 * @date:2016年8月20日 下午3:34:04
 * @author:WangHao
 */
public interface JobService
{

	/**
	 * @Description:添加定时任务
	 * @param map(url-请求地址；body-请求体)
	 * @param startTime
	 *            调度开始时间
	 * @param endTime
	 *            调度结束时间
	 * @param repeatCount
	 *            重复执行次数
	 * @param repeatInterval
	 *            执行时间隔间 毫秒
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016年8月20日 下午3:38:17
	 */
	int addSimpleJob(String jobName, String groupName, String triggerName, Map<String, String> map, Date startTime,
			Date endTime, int repeatCount, long repeatInterval);

	/**
	 * @Description:添加cron表达式的定时任务
	 * @param map
	 * @param cronExpression
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016年8月20日 下午3:40:57
	 */
	int addCronJob(String jobName, String groupName, String triggerName, Map<String, String> map,
			String cronExpression);

	/**
	 * @Description:删除定时任务
	 * @param jobName
	 * @param triggerName
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016年8月20日 下午3:47:52
	 */
	int removeJob(String jobName, String triggerName);
}
