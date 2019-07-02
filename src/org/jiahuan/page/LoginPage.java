package org.jiahuan.page;

import java.util.concurrent.TimeUnit;

import org.jiahuan.tools.TestTools;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private String userName;//账号框
	private String password;//密码框
	private String loginButton;//登录按钮
	private String url;//打开的url
	
	String FilePath;//读取的配置文件路径
	
	private ChromeDriver driver;
	
	public LoginPage(ChromeDriver driver) {
		super();

		// 赋予对象值
		this.driver = driver;

		// 读取的定位文件路径
		FilePath = System.getProperty("user.dir")+"/src/org/jiahuan/Data/Login.properties";

		// 调用读取文档value值方法，给所有属性赋予定位值
		this.userName = TestTools.getProperties("userName", FilePath);
		this.password = TestTools.getProperties("password", FilePath);
		this.loginButton = TestTools.getProperties("loginButton", FilePath);
		this.url = TestTools.getProperties("url",FilePath);
	}
	
	/**
	 * 账号输入框
	 * @param value 输入的账号
	 */
	public void sendUserName(String value) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(this.userName).sendKeys(value);
	}
	/**
	 * 密码输入框
	 * @param value 输入密码
	 */
	public void sendPassword(String value) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(this.password))).sendKeys(value);
	}
	/**
	 * 点击登录按钮
	 */
	public void clickLoginButton() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(this.loginButton).click();
	}
	
	/**
	 * 打开登录页
	 */
	public void openLoginPage() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(url);
	}
}
