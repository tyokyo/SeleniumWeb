package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

public class BaiduTest {
    public static void main(String[] args) {
    	String driver_path = System.getProperty("user.dir")+"\\driver\\firefox\\64\\geckodriver.exe";
		System.out.println(driver_path);
		System.setProperty("webdriver.gecko.driver", driver_path);
		
        WebDriver driver = new FirefoxDriver();
        //最大化窗口  
  		driver.manage().window().maximize(); 
        driver.get("https://www.baidu.com/");
     
        driver.findElement(By.id("kw")).sendKeys("selenium java");
        driver.findElement(By.id("su")).click();
        driver.quit();
    }

}