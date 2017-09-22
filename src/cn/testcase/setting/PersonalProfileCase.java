package cn.testcase.setting;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Log;
import cn.data.TestDataProvider;
import cn.page.AccountPage;
import cn.page.HomePage;
import cn.page.setting.NavToSetting;
import cn.page.setting.PersonalProfilePage;
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
	@BeforeMethod
	public void beforeTest(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();
	}
	@AfterMethod
	public void afterTest(){
		quiteSelenium();
	}

	/** 
	 * @Title: testModifyNickName 
	 * @Date:2017年9月14日
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 修改昵称
	 */
	@Test(description="昵称修改",dataProvider="nickname",dataProviderClass=TestDataProvider.class)
	public void testModifyNickName(String nickname){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		PersonalProfilePage.clearNickname();
		String expectNickName = nickname;
		PersonalProfilePage.inputNickname(expectNickName);
		PersonalProfilePage.clickSavePersonalProfile();

		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		WaitCondition.waitTextToBePresentInElementValue(PersonalProfilePage.nickname, expectNickName, 20);
		String actual = PersonalProfilePage.getNicknameElement().getAttribute("value");
		Assert.assertEquals(actual, expectNickName,"nickname");
	}
	@Test(description="性别设置",dataProvider="sex",dataProviderClass=TestDataProvider.class)
	public void testSexSetting(String sex){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();

		PersonalProfilePage.chooseSex(sex);
		PersonalProfilePage.clickSavePersonalProfile();

		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		String active = PersonalProfilePage.getSexStatus();
		Assert.assertEquals(active, sex,sex);
	}
	@Test
	public void testLocation(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		PersonalProfilePage.inputArea("四川-宜宾");
		PersonalProfilePage.clickSavePersonalProfile();

		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		String actual = PersonalProfilePage.getAreaElement().getAttribute("value");
		Assert.assertEquals(actual, "四川-宜宾", "修改位置");
	}
	@Test(description="个性签名",dataProvider="motoo",dataProviderClass=TestDataProvider.class)
	public void testPersonalizedSignature(String value){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		String expect = value;
		PersonalProfilePage.inputMotto(expect);;
		PersonalProfilePage.clickSavePersonalProfile();

		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		String actual = PersonalProfilePage.getMottoElement().getAttribute("value");
		Assert.assertEquals(actual, expect, "motto");

	}
	@Test
	public void testAddCustomHobby(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		String hobby = getRandomString(10);
		PersonalProfilePage.addHobby(hobby);
		PersonalProfilePage.clickSavePersonalProfile();

		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		boolean addSuccess = PersonalProfilePage.getAllHobbys().contains(hobby);
		Assert.assertEquals(addSuccess, true,"add custom hobby success");
	}

	@Test(description="添加删除所有爱好",dataProvider="allHobby",dataProviderClass=TestDataProvider.class)
	public void testAddDelAllHobby(boolean all){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		PersonalProfilePage.hobbyAllSelected(all);
		PersonalProfilePage.clickSavePersonalProfile();

		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		Hashtable<String, Boolean> hobbys = PersonalProfilePage.getAllHobbys();
		Set<String> ahobbysnames= hobbys.keySet();
		for (String hobby : ahobbysnames) {
			boolean actual = hobbys.get(hobby);
			Assert.assertEquals(actual, all,hobby+" check selected");
		}
	}
	@Test
	public void testAddRecommandHobby(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		PersonalProfilePage.hobbyAllSelected(true);
		PersonalProfilePage.clickSavePersonalProfile();
		Hashtable<String, Boolean> hobbymap= PersonalProfilePage.getAllHobbys();

		Set<String> hobbysnames= hobbymap.keySet();
		String hobbyFirstName = hobbysnames.toArray()[0].toString();
		Log.info("hobbyFirstName-"+hobbyFirstName);
		PersonalProfilePage.hobbySetting(hobbyFirstName, false);
		PersonalProfilePage.clickSavePersonalProfile();


		NavToSetting.navToEditInfo("串码流");
		NavToSetting.navToEditInfo("个人资料");

		Hashtable<String, Boolean> hobbys = PersonalProfilePage.getAllHobbys();
		Set<String> ahobbysnames= hobbys.keySet();
		for (String hobby : ahobbysnames) {
			if (hobbyFirstName.equals(hobby)) {
				boolean actual = hobbys.get(hobby);
				Assert.assertEquals(actual, false,hobby+" check not selected");
			}else {
				boolean actual = hobbys.get(hobby);
				Assert.assertEquals(actual, true,hobby+" check not selected");
			}
		}
	}
}
