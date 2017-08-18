package cn.testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cn.page.HomePage;
import model.VP;
import util.TakeScreen;

public class HomePageCase  extends VP{
	@BeforeTest
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password){
		initializeSelenium(browser,username,password);
	}
	@Test
	public void testHome(){
		TakeScreen.takeScreenShotWithDraw("好味道alcatel");
		HomePage.clickLoginbtn();
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
}
