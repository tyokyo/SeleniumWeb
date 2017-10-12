package cn.page;

import java.util.List;

import model.VP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//https://live.sioeye.cn/watch  -  账号未登录时候
public class HomePage  extends VP{
	//Sioeye喜爱直播相机官网
	static By logo = By.className("ttbar-login");
	//发现
	static By discover = By.className("discover active");
	//关注
	static By follow = By.className("follow");
	//消息
	static By notifications = By.className("notifications");
	//搜索按钮
	static By btn_search = By.className("btn-search");
	//输入搜索内容
	static By search_input = By.id("search-box-input");
	//搜索
	static By btns_search = By.className("btns-search");
	//搜索视频
	static By btns_search_video = By.className("resource-video");
	//搜索用户
	static By btns_search_user =By.cssSelector("a[class='resource-user active']");
	//登录
	static By btn_login = By.cssSelector("a[class='btn-login avatar']");
	//头像
	static By avatar = By.cssSelector("[class='btn-login avatar log-on']");
	//个人主页
	static By personalPage = By.linkText("个人主页");
	//设置
	static By settings = By.linkText("设置");
	//退出登录
	static By logout = By.linkText("退出登录");
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
	 * @Title: clickSearchbtn 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 点击搜索
	 * @return void    返回类型 
	 */
	public static void clickSearchbtns(){
		clickElement(btns_search);
	}
	
	/** 
	* @Title: clickSearchvideo 
	* @Date:2017年10月11日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 搜索视频
	*/
	public static void clickSearchvideo(){
		clickElement(btns_search_video);
	}
	
	/** 
	* @Title: clickSearchuser 
	* @Date:2017年10月11日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 搜索用户
	*/
	public static void clickSearchuser(){
		getElement(By.className("resource-btn-box")).findElements(By.tagName("a")).get(1).click();
	}
	/** 
	* @Title: searchInput 
	* @Date:2017年10月11日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 输入搜索内容
	* @param content void
	*/
	public static void searchInput(String content){
		sendKeys(search_input, content);
	}
	/** 
	* @Title: searchVideoResult 
	* @Date:2017年10月11日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 搜索视频结果
	* @return List<WebElement>
	*/
	public static List<WebElement> searchVideoResult(){
		List<WebElement> resultsElements=getElement(By.className("live-video")).findElements(By.tagName("a"));
		return resultsElements;
	}
	
	/** 
	* @Title: searchUserResult 
	* @Date:2017年10月11日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 搜索用户结果
	* @return List<WebElement>
	*/
	public static List<WebElement> searchUserResult(){
		List<WebElement> resultsElements= getElement(By.className("search-user-list")).findElements(By.tagName("div"));
		return resultsElements;
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
	/** 
	* @Title: clickPersonalPage 
	* @Date:2017年9月14日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击-个人主页
	*/
	public static void clickPersonalPage(){
		clickElement(personalPage);
	}
	
	/** 
	* @Title: clickSetting 
	* @Date:2017年9月14日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击-设置
	*/
	public static void clickSetting(){
		clickElement(settings);
	}
	/** 
	* @Title: clickLogout 
	* @Date:2017年9月14日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击-退出登录
	*/
	public static void clickLogout(){
		clickElement(logout);
		waitUntilByGone(logout, 10);
	}
	
	/** 
	* @Title: clickAavtar 
	* @Date:2017年9月14日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 点击-头像
	*/
	public static void clickAavtar(){
		clickElement(avatar);
	}
}
