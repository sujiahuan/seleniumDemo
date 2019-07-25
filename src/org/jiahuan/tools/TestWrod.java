package org.jiahuan.tools;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiahuan.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestWrod {


	private ChromeDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[1]/div/span")
	WebElement a;
	@Test
	public void testName1() throws Exception {
		driver= new ChromeDriver();
		driver.get("http://192.168.10.155:8087/#/login");
		driver.findElementByXPath("//*[@id=\"app\"]/div/div/form/div[1]/div/div/input").sendKeys("asd");;
		driver.findElementByXPath("//*[@id=\"app\"]/div/div/form/div[2]/div/div[1]/input").sendKeys("00");;
		driver.findElementByXPath("//*[@id=\"app\"]/div/div/form/div[3]/div/div/input").sendKeys("000");;	
		driver.findElementByXPath("//*[@id=\"app\"]/div/div/form/div[5]/div/button").click();
		Thread.sleep(1000);
		System.out.println(a.getText());
	
	}
	
	
}
