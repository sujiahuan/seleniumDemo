package org.jiahuan.tools;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jiahuan.page.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestWrod {


	private ChromeDriver driver;
	
	@Test
	public void testName1() throws Exception {
		TestWrod testWrod = new TestWrod();
		testWrod.driver=new ChromeDriver();
		LoginPage loginPage = new LoginPage(testWrod.driver);
		loginPage.openLoginPage();
		loginPage.sendVerificationCode();
		testWrod=null;
		loginPage=null;
	}
	
	@Ignore
	@Test
	public void testName() throws Exception {

		//正表达式，获取对象@后面的内容
				String regex="@([\\w]+)";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(this.toString());
				m.find();
				String group = m.group(1);
				
		String property = System.getProperty("user.dir");
		String imgPath=property+"\\pro\\img\\2584b82d.png";
		String txt=property+"\\pro\\txt\\2584b82d";
		String command="tesseract "+imgPath+" "+txt;
		Process exec = Runtime.getRuntime().exec(command);
		InputStream in = exec.getInputStream();
		InputStreamReader reader=new InputStreamReader(in,"utf-8");
		char[] cbuf=new char[1024];
		StringBuffer buff=new StringBuffer();
		while (reader.read(cbuf)!=-1) {
			System.out.println("进来了A");
			buff.append(cbuf);
			System.out.println(buff);
		}
		
		InputStream in1 = exec.getErrorStream();
		InputStreamReader reader1=new InputStreamReader(in1,"UTF-8");
		char[] cbuf1=new char[1024];
		StringBuffer buff1=new StringBuffer();
		while (reader1.read(cbuf1)!=-1) {
			System.out.println("进来了B");
			buff.append(cbuf1);
			System.out.println(buff1);
		}
	}

	
}
