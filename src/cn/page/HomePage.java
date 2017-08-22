package cn.page;

import model.VP;
import org.openqa.selenium.By;
//https://live.sioeye.cn/watch
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

	
	/** 
	* @Title: clickLogo 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击相机官网
	* @return void    返回类型 
	*/
	public static void clickLogo(){
		clickElement(logo);
	}
	
	/** 
	* @Title: clickDiscover 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击发现 
	* @return void    返回类型 
	*/
	public static void clickDiscover(){
		clickElement(discover);
	}
	
	/** 
	* @Title: clickFollow 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击关注
	* @return void    返回类型 
	*/
	public static void clickFollow(){
		clickElement(follow);
	}
	
	/** 
	* @Title: clickNotifacations 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击消息   
	* @return void    返回类型 
	*/
	public static void clickNotifacations(){
		clickElement(notifications);
	}
	
	/** 
	* @Title: clickSearchbtn 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击搜索
	* @return void    返回类型 
	*/
	public static void clickSearchbtn(){
		clickElement(btn_search);
	}
	
	/** 
	* @Title: clickLoginbtn 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击登录    
	* @return void    返回类型 
	*/
	public static void clickLoginbtn(){
		clickElement(btn_login);
	}
	
	
}
