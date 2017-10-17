package cn.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import cn.bean.FollowBean;
import cn.page.AccountPage;
import cn.page.WatchPage;
import model.VP;
import model.WaitCondition;

public class WatchCase extends VP{

	@BeforeMethod
	public void BeforeMethod(){
		initialize("chrome","tyokyo@126.com","1234567890");
		startSioeye();		
		AccountPage.loginAccount();
	}
	/** 
	* @Title: addRecommandFollow 
	* @Date:2017年10月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 添加推荐关注
	*/
	@Test
	public void addRecommandFollow(){
		WaitCondition.waitElementToBeClickable(WatchPage.userAddFirstRecommandFollow, 10);
		String id = WatchPage.getFirstRecommandFollowId();
		WatchPage.clickFirstRecommandFollowbtn();
		WatchPage.clickUserFollow();
		List<FollowBean> infos = WatchPage.getAllFollowInfo();
		boolean actual = false;
		for (FollowBean info : infos) {
			if (id.equals(info.getSioeyeid())) {
				actual=true;
				break;
			}
		}
		Assert.assertEquals(actual, true,"follow success");
	}
	/** 
	* @Title: followDel 
	* @Date:2017年10月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 取消关注
	*/
	@Test
	public void followDel(){
		WatchPage.clickUserFollow();
		WebElement first = WatchPage.getFirstFollow();
		String id = first.findElement(By.className("follow-id")).getText().replaceAll("SioeyeID:", "").trim();
		clickElement(first.findElement(By.cssSelector(".follow-btn")));
		wait(5);
		List<FollowBean> infos = WatchPage.getAllFollowInfo();
		boolean actual = false;
		for (FollowBean info : infos) {
			if (id.equals(info.getSioeyeid())) {
				actual=true;
				break;
			}
		}
		Assert.assertEquals(actual, false,"del follow success");
	}
	/** 
	* @Title: fansAddFollow 
	* @Date:2017年10月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 添加粉丝关注
	*/
	@Test 
	public void fansAddFollow(){
		WatchPage.clickUserFans();
		WebElement first = WatchPage.getFansElement(true);
		String id = first.findElement(By.className("follow-id")).getText().replaceAll("SioeyeID:", "").trim();
		clickElement(first.findElement(By.cssSelector(".follow-btn")));
		wait(5);
		List<FollowBean> infos = WatchPage.getAllFollowInfo();
		boolean actual = false;
		for (FollowBean info : infos) {
			if (id.equals(info.getSioeyeid())) {
				if (info.getFollow().equals("unfollow")) {
					actual=true;
				}
				break;
			}
		}
		Assert.assertEquals(actual, true,"fans add follow success");
	}
	/** 
	* @Title: fansDelFollow 
	* @Date:2017年10月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 删除粉丝
	*/
	@Test
	public void fansDelFollow(){
		WatchPage.clickUserFans();
		WebElement first = WatchPage.getFansElement(false);
		String id = first.findElement(By.className("follow-id")).getText().replaceAll("SioeyeID:", "").trim();
		clickElement(first.findElement(By.cssSelector(".follow-btn")));
		wait(5);
		List<FollowBean> infos = WatchPage.getAllFollowInfo();
		boolean actual = false;
		for (FollowBean info : infos) {
			if (id.equals(info.getSioeyeid())) {
				if (info.getFollow().equals("follow")) {
					actual=true;
				}
				break;
			}
		}
		Assert.assertEquals(actual, true,"fans del follow success");
	}
	/** 
	* @Title: videoDelete 
	* @Date:2017年10月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 删除视频
	*/
	@Test
	public void videoDelete(){
		WatchPage.clickUserVideo();
		WebElement videoElement=WatchPage.getVideoElement();
		String url = WatchPage.getVideosrc(videoElement);
		WatchPage.clickDeleteVideo(videoElement);
		WaitCondition.waitPresenceOfElementLocated(By.className("confirm-btn"), 10);
        WaitCondition.waitElementToBeClickable(By.xpath("//div[@class='confirm-btn']//button[1]"), 10).click();
        WaitCondition.waitElementToBeClickable(By.className("app-content-right"), 10);
        wait(10);
        List<String> times = WatchPage.getAllVideosrc();
       Assert.assertEquals( times.contains(url), false,"delete success-"+url);
	}
	/** 
	* @Title: videoDownLoad 
	* @Date:2017年10月13日
	* @author qiang.zhang@ck-telecom.com
	* @Description: 下载视频
	*/
	@Test
	public void videoDownLoad(){
		WatchPage.clickUserVideo();
		WebElement videoElement=WatchPage.getVideoElement();
		String filename = WatchPage.getVideoFilename(videoElement);
		WatchPage.clickDownloadVideo(videoElement);
		boolean actival = waitFileDownload(filename+".mp4", 120);
		 Assert.assertEquals( actival, true,"download success-"+filename);
	}
	@AfterMethod
	public void AfterMethod(){
		quiteSelenium();
	}
}
