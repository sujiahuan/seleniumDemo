package org.jiahuan.tools;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTools {
	
	private static ChromeDriver driver;

	/**
	 * 获取文档的定位置
	 * @param filePath 需要读取的文件路径
	 * @param name 需要取值的名称
	 * @return 返回需要取得值
	 */
	public static String getProperties(String name,String filePath) {
		Properties properties = new Properties();
		try (
				InputStream in = new FileInputStream(filePath);
				InputStreamReader reader = new InputStreamReader(in,"utf-8");
			){
			properties.load(reader);
			String value = properties.getProperty(name);
			return value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取失败");
			return null;
		}
	}
	
	
	/**
	 * 返回类似select里面的值
	 * @param driver 游览器对象
	 * @param valueLocationName 选项定位变量名（css定位）
 	 * @param valueName 需要找的值的名称（支持模糊查询，当有多个，只返回第一个）
	 * @return 找到则返回元素，找不到返回null
	 */
	public static WebElement getListValue(ChromeDriver driver,String valueLocationName,String valueName) {
		TestTools.driver=driver;
		System.out.println(valueLocationName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> selectorList = TestTools.driver.findElementsByCssSelector(valueLocationName);
		System.out.println(selectorList.size());
		for (WebElement element : selectorList) {
			System.out.println(element.getText());
			if (element.getText().indexOf(valueName)!=-1) {
				return element;
			}
		}
		System.out.println("没有找到对应的值");
		return null;
		
	}
	
}
