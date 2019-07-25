package org.jiahuan.Case;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;

public class HelloTest{

	
	@TmsLink("5")//用例编号
	@Issue("555")//bug编号
	@Severity(SeverityLevel.NORMAL)//优先级
	@Description("测试一个流程，用作回归冒烟测试")
	@Test
	public void testName() throws Exception {
		System.out.println("运行完成");
		logCaseStep();
		exceptedResult();
	}
	
	
	/**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "操作步骤如下：")
	public String logCaseStep(){
		String step = "1、打开浏览器  2、输入百度地址";
		return step;
	}

	/**
	 * 打印测试步骤
	 * @param tr
	 */
	@Attachment(value = "期望结果如下：")
	public String exceptedResult(){
		String result = "显示查询结果";
		return result;
	}
}
