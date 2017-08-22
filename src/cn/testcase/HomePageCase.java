package cn.testcase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import cn.page.AccountPage;
import cn.page.HomePage;
import model.VP;
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
		initializeSelenium(browser,username,password);
	}
	public void testHome(){
		TakeScreen.takeScreenShotWithDraw("好味道alcatel");
		HomePage.clickLoginbtn();
	}
	@Test
	public void testLogin(){
		TakeScreen.takeScreenShotWithDraw("好味道alcatel");
		HomePage.clickLoginbtn();
		AccountPage.loginAccount();
		TakeScreen.takeScreenShotWithDraw("Lolgin success");
		TakeScreen.takeScreenShotWithDraw("wechat");
		
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
}
