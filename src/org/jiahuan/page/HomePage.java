package org.jiahuan.page;

import java.util.concurrent.TimeUnit;

import org.jiahuan.tools.TestTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Administrator 首页
 */
public class HomePage {

	private String dischargeType;// 排放类型
	private String dischargeTypeValue;//排放类型选项
	private String monitoringLevel;// 监控级别
	private String monitoringLevelValue;//监控级别选项
	private String siteName;// 站点名称
	private String mNMark;// MN号
	private String industryType;// 行业类型
	private String industryTypeValue;// 行业类型选项
	private String inquiry;// 查询
	private String sum;// 总数
	private String onLine;// 在线
	private String offLine;// 离线
	private String overproof;// 超标
	private String fault;// 故障
	private String unfold;//展开
	private String packUp;//收起
	
	private ChromeDriver driver;// 游览器对象

	public HomePage(ChromeDriver driver) {
		super();

		// 赋予对象值
		this.driver = driver;

		// 读取的定位文件路径
		String FilePath = System.getProperty("user.dir") + "/src/org/jiahuan/Data/Home.properties";

		// 给所有属性赋予定位值
		this.dischargeType = TestTools.getProperties("dischargeType", FilePath);
		this.dischargeTypeValue=TestTools.getProperties("dischargeTypeValue", FilePath);
		this.monitoringLevel = TestTools.getProperties("monitoringLevel", FilePath);
		this.monitoringLevelValue=TestTools.getProperties("monitoringLevelValue", FilePath);
		this.siteName = TestTools.getProperties("siteName", FilePath);
		this.mNMark = TestTools.getProperties("mNMark", FilePath);
		this.industryType = TestTools.getProperties("industryType", FilePath);
		this.industryTypeValue=TestTools.getProperties("industryTypeValue", FilePath);
		this.inquiry = TestTools.getProperties("inquiry", FilePath);
		this.sum = TestTools.getProperties("sum", FilePath);
		this.onLine = TestTools.getProperties("onLine", FilePath);
		this.offLine = TestTools.getProperties("offLine", FilePath);
		this.overproof = TestTools.getProperties("overproof", FilePath);
		this.fault = TestTools.getProperties("fault", FilePath);
		this.unfold=TestTools.getProperties("unfold",FilePath);
		this.packUp=TestTools.getProperties("packUp", FilePath);
	}

	/**
	 * 选择排放类型
	 * @param name 输入需选择的名称，支持模糊查询，当有多个时，支取第一个
	 * @throws InterruptedException
	 */
	public void selectDischargeType(String name) throws InterruptedException {
		//创建一个显示等待
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//定位排水类型的选框
		WebElement dischargeClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dischargeType)));
		//进行点击
		dischargeClick.click();
		//获取里面的某一个元素
		WebElement listValue = TestTools.getListValue(driver,monitoringLevelValue , name);
		//进行点击
		listValue.click();
	}
	
	
	/**
	 * 选择监控级别
	 * @param name 输入需选择的名称，支持模糊查询，当有多个时，支取第一个
	 * @throws InterruptedException
	 */
	public void selectMonitoringLevel(String name) throws InterruptedException {
		//创建一个显示等待
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//定位监控级别的选框
		WebElement monitoringLevelClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(monitoringLevel)));
		//进行点击
		monitoringLevelClick.click();
		//获取里面的某一个元素
		WebElement listValue = TestTools.getListValue(driver,monitoringLevelValue , name);
		//进行点击
		listValue.click();
	}
	
	/**
	 * 站点名称输入框
	 * @param value 输入站点名称
	 */
	public void sendSiteName(String value){
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(siteName).sendKeys(value);
	}
	/**
	 * MN号输入框
	 * @param value 输入值
	 */
	public void sendMNMark(String value) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(mNMark).sendKeys(value);
	}
	/**
	 * 行业类型
	 * @param value 输入需选择的名字，支持模糊查询
	 */
	public void selectIndustryType(String value) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByXPath(industryType).click();
		WebElement listValue = TestTools.getListValue(driver, industryTypeValue, value);
		listValue.click();
	}
	/**
	 * 查询按钮
	 */
	public void clickInquiry() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(inquiry).click();
	}
	/**
	 * 总数
	 */
	public void clickSum() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(sum).click();
		
	}
	/**
	 * 在线
	 */
	public void clickOnLine() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(onLine).click();
		
	}
	/**
	 * 离线
	 */
	public void clickOffLine() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(offLine).click();
		
	}
	/**
	 * 超标
	 */
	public void clickOverproof() {		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(overproof).click();
	}
	/**
	 * 故障
	 */
	public void clickFault() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(fault).click();
	}

	/**
	 * 收起
	 */
	public void clickPackUp() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElementByCssSelector(packUp).click();
	}
	
    /**
     * 展开
     */
    public void clickUnfold() {
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	driver.findElementByCssSelector(unfold).click();
	}
}
