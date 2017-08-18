package view.po;

import model.VP;
import org.openqa.selenium.By;

public class HomePage  extends VP{
	//Sioeye喜爱直播相机官网
	By logo = By.className("ttbar-login");
	//发现
	By discover = By.className("discover active");
	//关注
	By follow = By.className("follow");
	//消息
	By notifications = By.className("notifications");
	//搜索
	By btn_search = By.className("btn-search");
	//登录
	By btn_login = By.cssSelector("a[class='btn-login avatar']");

	//点击相机官网
	public void clickLogo(){
		clickElement(logo);
	}
	//点击发现
	public void clickDiscover(){
		clickElement(discover);
	}
	//点击关注
	public void clickFollow(){
		clickElement(follow);
	}
	//点击消息
	public void clickNotifacations(){
		clickElement(notifications);
	}
	//点击搜索
	public void clickSearchbtn(){
		clickElement(btn_search);
	}
	//点击登录
	public void clickLoginbtn(){
		clickElement(btn_login);
	}
}
