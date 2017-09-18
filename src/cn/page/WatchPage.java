package cn.page;

import org.openqa.selenium.By;

import model.VP;

/**
 * 
 * @ClassName: WatchPage 
 * @Description: https://live.sioeye.cn/watch
 * @author jianbin.zhong
 * @date 2017年9月3日 下午2:51:43 
 *
 */
public class WatchPage extends VP{
	
	//Sioeye喜爱直播相机官网
	private static By logo = By.className("logo");
	//发现(home page页面discover的classname为discover active)
	private static By discover = By.className("discover");
	//关注
	private static By follow = By.className("follow");
	//消息
	private static By notifications = By.className("notifications");
	//搜索
	private static By search = By.id("header-search-btn");
	
	//avatar登录头像
	private static By loginBtn = By.cssSelector("html body header.wrap.box-shadow-gray div.nav.clearfix div.nav-right a.btn-login.avatar.log-on img");
	private static By loginSelfPage = By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");
	private static By loginSetting = By.xpath("/html/body/header/div/div[2]/ul/li[2]/a");
	private static By loginLogOut = By.xpath("/html/body/header/div/div[2]/ul/li[3]/a");
	
	//用户个人信息User
	private static By userAvatar = By.xpath("/html/body/div[2]/div/div[1]/div[1]/div[1]/a/img");
	private static By userNickname = By.className("ellipsis");
	private static By userVipIcon = By.className("vip");
	private static By userSioeyeIDIcon = By.xpath("/html/body/div[2]/div/div[1]/div[1]/p/span[1]");
	private static By userSioeyeIDValue = By.xpath("/html/body/div[2]/div/div[1]/div[1]/p/span[2]");
	private static By userBroadcastBtn = By.className("video");
	private static By userBroadcastValue = By.className("video-count");
	private static By userFollowBtn = By.className("follow");
	private static By userFollowValue = By.className("follow-count");
	private static By userFansBtn = By.className("fans");
	private static By userFansValue = By.className("fans-count");
	//用户个人信息User,直播达人
	private static By userCameraBtn = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[1]/a/svg/use");
	private static By userDaRenTxt = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[1]/span");
	private static By userZanIcon = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/svg/use");
	private static By userZanValue = By.className("like-count");
	private static By userLocationIcon = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[1]/svg");
	private static By userLocationValue = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[1]/span");
	private static By userHobbyIcon = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/svg/use");
	private static By userHobbyValue = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/span");
	private static By userCityIcon = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/svg");
	private static By userCityValue = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/span");
	
	//推荐达人 rec for recommend 
	static By recTitle = By.className("title");
	static By recRefreshIcon = By.xpath("/html/body/div[2]/div/div[1]/div[3]/div[1]/div/svg");
	static By recRefreshText = By.xpath("/html/body/div[2]/div/div[1]/div[3]/div[1]/div/span");
	static By recRefreshButton = By.className("refresh");
	//推荐达人内容可能需要遍历写，不能写固定(未完)
	
	//video内容（未完）
	

	
	/**
	 * 
	 * @Method: clickLogo 
	 * @param: 
	 * @Description: 点击官网logo
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public static void clickLogo(){
		clickElement(logo);
	}
	
	/**
	 * 
	 * @Method: clickDiscover 
	 * @param: 
	 * @Description: 点击发现
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public static void clickDiscover(){
		clickElement(discover);
	}
	
	/**
	 * 
	 * @Method: getDiscoveryBtnText 
	 * @param: @return
	 * @Description: 获取discovery button的文本
	 * @return: String
	 * @author: jianbin.zhong
	 */
	public static String getDiscoveryBtnText(){
		return getElement(discover).getText();
	}
	
	/**
	 * 
	 * @Method: clickWatch 
	 * @param: 
	 * @Description: 点击关注（watch）
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickWatch(){
		getElement(follow).click();
	}
	
	/**
	 * 
	 * @Method: getFollowBtnText 
	 * @param: @return
	 * @Description: 获取关注（watch） button的文本
	 * @return: String
	 * @author: jianbin.zhong
	 */
	public static String getWatchBtnText(){
		return getElement(follow).getText();
	}
	
	/**
	 * 
	 * @Method: clickNoification 
	 * @param: 
	 * @Description: 点击消息button
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickNoification(){
		getElement(notifications);
	}
	
	/**
	 * 
	 * @Method: getNotificationBtnText 
	 * @param: @return
	 * @Description: 获取notification button的文本
	 * @return: String
	 * @author: jianbin.zhong
	 */
	public static String getNotificationBtnText(){
		return getElement(notifications).getText();
	}
	
	/**
	 * 
	 * @Method: clickSearch 
	 * @param: 
	 * @Description: 点击search button
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickSearch(){
		getElement(search).click();
	}
	
	/**
	 * 
	 * @Method: clickAvatar 
	 * @param: 
	 * @Description: watch界面nav 栏点击头像
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public static void clickAvatar(){
		clickElement(loginBtn);
	}
	
	/**
	 * 
	 * @Method: clickSelfPage 
	 * @param: 
	 * @Description: 点击nav栏avatar下的个人主页
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickLoginSelfPage(){
		getElement(loginSelfPage).click();
	}
	
	/**
	 * 
	 * @Method: clickLoginSetting 
	 * @param: 
	 * @Description: 点击nav栏avatar下的设置
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickLoginSetting(){
		getElement(loginSetting).click();
	}
	
	/**
	 * 
	 * @Method: clickLoginOut 
	 * @param: 
	 * @Description: 点击nav栏avatar下的退出登录
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickLoginOut(){
		getElement(loginLogOut);
	}
	
	//用户个人信息User
	/**
	 * 
	 * @Method: clickUserAvatar 
	 * @param: 
	 * @Description: 点击左侧用户一栏的用户头像
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickUserAvatar(){
		getElement(userAvatar).click();
	}
	
	/**
	 * 
	 * @Method: clickUserNickname 
	 * @param: 
	 * @Description: 点击左侧用户一栏的用户nickname
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickUserNickname(){
		getElement(userNickname).click();
	}
	
	/**
	 * 
	 * @Method: getUserNicknameValue 
	 * @param: 
	 * @Description: 获取左侧用户一栏的用户nickname值
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void getUserNicknameValue(){
		getElement(userNickname).getText();
	}
	
	/**
	 * 
	 * @Method: clickUserVipIcon 
	 * @param: 
	 * @Description: 点击左侧用户一栏的Vip图标
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void clickUserVipIcon(){
		getElement(userVipIcon).click();
	}
	
	/**
	 * 
	 * @Method: getuserSioeyeIDIconTxt 
	 * @param: 
	 * @Description: 获取左侧SioeyeIDIcon的text
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void getUserSioeyeIDIconTxt(){
		getElement(userSioeyeIDIcon).getText();
	}
	
	/**
	 * 
	 * @Method: getUserSioeyeIDValue 
	 * @param: 
	 * @Description: 获取左侧SioeyeID所对应的值
	 * @return: void
	 * @author: jianbin.zhong
	 */
	public void getUserSioeyeIDValue(){
		getElement(userSioeyeIDValue).getText();
	}
	
	
}
