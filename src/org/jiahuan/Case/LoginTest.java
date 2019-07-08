package org.jiahuan.Case;

import org.jiahuan.page.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Listeners(ZTestReport.class)
public class LoginTest {

	private ChromeDriver driver;
	
	@Test
	public void testName() throws Exception {
		System.out.println(System.getProperty("user.dir"));
	}

	@Ignore
	@Test(description = "登录")
	public void testLogin() throws Exception {
		System.out.println(System.getProperty("user.dir"));
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

	@AfterMethod
	public void end() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
