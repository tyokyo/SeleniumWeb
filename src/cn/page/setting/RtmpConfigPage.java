package cn.page.setting;

import cn.page.AccountPage;
import cn.page.HomePage;

public class RtmpConfigPage {
	
	/** 
	* @Title: navRtmp 
	* @Date:2017年9月22日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 设置-串码流
	*/
	public static void navRtmp(){
		AccountPage.loginAccount();
		HomePage.clickAavtar();
		HomePage.clickSetting();
		NavToSetting.navToEditInfo("串码流");
	}
}
