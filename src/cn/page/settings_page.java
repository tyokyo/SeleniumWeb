package cn.page;
import model.VP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.remote.server.handler.SendKeys;

import util.Log;
/** 
* @ClassName: setting_page
* @Description: url=https://live.sioeye.cn/settings
* 设置相关页面 
* @author xuefan.liao@163.com
* @date 2017年8月29日 上午11:27:10 
*  
*/
public class settings_page  extends VP{
	//Sioeye喜爱直播设置页面_个人资料
	//昵称
	static By nickname = By.id("nickname");
	//性别：男
	static By female = By.id("female");
	//性别：女
	static By male = By.id("male");
	//性别：保密
	static By secret = By.id("secret");
	//地址
	static By area = By.id("area");
	//个性签名
	static By motto =By.id("motto");
	//自定义爱好
	static By me_hobby = By.id("me-hobby");
	//添加爱好
	static By  add_hobby = By.id("me-hobby-add");
	//冲浪
	static By hobby1 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[1]");
	//喷气滑雪
	static By hobby2 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[2]");
	//山地自行车
	static By hobby3 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[3]");
	//摩托车越野
	static By hobby4 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[4]");
	//攀岩
	static By hobby5 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[5]");
	//浅滩冲浪
	static By hobby6 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[6]");
	//滑板
	static By hobby7 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[7]");
	//滑雪
	static By hobby8 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[8]");
	//滑翔伞
	static By hobby9 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[9]");
	//滑雪
	static By hobby10 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[10]");
	//潜水
	static By hobby11 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[11]");
	//皮划艇
	static By hobby12 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[12]");
	//酷跑
	static By hobby13 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[13]");
	//风帆
	static By hobby14 = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[14]");
	//保存
	static By save_personal = By.id("save-personal-info");
	
	//Sioeye喜爱直播设置页面_我的账号
	//SioeyeID
	static By  sioeyeid = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/input");
	//绑定手机号
	static By bind_phone = By.id("btn-bind-phone");
	//绑定邮箱
	static By bind_email = By.id("btn-bind-email");
	//修改手机号
	static By edit_phone = By.id("btn-edit-phone");
	//修改邮箱
	static By edit_email = By.id("btn-edit-email");
	//绑定输入密码
	static By bind_password = By.id("bind-input-password");
	//确认输入密码
	static By verify_password = By.id("verify-password");
	//关闭输入密码
	static By close = By.className("close");
	
	
	//Sioeye喜爱直播设置页面_直播配置
	//默认直播标题
	static By title = By.id("live-title");
	//公开
	static By all = By.linkText("公开");
	//仅自己可见
	static By myself = By.linkText("仅自己可见");
	//部分可见
	static By someone = By.linkText("部分可见");
	//搜索谁可以看我的直播
	static By search_fans = By.xpath("/html/body/div[4]/div[2]/div[3]/div[1]/div[1]/input");
	//点击搜索
	static By seach = By.xpath("/html/body/div[4]/div[2]/div[3]/div[1]/div[1]/span");
	//选择用户
	
	//修改封面
	static By edit_thumb = By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[4]/div[2]/button");
	//保存
	static By save_config = By.id("save-live-config");
	
			
	//Sioeye喜爱直播设置页面_修改密码
	//旧密码
	static By password_old = By.id("password-old");
	//新密码
	static By password_new = By.id("password-new");
	//重复输入密码
	static By password_confirm = By.id("password-confirm");
	//保存
	static By save_password = By.id("save-password");
	
	//Sioeye喜爱直播设置页面_串码流
	//设备名称
	static By  device_name = By.id("device-name");
	//申请
	static By rtmp_apply = By.xpath("/html/body/div[2]/div/div[2]/div[5]/div[2]/button");
	//串码流id
	static By rtmp_id = By.id("rtmp-id");
	//停止
	static By rtmp_stop = By.xpath("/html/body/div[2]/div/div[2]/div[5]/div[3]/button");
	
	/** 
	* @Title: getNicknameElement 
	* @author xuefan.liao
	* @Description: 获取用户名对象
	* @return WebElement    返回类型 
	*/
	public static WebElement getNicknameElement(){
		return getElement(nickname);
	}
	
	/** 
	* @Title: clearNickname
	* @author xuefan.liao
	* @Description: 清除昵称框文本框内容
	* @return void    返回类型 
	*/
	public static void clearNickname(){
		getNicknameElement().clear();
	}

	/** 
	* @Title: inputNickname
	* @author xuefan.liao
	* @Description: 输入昵称
	* @return void    返回类型 
	*/
	public static void inputNickname (String keys){
		sendKeys(nickname , keys);
	}	
	
	/** 
	* @Title: clickFemale
	* @author xuefan.liao
	* @Description: 选择男
	* @return void    返回类型 
	*/
	public static void clickFemale(){
		clickElement(female);	
	}			
	
	/** 
	* @Title: clickMale
	* @author xuefan.liao
	* @Description: 选择女
	* @return void    返回类型 
	*/
	public static void clickMale(){
		clickElement(male);	
	}		
	
	/** 
	* @Title: clickSecret
	* @author xuefan.liao
	* @Description: 选择保密
	* @return void    返回类型 
	*/
	public static void clickSecret(){
		clickElement(secret);	
	}		
	
	/** 
	* @Title: getAreaElement 
	* @author xuefan.liao
	* @Description: 获取用户名对象
	* @return WebElement    返回类型 
	*/
	public static WebElement getAreaElement(){
		return getElement(area);
	}
	
	/** 
	* @Title: clearArea
	* @author xuefan.liao
	* @Description: 清除地址框文本框内容
	* @return void    返回类型 
	*/
	public static void clearArea(){
		getAreaElement().clear();
	}

	/** 
	* @Title: inputArea
	* @author xuefan.liao
	* @Description: 输入地址
	* @return void    返回类型 
	*/
	public static void inputArea (String keys){
		sendKeys(area , keys);
	}	
	
	/** 
	* @Title: getMottoElement() 
	* @author xuefan.liao
	* @Description: 获取用户名对象
	* @return WebElement    返回类型 
	*/
	public static WebElement getMottoElement(){
		return getElement(motto);
	}
	
	/** 
	* @Title: clearMotto
	* @author xuefan.liao
	* @Description: 清除签名框文本框内容
	* @return void    返回类型 
	*/
	public static void clearMotto(){
		getMottoElement().clear();
	}

	/** 
	* @Title: inputMotto
	* @author xuefan.liao
	* @Description: 输入签名
	* @return void    返回类型 
	*/
	public static void inputMotto (String keys){
		sendKeys(motto , keys);
	}	
	
	/** 
	* @Title: getMe_hobbyElement() 
	* @author xuefan.liao
	* @Description: 获取用户名对象
	* @return WebElement    返回类型 
	*/
	public static WebElement getMe_hobbyElement(){
		return getElement(me_hobby);
	}
	
	/** 
	* @Title: clearMe_hobby
	* @author xuefan.liao
	* @Description: 清除自定义爱好框文本框内容
	* @return void    返回类型 
	*/
	public static void clearMe_hobby(){
		getMe_hobbyElement().clear();
	}

	/** 
	* @Title: inputMe_hobby
	* @author xuefan.liao
	* @Description: 输入自定义爱好
	* @return void    返回类型 
	*/
	public static void inputMe_hobby (String keys){
		sendKeys(me_hobby , keys);
	}	
	
}
