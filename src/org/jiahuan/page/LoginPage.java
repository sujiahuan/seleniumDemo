package org.jiahuan.page;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.util.ReaderInputStream;
import org.jiahuan.tools.TestTools;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class LoginPage {

	private String url;// 打开的url
	private String userName;// 账号框
	private String password;// 密码框
	private String loginButton;// 登录按钮
	private String verificationCode;// 验证码框
	private String codeImg;// 验证码图片
	private String errorCodeHint;// 提示错误验证码文案

	String FilePath;// 读取的配置文件路径

	private ChromeDriver driver;

	public LoginPage(ChromeDriver driver) {
		super();

		// 赋予对象值
		this.driver = driver;

		// 读取的定位文件路径
		FilePath = System.getProperty("user.dir") + "/src/org/jiahuan/Data/Login.properties";

		// 调用读取文档value值方法，给所有属性赋予定位值
		this.userName = TestTools.getProperties("userName", FilePath);
		this.password = TestTools.getProperties("password", FilePath);
		this.loginButton = TestTools.getProperties("loginButton", FilePath);
		this.verificationCode = TestTools.getProperties("verificationCode", FilePath);
		this.codeImg = TestTools.getProperties("codeImg", FilePath);
		this.url = TestTools.getProperties("url", FilePath);
		this.errorCodeHint = TestTools.getProperties("errorCodeHint", FilePath);
	}

	/**获取打开的url地址
	 * @return 返回url地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 查找提示错误验证码文案是否存在
	 * 
	 * @return 3秒后，在则true，不在则false
	 */
	public boolean existErrorCodeHint() {
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebElement webElement = driver.findElementByCssSelector(errorCodeHint);
			String text = webElement.getText();
			if(text.equals("验证码不正确")||text.equals("")) {
				System.out.println("True");
				return true;
			}
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("False");
			return false;
		}
	}

	/**
	 * 账号输入框
	 * 
	 * @param value 输入的账号
	 */
	public void sendUserName(String value) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByCssSelector(this.userName).sendKeys(value);
	}

	/**
	 * 密码输入框
	 * 
	 * @param value 输入密码
	 */
	public void sendPassword(String value) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(this.password))).sendKeys(value);
	}

	/**
	 * 输入验证码
	 * 
	 * @param value 输入验证码
	 */
	public void sendVerificationCode(String value) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElementByCssSelector(this.verificationCode);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * 自动输入验证码
	 * 
	 * @throws IOException
	 */
	public void sendVerificationCode() throws IOException {
		saveCodeImg();
		String property = System.getProperty("user.dir");
		String objName = getObjName(this.toString());
		String imgPath = property + "\\pro\\img\\" + objName + ".png";
		String txtPath = property + "\\pro\\txt\\" + objName;

		String command = "tesseract " + imgPath + " " + txtPath;
		runCmd(command);

		InputStream in = new FileInputStream(txtPath + ".txt");
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader buffReader = new BufferedReader(reader);
		String line = buffReader.readLine();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElementByCssSelector(this.verificationCode);
		element.clear();
		element.sendKeys(line);

		File img = new File(imgPath);
		File txt = new File(txtPath + ".txt");
		img.delete();
		txt.delete();
		in.close();
		reader.close();
		buffReader.close();
	}

	/**
	 * 点击验证码图片
	 */
	public void clickCodeImg() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByCssSelector(this.codeImg).click();
	}

	/**
	 * 点击登录按钮
	 */
	public void clickLoginButton() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByCssSelector(this.loginButton).click();
	}

	/**
	 * 打开登录页
	 */
	public void openLoginPage() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	/**
	 * 保存验证码图片
	 * 
	 * @throws IOException
	 */
	private void saveCodeImg() throws IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File screenshotAs = driver.findElementByCssSelector(this.codeImg).getScreenshotAs(OutputType.FILE);

		String property = System.getProperty("user.dir");
		File imagePath = new File(property + "/pro/img/" + getObjName(this.toString()) + ".png");
		Files.copy(screenshotAs, imagePath);
	}

	/**
	 * 获取@后的对象名称
	 * 
	 * @param thisName 传入对象名称，用this.tostring()方法即可
	 * @return 返回对象@后的名称
	 */
	private static String getObjName(String thisName) {
		String regex = "@([\\w]+)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(thisName);
		m.find();
		String group = m.group(1);
		return group;
	}

	/**
	 * 运行cmd
	 * 
	 * @param command cmd命令
	 * @throws IOException
	 */
	private static void runCmd(String command) throws IOException {
		Process exec = Runtime.getRuntime().exec(command);
		InputStream in = exec.getInputStream();
		InputStreamReader reader = new InputStreamReader(in, "utf-8");
		char[] cbuf = new char[1024];
		StringBuffer buff = new StringBuffer();
		while (reader.read(cbuf) != -1) {
			buff.append(cbuf);
			System.out.println(buff);
		}

		InputStream in1 = exec.getErrorStream();
		InputStreamReader reader1 = new InputStreamReader(in1, "UTF-8");
		char[] cbuf1 = new char[1024];
		StringBuffer buff1 = new StringBuffer();
		while (reader1.read(cbuf1) != -1) {
			buff.append(cbuf1);
			System.out.println(buff1);
		}

		in.close();
		reader.close();
		in1.close();
		reader1.close();
	}
}
