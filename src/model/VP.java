package model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.uncommons.reportng.Reporters;
import run.TestNgXml;
import util.Log;
import util.TakeScreen;

public class VP  extends BaseSelenium{
	public static String accountPath = "properties/account.properties";
	private static String SEPERATE="/";

	/**
	 * 点击操作
	 * @author qiang.zhang@ck-telecom.com
	 * @param by
	 */
	public static void clickElement(By by){
		getElement(by).click();
		Log.info("click by - "+by.toString());
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
		Log.info(String.format("sendKeys by=%s   keys=%s", by.toString(),keys));
		WebElement element = getElement(by);
		element.clear();
		element.sendKeys(keys);
	}
	/**
	 * 获取对象
	 * @author qiang.zhang@ck-telecom.com
	 * @param by
	 * @return WebElement
	 */
	public static WebElement getElement(By by){
		Log.info(String.format("find element by=%s", by.toString()));
		WebElement element = getDriver().findElement(by);
		highlightElement(element);
		return element;
	}
	public static String getText(WebElement element){
		Log.info(element.getText()+"");
		return element.getText();
	}
	public static void clickElement(WebElement element){
		Log.info("Action-click ");
		element.click();
	}
	/** 
	 * @Title: clickById 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description:  id 定位点击元素 
	 *  @param id    
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clickById(String id){
		By by = By.id(id);
		clickElement(by);
	}
	public static void clickByClassName(String className){
		By by = By.className(className);
		clickElement(by);
	}
	/** 
	 * @Title: clickByCssSelector 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: cssSelector 定位点击元素 
	 *  @param cssSelector    
	 * @return void    
	 * @throws 
	 */
	public static void clickByCssSelector(String cssSelector){
		By by = By.cssSelector(cssSelector);
		clickElement(by);
	}
	//By.linkText
	/** 
	 * @Title: clickByLinkText 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 *  @param linkText    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clickByLinkText(String linkText){
		By by = By.linkText(linkText);
		clickElement(by);
	}
	//By.name
	/** 
	 * @Title: clickByName 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 通过name 点击元素
	 *  @param name    
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clickByName(String name){
		By by = By.name(name);
		clickElement(by);
	}
	//By.xpath
	/** 
	 * @Title: clickByXpath 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 通过xpath 点击元素
	 *  @param xpathExpression    
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clickByXpath(String xpathExpression){
		By by = By.xpath(xpathExpression);
		clickElement(by);
	}
	//By.partialLinkText
	/** 
	 * @Title: clickByPartialLinkText 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 *  @param linkText    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void clickByPartialLinkText(String linkText){
		By by = By.partialLinkText(linkText);
		clickElement(by);
	}
	//click By.id
	/** 
	 * @Title: getElementById 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 *  @param id    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static WebElement getElementById(String id){
		By by = By.id(id);
		return getElement(by);
	}
	//By.cssSelector
	/** 
	 * @Title: getElementByCssSelector 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 *  @param id    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static WebElement getElementByCssSelector(String selector){
		By by = By.cssSelector(selector);
		return getElement(by);
	}
	//By.linkText
	/** 
	 * @Title: getElementByLinkText 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 通过linkText 点击元素
	 *  @param linkText   
	 * @return void    返回类型 
	 * @throws 
	 */
	public static WebElement getElementByLinkText(String linkText){
		By by = By.linkText(linkText);
		return getElement(by);
	}
	//By.name
	/** 
	 * @Title: getElementByName 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 获取元素by name
	 *  @param name    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static WebElement getElementByName(String name){
		By by = By.name(name);
		return getElement(by);
	}
	//By.xpath
	/** 
	 * @Title: getElementByXpath 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 获取元素by xpath
	 *  @param xpathExpression    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static WebElement getElementByXpath(String xpathExpression){
		By by = By.xpath(xpathExpression);
		return getElement(by);
	}
	//By.partialLinkText
	/** 
	 * @Title: getElementByPartialLinkText 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 获取元素by linkText
	 *  @param linkText    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static WebElement getElementByPartialLinkText(String linkText){
		By by = By.partialLinkText(linkText);
		return getElement(by);
	}
	/** 
	 * @Title: takeScreenShot 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 截取屏幕
	 *  @param tr    ITestResult
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void takeScreenShot(ITestResult tr) {
		if (getDriver()!=null){
			Log.info("takeScreenShot-ITestResult-Fail");
			Log.info(tr.getTestClass().getName()+SEPERATE+tr.getMethod().getMethodName());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String mDateTime = formatter.format(new Date());
			//File location = new File("test-output/screenshot");
			File location = new File(TestNgXml.screenshotFolder);
			String screenName = tr.getTestClass().getName()+SEPERATE+tr.getMethod().getMethodName()+SEPERATE+mDateTime+".png";
			String screenShotPath = location.getAbsolutePath()+SEPERATE+screenName;
			File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File(screenShotPath));
				Log.info(screenShotPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.setCurrentTestResult(tr);
			//Reporters.logDebug(true,"<img src=../screenshot/" + screenName + " onclick='window.open(\"../screenshot/"+screenName+"\")' height='50' width='50'/>");
			Reporters.logDebug(true,("<img src=../screenshot/" + screenName + " onmousewheel=\"return bbimg(this)\""+ " onclick='window.open(\"../screenshot/"+screenName + "\")\'/>"));
		}else {
			Reporters.logDebug(true,"getDriver() is NULL, screenshot Skipped");
		}
	}

	/** 
	 * @Title: wait 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 等待方法 
	 *  @param time    int
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
	 *  @param by    By 过滤器
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


	/** 
	 * @Title: highlightElement 
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: 高亮显示元素
	 * @param by    参数 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void highlightElement(WebElement element) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].style.border='3px solid red'", element);
		} catch (Exception e) {
			TakeScreen.takeScreenShotWithDraw("NotFindBy");
			e.printStackTrace();
		}
	}
	public static void waitUntilByFind(By by,int seconds){
		Log.info(String.format("waitUntilFind  %s in  %d seconds",by.toString(),seconds ));
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			Log.info(by.toString() + "  waitUntilFind = success");
		} catch (Exception e) {
			// TODO: handle exception
			Log.info(by.toString() + " waitUntilFind = Not find ");
		}
	}
	public static void waitUntilByGone(By by,int seconds){
		Log.info(String.format("waitUntilByNotFind in %d secods",seconds));
		boolean exit=false;
		for (int i = 0; i < seconds; i++) {
			try {
				getDriver().findElement(by);
			} catch (Exception e) {
				Log.info("now exit");
				exit=true;
			}
			if (exit) {
				break;
			}
		}
	}
	public static WebElement waitAuto(By by, int time) {
		try {
			return new WebDriverWait(getDriver(), time).until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver webDriver) {
					Log.info("查找结果-success-" + time + " 秒之内找到元素 [" + by.toString() + "]");
					return (WebElement) webDriver.findElement(by);
				}
			});
		} catch (TimeoutException e) {
			Log.info("查找元素失败-超时- " + time + " 秒之后还没找到元素 [" + by.toString() + "]");
			return null;
		}
	}
}