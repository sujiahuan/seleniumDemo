package org.jiahuan.Case;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

import org.jiahuan.page.LoginPage;
import org.jiahuan.tools.TestNGListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;

//@Listeners(ZTestReport.class)
@Listeners(TestNGListener.class)
public class LoginTest {

	public ChromeDriver driver;
	
	@Test(description = "登录")
	public void testLogin() throws Exception {
		System.out.println(System.getProperty("user.dir"));
			this.driver=new ChromeDriver();
			TestNGListener.setDriver(this.driver);
			LoginPage loginPage = new LoginPage(this.driver);
			//打开登录界面
			loginPage.openLoginPage();
			//输入账号
			loginPage.sendUserName("admin");
			assertEquals(true,false);
			//输入密码
			loginPage.sendPassword("123456");
			//先执行再判断
			do {
				//给错误提示休息时间
				Thread.sleep(2000);
				//输入验证码
				loginPage.sendVerificationCode();
				//点击登录
				loginPage.clickLoginButton();
			//判断验证码错误语句是否出现
			} while (loginPage.existErrorCodeHint());
			//断言是否登录成功
			assertNotEquals(loginPage.getUrl(),driver.getCurrentUrl(),"登录失败");
	}
	


	@AfterMethod
	public void endMethod() throws Exception {
		driver.close();
	}
}
