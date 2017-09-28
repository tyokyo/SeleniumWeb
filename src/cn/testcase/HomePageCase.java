package cn.testcase;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.data.TestDataProvider;
import cn.page.AccountPage;
import cn.page.PromotionPage;
import model.VP;
import model.WaitCondition;
import util.TakeScreen;

/** 
 * @ClassName: HomePageCase 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author qiang.zhang@ck-telecom.com
 * @date 2017年8月21日 下午3:16:58 
 *  
 */
public class HomePageCase  extends VP{

	@BeforeMethod
	public void BeforeMethod(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();		
	}
	/*
	 * @Parameters({"browser","username","password"})
	 * public void beforeTest(String browser,String username,String password){
		initialize(browser,username,password);
		startSioeye();
	}*/

	/** 
	 * @Title: testPlayWonderfulLive 
	 * @Date:2017年9月26日
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 视频观看-播放第一个视频
	 */
	@Test(description="播放视频",dataProvider="offlinevideo",dataProviderClass=TestDataProvider.class)
	public void testWatchVideo(String videoDomain){
		List<WebElement> divs = getDriver().findElements(By.cssSelector(".live-box>div"));
		for (WebElement webElement : divs) {
			List<WebElement> spans = webElement.findElement(By.className("live-type")).findElements(By.tagName("span"));
			for (WebElement webElement2 : spans) {
				String domain = webElement2.getText();
				if (videoDomain.equals(domain)) {
					webElement.findElements(By.cssSelector(".live-video>a")).get(0).click();
					WaitCondition.waitInvisibilityOfElementLocated(By.tagName("video"), 60);
					TakeScreen.takeScreenShotWithDraw(domain);
					break;
				}
			}
		}
	}
	@Test(description="播放视频+Follow",dataProvider="offlinevideo",dataProviderClass=TestDataProvider.class)
	public void testWatchVideoThenFollow(String videoDomain){
		Set<String> oldhandles = getDriver().getWindowHandles();
		List<WebElement> divs = getDriver().findElements(By.cssSelector(".live-box>div"));
		boolean find = false;
		for (WebElement webElement : divs) {
			if (find) {
				break;
			}
			List<WebElement> spans = webElement.findElement(By.className("live-type")).findElements(By.tagName("span"));
			for (WebElement webElement2 : spans) {
				String domain = webElement2.getText();
				if (videoDomain.equals(domain)) {
					webElement.findElements(By.cssSelector(".live-video>a")).get(0).click();
					WaitCondition.waitInvisibilityOfElementLocated(By.tagName("video"), 60);
					Set<String> newhandles = getDriver().getWindowHandles();
					newhandles.removeAll(oldhandles);
					setDriver(getDriver().switchTo().window(newhandles.iterator().next()));
					TakeScreen.takeScreenShotWithDraw(domain);
					PromotionPage.clickFollow();
					WaitCondition.waitElementToBeClickable(AccountPage.username, 60);
					TakeScreen.takeScreenShotWithDraw("account_page");
					find=true;
					Assert.assertEquals(isElementExist(AccountPage.password,5), true,"login page");
					break;
				}
			}
		}
	}
	@AfterMethod
	public void afterTest(){
		quiteSelenium();
	}
}
