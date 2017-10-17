package cn.page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import util.Log;
import model.VP;

public class BroadCastPage extends VP{
	static By follow = By.className("profile-follow");
	
	public static void clickFollow(){
		clickElement(follow);
	}
	public static String getBroadcastSioeyeid(){
		String id = "";
		String url = getDriver().getCurrentUrl();
		String regex = "https://live.sioeye.cn/(.*?)#"; //正则表达式  
		Pattern pattern = Pattern.compile(regex);   
		Matcher m = pattern.matcher(url);  
		while(m.find()){  
		    id=m.group(1);
		    Log.info(id);
		}  
		return id;
	}
}
