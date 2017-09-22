package cn.testcase.setting;

import java.io.File;
import java.util.List;

import model.VP;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.data.TestDataProvider;
import cn.page.setting.LiveConfigPage;
import cn.page.setting.NavToSetting;
//https://live.sioeye.cn/settings#live-config 直播配置
public class LiveConfigCase extends VP{
	/*@BeforeMethod
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password){
		initialize(browser,username,password);
	}*/
	@BeforeMethod
	public void BeforeMethod(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();		
	}
	@AfterMethod
	public void AfterMethod(){
		quiteSelenium();
	}
	/** 
	* @Title: testLiveTitle 
	* @Date:2017年9月21日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 修改直播标题
	*/
	@Test(description="直播标题",dataProvider="livetitle",dataProviderClass=TestDataProvider.class)
	public void testLiveTitle(String title){
		LiveConfigPage.navToLiveConfig();
		
		String  expected  = title;
		LiveConfigPage.inputLiveTitle(expected);
		LiveConfigPage.clickLiveSavebtn();
		
		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");
		NavToSetting.navToEditInfo("直播配置");
		
		String actual = LiveConfigPage.getLiveTitle();
		
		Assert.assertEquals(actual, expected,"verify title is "+title);
	}
	@Test(description="直播权限",dataProvider="privilege",dataProviderClass=TestDataProvider.class)
	public void testSettingMyLivePrivilege(String privilege,String setting_privilege){
		LiveConfigPage.navToLiveConfig();
		String expect = privilege;
		LiveConfigPage.setLivePrivilege(expect);
		LiveConfigPage.clickLiveSavebtn();
		
		getDriver().navigate().refresh();
		
		String actual = LiveConfigPage.getLivePrivilegeSettings();
		Assert.assertEquals(actual, setting_privilege, "直播权限");
	}
	/** 
	* @Title: testWhoCanViewMyLive 
	* @Date:2017年9月21日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 设置可以看我的直播的好友
	*/
	@Test
	public void testSettingMyLiveViewers(){
		LiveConfigPage.navToLiveConfig();
		LiveConfigPage.setLivePrivilege("someone");
		
		List<WebElement> notSelect =LiveConfigPage .watchersOKKO(false);
		List<WebElement> isSelect =LiveConfigPage .watchersOKKO(true);
		if (notSelect.size()>=1) {
			for (WebElement webElement : notSelect) {
				webElement.click();
			}
			for (WebElement webElement : isSelect) {
				webElement.click();
			}
			
			LiveConfigPage.clickSelectSomeOne_Save();
			LiveConfigPage.clickLiveSavebtn();
			
			LiveConfigPage.setLivePrivilege("someone");
			
			List<WebElement>  viewers =  LiveConfigPage.watchsHasbeenSelected();
			List<WebElement> choosers =LiveConfigPage .watchersOKKO(true);
			List<WebElement> notchoosers =LiveConfigPage .watchersOKKO(false);
			
			Assert.assertEquals(notSelect.size(), choosers.size(),"推荐好友已经选择的");
			Assert.assertEquals(isSelect.size(), notchoosers.size(),"推荐好友未选择的");
			Assert.assertEquals(viewers.size(), notSelect.size(),"已经选择的好友");
			
			LiveConfigPage.clickSelectSomeOne_Close();
		}
		
	}
	/** 
	* @Title: testModifyLivethumb 
	* @Date:2017年9月21日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 直播封面
	*/
	@Test
	public void testModifyLivethumb(){
		LiveConfigPage.navToLiveConfig();
		LiveConfigPage.clickEditThumb();
		LiveConfigPage.clickSelectThumb();
		File f = new File("resource/picture/1.jpg");
		LiveConfigPage.inputThumb(f.getAbsolutePath());
		LiveConfigPage.clickSaveThumb();
		wait(60);
	}
}
