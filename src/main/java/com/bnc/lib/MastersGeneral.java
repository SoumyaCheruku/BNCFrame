package com.bnc.lib;

import org.openqa.selenium.chrome.ChromeDriver;

public class MastersGeneral extends Global {
	
	public void login() {		

		System.setProperty("webdriver.chrome.driver", "//home//sbv6//Downloads//chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

}
