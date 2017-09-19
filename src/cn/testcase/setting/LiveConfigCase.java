package cn.testcase.setting;

import model.VP;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//https://live.sioeye.cn/settings#live-config 直播配置
public class LiveConfigCase extends VP{
	@BeforeTest
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password){
		initialize(browser,username,password);
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
}
