package model;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
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
	public static void wait(int time){
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // sleeping for 4 minutes
	}
}
