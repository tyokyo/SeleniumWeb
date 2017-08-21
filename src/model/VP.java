package model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.uncommons.reportng.Reporters;

import run.TestNgXml;

public class VP  extends BaseSelenium{
	private  static Logger logger = Logger.getLogger(VP.class.getName());
	private static String SEPERATE="/";

	/**
	 * 点击操作
	 * @param by
	 */
	public static void clickElement(By by){
		getDriver().findElement(by).click();
	}
	
	/** 
	* @Title: sendKeys 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 输入字符
	*  @param by       定位元素
	*  @param keys    String  
	* @return void    返回类型 
	* @throws 
	*/
	public static void sendKeys(By by,String keys){
		WebElement element = getElement(by);
		element.sendKeys(keys);
	}
	/**
	 * 获取对象
	 * @param by
	 * @return WebElement
	 */
	public static WebElement getElement(By by){
		return getDriver().findElement(by);
	}
	public static void clickById(String id){
		getDriver().findElement(By.id(id)).clear();
	}
	//By.cssSelector
	public static void clickByCssSelector(String id){
		getDriver().findElement(By.cssSelector(id)).click();
	}
	//By.linkText
	public static void clickByLinkText(String linkText){
		getDriver().findElement(By.linkText(linkText)).click();
	}
	//By.name
	public static void clickByName(String name){
		getDriver().findElement(By.name(name)).click();
	}
	//By.xpath
	public static void clickByXpath(String xpathExpression){
		getDriver().findElement(By.xpath(xpathExpression)).click();
	}
	//By.partialLinkText
	public static void clickByPartialLinkText(String linkText){
		getDriver().findElement(By.partialLinkText(linkText)).click();
	}
	//click By.id
	public static void getElementById(String id){
		getDriver().findElement(By.id(id));
	}
	//By.cssSelector
	public static void getElementByCssSelector(String id){
		getDriver().findElement(By.cssSelector(id));
	}
	//By.linkText
	public static void getElementByLinkText(String linkText){
		getDriver().findElement(By.linkText(linkText));
	}
	//By.name
	public static void getElementByName(String name){
		getDriver().findElement(By.name(name));
	}
	//By.xpath
	public static void getElementByXpath(String xpathExpression){
		getDriver().findElement(By.xpath(xpathExpression));
	}
	//By.partialLinkText
	public static void getElementByPartialLinkText(String linkText){
		getDriver().findElement(By.partialLinkText(linkText));
	}
	public static void takeScreenShot(ITestResult tr) {
		if (getDriver()!=null){
			logger.info("takeScreenShot-ITestResult-Fail");
			logger.info(tr.getTestClass().getName()+SEPERATE+tr.getMethod().getMethodName());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String mDateTime = formatter.format(new Date());
			//File location = new File("test-output/screenshot");
			File location = new File(TestNgXml.screenshotFolder);
			String screenName = tr.getTestClass().getName()+SEPERATE+tr.getMethod().getMethodName()+SEPERATE+mDateTime+".png";
			String screenShotPath = location.getAbsolutePath()+SEPERATE+screenName;
			File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File(screenShotPath));
				logger.info(screenShotPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.setCurrentTestResult(tr);
			//Reporters.logDebug(true,"<img src=../screenshot/" + screenName + " onclick='window.open(\"../screenshot/"+screenName+"\")' height='50' width='50'/>");
			Reporters.logDebug(true,("<img src=../screenshot/" + screenName + " onmousewheel=\"return bbimg(this)\""+ " onclick='window.open(\"../screenshot/"+screenName + "\")\' height='50' width='50'/>"));
		}else {
			Reporters.logDebug(true,"getDriver() is NULL, screenshot Skipped");
		}
	}

	/** 
	 * @Title: wait 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 等待方法 
	 *  @param time    等待时间（秒）
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void wait(int time){
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // sleeping for 4 minutes
	}
	/** 
	 * @Title: rightClickMouse 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 模拟鼠标操作
	 *  @param by    过滤器
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void rightClickMouse(By by)
	{
		Actions action = new Actions(getDriver());
		action.contextClick(getDriver().findElement(by)).perform();    
	}

	/** 
	 * @Title: killProcess 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 杀掉Windows浏览器进程  
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void killProcess(String browser)
	{
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			// kill firefox
			WindowsUtils.killByName("firefox.exe");
			break;
		case "CHROME":
			// kill chrome
			WindowsUtils.killByName("chrome.exe");
			break;
		case "IE":
			// kill IE
			WindowsUtils.killByName("iexplore.exe");
			break;
		default:
			System.out.println("error browser name");
			break;
		}
	}
	
	/** 
	* @Title: moveTo 
	* @author qiang.zhang@ck-telecom.com
	* @Description: 滚动条滚动到元素位置
	*  @param by    元素
	* @return void    返回类型 
	* @throws 
	*/
	public static void moveTo(By by){
		Actions action = new Actions(getDriver()); 
		WebElement toFindElement = getDriver().findElement(by);
		action.moveToElement(toFindElement).build().perform(); 
	}
	// 操作弹出窗口
	public static void multipleWindowsTitle() throws Exception
	{
		String url="E:\\StashFolder\\huoli_28@hotmail.com\\Stash\\Tank-MoneyProject\\Selenium Webdriver\\AllUIElement.html";
		getDriver().get(url);
		// 获取当前窗口的句柄
		String parentWindowId = getDriver().getWindowHandle();
		System.out.println("driver.getTitle(): " + getDriver().getTitle());

		WebElement button = getDriver().findElement(By.xpath("//input[@value='打开窗口']"));
		button.click();

		Set<String> allWindowsId = getDriver().getWindowHandles();
		// 获取所有的打开窗口的句柄
		for (String windowId : allWindowsId) {
			if (getDriver().switchTo().window(windowId).getTitle().contains("博客园")) {
				getDriver().switchTo().window(windowId);
				break;
			}
		}
		System.out.println("driver.getTitle(): " + getDriver().getTitle());
		// 再次切换回原来的父窗口
		getDriver().switchTo().window(parentWindowId);
		System.out.println("parentWindowId: " + getDriver().getTitle());
	}
}