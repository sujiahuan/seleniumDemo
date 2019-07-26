package org.jiahuan.tools;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Copies;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.google.common.io.Files;

public class TestNGListener extends TestListenerAdapter {

    private static ChromeDriver driver;

    
    public static void setDriver(ChromeDriver driver) {
        TestNGListener.driver = driver;
    }
    
    @Attachment(value = "screen shot",type = "image/png")
	public byte[]  takePhoto(ChromeDriver driver){
		byte[] screenshotAs =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
    
    /**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "操作步骤如下：")
	public String logCaseStep(ITestResult tr){
		String step = "1、打开浏览器  2、输入百度地址";
		return step;
	}

	/**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "期望结果如下：")
	public String exceptedResult(ITestResult tr){
		String result = "显示查询结果";
		return result;
	}

	@Attachment
	
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
    	System.out.println("运行失败啦");
    	takePhoto(driver);
    	logCaseStep(tr);
    	exceptedResult(tr);
    	
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }

}
