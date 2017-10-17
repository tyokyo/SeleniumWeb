package cn.testcase;

import model.VP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cn.page.AccountPage;

public class NotificationsCase extends VP{

	@BeforeMethod
	public void BeforeMethod(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();		
		AccountPage.loginAccount();
	}
	@AfterMethod
	public void AfterMethod(){
		quiteSelenium();
	}
}
