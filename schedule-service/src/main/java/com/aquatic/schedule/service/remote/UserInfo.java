package com.aquatic.schedule.service.remote;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable
{
	private static final long serialVersionUID = -6970967506712260305L;
	/** 用户名 */
	private String userName;
	/** 电子邮箱 */
	private String email;
	/** 注册日期 */
	private Date registDate;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getRegistDate()
	{
		return registDate;
	}

	public void setRegistDate(Date registDate)
	{
		this.registDate = registDate;
	}
}
