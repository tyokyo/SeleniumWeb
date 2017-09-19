package cn.testcase.setting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import model.VP;
//https://live.sioeye.cn/settings#password 修改密码
public class PasswordCase extends VP{
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
