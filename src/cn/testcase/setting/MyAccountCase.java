package cn.testcase.setting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.page.AccountPage;
import cn.page.HomePage;
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
	public static void clickLinkData(String value ){
		List<WebElement> ems = getElement(By.cssSelector("div.radius-box.me-tab>ul")).findElements(By.tagName("li"));
		for (WebElement webElement : ems) {
			if (webElement.getAttribute("data-link").equals(value)) {
				webElement.click();
				break;
			}
		}
	}
	@Test
	public void test(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		clickLinkData("#account");
		wait(20);
	}
}
