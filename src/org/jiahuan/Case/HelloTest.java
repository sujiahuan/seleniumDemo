package org.jiahuan.Case;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class HelloTest{

	@Test
	public void testName() throws Exception {
		LoginTest loginTest = new LoginTest();
		loginTest.testLogin();
		Set<Cookie> cookies = loginTest.driver.manage().getCookies();
		for(Cookie c:cookies) {
			System.out.println(c.toString());
		}
	}
}
