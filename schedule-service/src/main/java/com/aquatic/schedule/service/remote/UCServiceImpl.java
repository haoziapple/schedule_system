package com.aquatic.schedule.service.remote;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @className:com.aquatic.schedule.service.remote.UCServiceImpl
 * @description:测试http远程调用实现类
 * @version:v1.0.0
 * @date:2016年8月20日 上午11:08:27
 * @author:WangHao
 */
public class UCServiceImpl implements UcService
{
	private static Logger pointrecordlog = LogManager.getLogger("pointrecordlog");
	private static Logger logger = LogManager.getLogger(UCServiceImpl.class);

	public String getUserInfobyName(String userName)
	{
		UserInfo user = new UserInfo();
		user.setEmail("testEmail");
		user.setRegistDate(new Date());
		user.setUserName("testUserName");
		return "hello wang hao";

	}

	public int recordLog(String username, String point, String operate, String desc)
	{
		int result = 0;
		try
		{
			pointrecordlog.info(username + " - " + point + " - " + operate + " - " + desc);
		} catch (Throwable t)
		{
			result = -1;
			logger.error(t);
		}
		return result;
	}
}
