package org.jiahuan.Case;

import org.jiahuan.page.HomePage;
import org.jiahuan.page.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.jiahuan.tools.*;

@Listeners(ZTestReport.class)
public class LoginTest {

	private ChromeDriver driver;
	

	@Test(description = "登录")
	public void testLogin() throws Exception {
			driver=new ChromeDriver();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.openLoginPage();
			loginPage.sendUserName("user");
			loginPage.sendPassword("123456");
			String url = driver.getCurrentUrl();
			while(url.equals(driver.getCurrentUrl())) {
				loginPage.sendVerificationCode();
				loginPage.clickLoginButton();
				Thread.sleep(2000);
			}
			
	}
	
	@Test(description = "登录后的操作")
	public void testName() throws Exception {
//		testLogin();
		System.out.println("打印");
	}

	@Test(description = "登录后的操作1")
	public void testName1() throws Exception {
//		testLogin();
		System.out.println("打印");
	}
	@AfterMethod
	public void end() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
