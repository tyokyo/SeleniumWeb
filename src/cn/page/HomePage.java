package cn.page;

import model.VP;
import org.openqa.selenium.By;

public class HomePage  extends VP{
	//Sioeye喜爱直播相机官网
	static By logo = By.className("ttbar-login");
	//发现
	static By discover = By.className("discover active");
	//关注
	static By follow = By.className("follow");
	//消息
	static By notifications = By.className("notifications");
	//搜索
	static By btn_search = By.className("btn-search");
	//登录
	static By btn_login = By.cssSelector("a[class='btn-login avatar']");

	//点击相机官网
	public static void clickLogo(){
		clickElement(logo);
	}
	//点击发现
	public static void clickDiscover(){
		clickElement(discover);
	}
	//点击关注
	public static void clickFollow(){
		clickElement(follow);
	}
	//点击消息
	public static void clickNotifacations(){
		clickElement(notifications);
	}
	//点击搜索
	public static void clickSearchbtn(){
		clickElement(btn_search);
	}
	//点击登录
	public static void clickLoginbtn(){
		clickElement(btn_login);
	}
}
