package org.jiahuan.Case;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

import org.jiahuan.page.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Listeners(ZTestReport.class)
public class LoginTest {

	private ChromeDriver driver;
	

	@Test(description = "登录")
	public void testLogin() throws Exception {
		System.out.println(System.getProperty("user.dir"));
			driver=new ChromeDriver();
			LoginPage loginPage = new LoginPage(driver);
			//打开登录界面
			loginPage.openLoginPage();
			//输入账号
			loginPage.sendUserName("admin");
			//输入密码
			loginPage.sendPassword("123456");
			//先执行再判断
			do {
				//输入验证码
				loginPage.sendVerificationCode();
				//点击登录
				loginPage.clickLoginButton();
			//判断验证码错误语句是否出现
			} while (loginPage.existErrorCodeHint());
			//断言是否登录成功
			assertNotEquals(loginPage.getUrl(),driver.getCurrentUrl());
	}
	



	@AfterMethod
	public void endMethod() throws Exception {
		driver.close();
	}
}
