package cn.testcase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.page.AccountPage;
import util.Property;
import model.VP;
import model.WaitCondition;

public class AccountCase extends VP{
	@BeforeTest
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password){
		initialize(browser,username,password);
	}
	/** 
	* @Title: testLogonSuccessBySioeyeId 
	* @Date:2017年9月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 采用 sioeye id 登录Web
	*/
	@Test
	public void testLogonSuccessBySioeyeId(){
		String username = Property.getValueByKey(accountPath, "sioeye_id");
		String password = Property.getValueByKey(accountPath, "sioeye_password");
		initialize(getBean().getBrowser(),username,password);
		startSioeye();
		AccountPage.loginAccount();
		WaitCondition.waitTitleContains("关注 - Sioeye喜爱直播相机_手机视频直播设备_微型运动摄像机哪个牌子好_户外便携数码相机费用",10);
		String actual = getDriver().getCurrentUrl();
		Assert.assertEquals(actual, "https://live.sioeye.cn/watch", "watch page");
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
}
