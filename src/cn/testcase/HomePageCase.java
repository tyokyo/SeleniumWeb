package cn.testcase;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.page.AccountPage;
import cn.page.HomePage;
import model.VP;
import util.Log;
import util.TakeScreen;

/** 
 * @ClassName: HomePageCase 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author qiang.zhang@ck-telecom.com
 * @date 2017年8月21日 下午3:16:58 
 *  
 */
public class HomePageCase  extends VP{
	@BeforeTest
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password){
		initialize(browser,username,password);
		startSioeye();
	}

	public void testHome(){
		TakeScreen.takeScreenShotWithDraw("好味道alcatel");
		HomePage.clickLoginbtn();
	}
	@Test
	public void testLogin(){
		Set<Cookie> cookies=getDriver().manage().getCookies();
		System.out.println("cookie总数为"+cookies.size());
		for(Cookie cookie:cookies){
			Log.info("作用域："+cookie.getDomain()+", 名称："+cookie.getName()+
					", 值："+cookie.getValue()+", 范围："+cookie.getPath()+
					", 过期时间"+cookie.getExpiry());
			getDriver().manage().deleteCookie(cookie);
		}
		wait(3);
		TakeScreen.takeScreenShotWithDraw("好味道alcatel");
		HomePage.clickLoginbtn();
		AccountPage.loginAccount();
		TakeScreen.takeScreenShotWithDraw("Login success");
		TakeScreen.takeScreenShotWithDraw("wechat");
		clickByCssSelector("[class='btn-login avatar log-on']");
		clickByLinkText("个人主页");
		clickByClassName("icon-download");
		wait(20);
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
}
