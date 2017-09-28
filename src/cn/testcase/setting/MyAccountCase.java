package cn.testcase.setting;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.page.setting.MyAccountPage;
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
	public void testSioeyeID_Disable(){
		MyAccountPage.navToMyAccount();
		WebElement idEmt = MyAccountPage.getSioeyeID();
		String expect = idEmt.getAttribute("value");
		try {
			MyAccountPage.getSioeyeID().sendKeys(getRandomString(5));
			String actual = idEmt.getAttribute("value");
			Assert.assertEquals(actual, expect,"disable for modify sioeyeid");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
		}
	}
}
