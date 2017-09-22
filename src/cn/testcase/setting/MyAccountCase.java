package cn.testcase.setting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import cn.page.AccountPage;
import cn.page.HomePage;
import cn.page.setting.NavToSetting;
import cn.page.setting.PersonalProfilePage;
import model.VP;
//https://live.sioeye.cn/settings#account 我的账号
public class MyAccountCase extends VP{
	@BeforeTest
	public void beforeTest(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();		
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
	@Test
	public void testSioeyeID_Diasble(){
		
	}
	@Test
	public void test(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		NavToSetting.navToEditInfo("个人资料");
		PersonalProfilePage.chooseSex("secret");
		//setHobby("风帆", true);
		//wait(10);
		PersonalProfilePage.hobbyAllSelected(true);
		wait(10);
	}
}
