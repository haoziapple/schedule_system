package com.aquatic.schedule.service.remote;

/**
 * @className:com.aquatic.schedule.service.remote.UcService
 * @description:测试http调用接口类
 * @version:v1.0.0
 * @date:2016年8月20日 上午11:07:26
 * @author:WangHao
 */
public interface UcService
{
	public String getUserInfobyName(String userName);

	public int recordLog(String username, String point, String operate, String desc);
}
