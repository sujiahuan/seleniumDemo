package org.jiahuan.Case;

import org.jiahuan.page.HomePage;
import org.jiahuan.page.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.jiahuan.tools.*;

//@Listeners(ZTestReport.class)
public class TestDemo {

	private ChromeDriver driver;
	

	@Test(invocationCount = 2, threadPoolSize = 2)
	public void testName() throws Exception {
		//new一个类对象，代表每个人的身份
		TestDemo demo = new TestDemo();
		try {
			// 创建一个游览器对象
			demo.driver = new ChromeDriver();
			// 创建登录页对象
			LoginPage loginPage = new LoginPage(demo.driver);
			// 打开登录页
			loginPage.openLoginPage();
			// 输入账号
			loginPage.sendUserName("admin");
			// 输入密码
			loginPage.sendPassword("boconadmin");
			// 点击登录
			loginPage.clickLoginButton();
			// 创建对象
			HomePage homePage = new HomePage(demo.driver);
			// 收起侧边图
			homePage.clickPackUp();
			// 点击总数
			homePage.clickSum();
			// 点击在线
			homePage.clickOnLine();
			// 点击离线
			homePage.clickOffLine();
			// 点击超标
			homePage.clickOverproof();
			// 点击故障
			homePage.clickFault();
			// 选择排放类型
			homePage.selectDischargeType("水类");
			// 选择监控级别
			homePage.selectMonitoringLevel("市控");
			// 输入站点名称
			homePage.sendSiteName("哈哈哈");
			// 输入MN号
			homePage.sendMNMark("123456");
			// 选择行业类型
			homePage.selectIndustryType("其他行业");
			// 点击查询
			homePage.clickInquiry();
			// 展开侧边图
			homePage.clickUnfold();
		} finally {
			//无论成功与否，都执行关闭浏览器操作
			demo.driver.close();
		}

	}

	@AfterMethod()
	public void end() throws InterruptedException {
		// 强制等待三秒
//		Thread.sleep(3000);
		// 关闭
//		demo.driver.close();
	}
}
