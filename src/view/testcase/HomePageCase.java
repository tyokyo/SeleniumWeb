package view.testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import model.VP;
import util.TakeScreen;
import view.po.HomePage;

public class HomePageCase  extends VP{
	@BeforeTest
	@Parameters({"browser","username","password"})
	public void beforeTest(String browser,String username,String password){
		initializeSelenium(browser,username,password);
	}
	@Test
	public void testHome(){
		HomePage hPage = new HomePage();
		
		TakeScreen.takeScreenShot();
		hPage.clickLoginbtn();
	}
	@AfterTest
	public void afterTest(){
		quiteSelenium();
	}
}
