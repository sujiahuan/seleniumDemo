package org.jiahuan.tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestWrod {

	@Test
	public void testName() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://183.6.114.72:30000/#/");
		driver.findElementByCssSelector("input[placeholder='请输入您的账号']").sendKeys("admin");
		driver.findElementByCssSelector("input[placeholder='请输入密码']").sendKeys("admin123");
		driver.findElementByCssSelector("button[class|=el]").click();
		WebElement select = driver.findElementByXPath("//*[@id=\"app\"]/div/div[2]/div[2]/section/div/div[1]/div[1]/div[1]/div/div/input");
		
	}
}
