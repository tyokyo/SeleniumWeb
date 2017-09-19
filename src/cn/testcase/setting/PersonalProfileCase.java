package cn.testcase.setting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.page.AccountPage;
import cn.page.HomePage;
import cn.page.SettingsPage;
import model.VP;
import model.WaitCondition;

/** 
 * https://live.sioeye.cn/settings#info
* @ClassName: PersonalProfileCase 
* @Description: 个人资料
* @author qiang.zhang@ck-telecom.com
* @date 2017年9月14日 上午11:26:01 
*  
*/
public class PersonalProfileCase  extends VP{
	@BeforeTest
	public void beforeTest(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
	
	/** 
	* @Title: testModifyNickName 
	* @Date:2017年9月14日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 修改昵称
	*/
	@Test
	public void testModifyNickName(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		SettingsPage.clearNickname();
		String expectNickName = getRandomString(10);
		SettingsPage.inputNickname(expectNickName);
		SettingsPage.clickSavePersonalProfile();
		
		//重新打开网页
		restart();
		
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		WaitCondition.waitTextToBePresentInElementValue(SettingsPage.nickname, expectNickName, 20);
		String actual = SettingsPage.getNicknameElement().getAttribute("value");
		Assert.assertEquals(actual, expectNickName,"nickname");
	}
	@Test
	public void testSexMale(){
		
	}
	@Test
	public void testSexFeMale(){
		
	}
	@Test
	public void testSexSecret(){
		
	}
	@Test
	public void testLocation(){
		
	}
	@Test
	public void testPersonalizedSignature(){
		
	}
	@Test
	public void testInputHobby(){
		
	}
	@Test
	public void testDelAllHobby(){
		
	}
	@Test
	public void testAddHobby(){
		
	}
}
