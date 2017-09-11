package model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Log;
import util.ParameterBean;
import org.apache.log4j.PropertyConfigurator; 
public class BaseSelenium {
	private static  WebDriver driver;
	private static  ParameterBean  bean;;
	public static ParameterBean getBean() {
		return bean;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void startSioeye(){
		//driver.manage().window().maximize();  
		driver.manage().deleteCookieNamed("JSESSIONID");
		driver.get("https://live.sioeye.cn/");
		driver.manage().deleteAllCookies();
		//设置10秒
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * 初始化driver
	 */
	public  static void initializeSelenium(String browser,String username,String password){
		PropertyConfigurator.configure(".\\Log4j.properties");  
		bean = new ParameterBean();
		bean.setBrowser(browser);
		bean.setUsername(username);
		bean.setPassword(password);

		Log.info("start browser-"+browser);
		
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			initFireFoxDriver();
			break;
		case "CHROME":
			initChromeDriver();
			break;
		case "IE":
			initIE();;
			break;
		default:
			System.out.println("error browser name");
			break;
		}
	}
	private static void initFireFoxDriver(){
		VP.killProcess("firefox");
		Log.info("init firefox browser");
		String driver_path = System.getProperty("user.dir")+"\\driver\\firefox\\64\\geckodriver.exe";
		//firefox版本低于48
		//System.setProperty("webdriver.firefox.marionette", driver_path);  
		System.setProperty("webdriver.gecko.driver", driver_path);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		//初始化一个FireFox浏览器实例，实例名称叫driver    
		driver=new FirefoxDriver(capabilities);
		//最大化窗口  
		//driver.manage().window().maximize();  
		startSioeye();
	}

	/** 
	 * @Title: initChromeDriver 
	 * @Date:2017年8月22日
	 * @author qiang.zhang@ck-telecom.com
	 * @Description: http://chromedriver.storage.googleapis.com/2.31/notes.txt    注意版本匹配
	 * @return void    返回类型 
	 */
	private static void initChromeDriver(){
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("chrome.exe");
		
		Log.info("init chrome browser");
		String driver_path = System.getProperty("user.dir")+"\\driver\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driver_path);    
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		o.addArguments("download.default_directory","E:\\Goluk");
		o.setBinary(System.getProperty("user.dir")+"\\browser\\chrome\\chrome.exe");
		//初始化一个chrome浏览器实例，实例名称叫driver    
		driver = new ChromeDriver(o);
		startSioeye();
	}

	/**
	 *建议 IE11
	 *Internet选项->安全; 把Internet站点，
	 *本地Intrant,受信任站点 三个地方的安全界面都设置相同等级
	 *例如都设置中；
	 */
	private static  void initIE(){
		Log.info("init ie browser");
		System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");    
		//初始化一个IE浏览器实例，实例名称叫driver    
		WebDriver driver = new  InternetExplorerDriver();   
		//最大化窗口    
		driver.manage().window().maximize();    
		//设置隐性等待时间    
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);    
		// get()打开一个站点    
		driver.get("https://www.baidu.com");    
		//getTitle()获取当前页面title的值    
		System.out.println("当前打开页面的标题是： "+ driver.getTitle());    
		//关闭并退出浏览器    
		driver.quit();    
	}

	/**
	 * //关闭并退出浏览器
	 */
	public static void quiteSelenium(){
		try {
			Log.info("quit  browser");
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
