package cn.page.setting;

import java.util.List;
import model.VP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavToSetting extends VP{

	/** 
	* @Title: editInfoChooseRadioBox 
	* @Date:2017年9月20日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 编辑资料选择导航到？
	* @param value
	* @return WebElement
	*/
	public static WebElement editInfoChooseRadioBox(String value){
		WebElement chooseElement = null ;
		List<WebElement> ems = getElement(By.cssSelector("div.radius-box.me-tab>ul")).findElements(By.tagName("li"));
		for (WebElement webElement : ems) {
			if (webElement.getAttribute("data-link").equals(value)) {
				chooseElement =  webElement;
				break;
			}
		}
		return chooseElement;
	}
	/** 
	 * @Title: navToEditInfo 
	 * @Date:2017年9月19日
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 编辑资料选择导航到？
	 * @param value  =个人资料|我的账号|直播配置|修改密码|串码流
	 */
	public static void navToEditInfo(String value){
		switch (value) {
		case "个人资料":
			editInfoChooseRadioBox("#info").click();;
			break;
		case "我的账号":
			editInfoChooseRadioBox("#account").click();;
			break;
		case "直播配置":
			editInfoChooseRadioBox("#live-config").click();;
			break;
		case "修改密码":
			editInfoChooseRadioBox("#password").click();;
			break;
		case "串码流":
			editInfoChooseRadioBox("#rtmp-config").click();;
			break;
		default:
			break;
		}
	}
}
