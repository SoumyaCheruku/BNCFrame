package com.bnc.lib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MastersGeneral extends Global {
	
	@BeforeMethod
	//@Test
	public void login() throws InterruptedException {		

		System.setProperty("webdriver.chrome.driver", "//home//sbv6//Downloads//chromedriver");
		driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/span/input")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]/span/input")).sendKeys(password);
																											
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]/button"));
		loginBtn.click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();// um pop up
		
		String BNCURL ="http://staging.app.centerpoint.io/bnc";
		driver.get(BNCURL);
		
		driver.manage().window().maximize();
	}
	
	//verfy add,edit,delete and search
	//@Test(dependsOnMethods="login")//It means if login fail it ignores this test
	@Test(priority=7)
	public void Area() throws InterruptedException{
		
		String areamasterUrl="http://staging.app.centerpoint.io/bnc/masters/areas";
		
		driver.get(areamasterUrl);
		
		Thread.sleep(1000);
		
		WebElement newButton = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();
		
		String areaName ="Kids zone";		
		driver.findElement(By.id("areaName")).sendKeys(areaName);		
		
		driver.findElement(By.id("price")).sendKeys("2000");
		
		driver.findElement(By.id("hsnSacCode")).sendKeys("9996");
		
		driver.findElement(By.id("areaMinPax")).sendKeys("300");
		
		driver.findElement(By.id("areaMaxPax")).sendKeys("500");
		
		WebElement cleanTimeMins = driver.findElement(By.name("cleanTimemins"));
		cleanTimeMins.clear();
		cleanTimeMins.sendKeys("30");
		
		Thread.sleep(1000);
		
		WebElement taxGroup = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/span/div/div/div/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(taxGroup);
		action.click();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemGroup = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/span/div/div/div"));	
		action.moveToElement(itemGroup);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemType = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/span/div/div/div/div[1]"));	
		action.moveToElement(itemType);		
		action.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemsubType = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div/span/div"));	
		action.moveToElement(itemsubType);
		action.click();
		action.sendKeys(Keys.ENTER);
		action.build().perform();		
		
		Thread.sleep(1000);
		
		WebElement seatingTypeTab = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		seatingTypeTab.click();
		
		Thread.sleep(1000);
		
		WebElement addSeatingBtn = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[2]/div/div/div/span/button"));
		addSeatingBtn.click();
		
		Thread.sleep(1000);
		
		WebElement selectSeatingType =driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/span/div/div/div"));		
		action.moveToElement(selectSeatingType);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);				
		
		Thread.sleep(1000);
		
		action.sendKeys(Keys.TAB);
		action.sendKeys("300");// seating min
		
		Thread.sleep(1000);
		
		action.sendKeys(Keys.TAB);
		action.sendKeys("500");// seating min
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement saveSeatingType =driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[5]/span/button[1]"));
		saveSeatingType.click();
		
		Thread.sleep(1000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Area added successfully");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		WebElement areaSearchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[2]/span/i"));
		areaSearchIcon.click();
		
		Thread.sleep(1000);
		
		WebElement enterSearchAreaName = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));
		enterSearchAreaName.sendKeys(areaName);;
		
		Thread.sleep(1000);
		
		WebElement searchBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Search element found successfully");
		
		Thread.sleep(1000);
		
		WebElement editbtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[1]"));
		editbtn.click();
		
		Thread.sleep(1000);
		
		WebElement areaTab = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[1]/div/div/div/div/div[2]"));
		areaTab.click();
		
		WebElement shortname = driver.findElement(By.id("shortName"));
		shortname.sendKeys(areaName);
		shortname.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Area master edited successfully");
		
		Thread.sleep(1000);
		
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[2]"));
		deleteBtn.click();
		
		Thread.sleep(1000);
		
		WebElement deleteConfirm =driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteConfirm.click();
		
		Thread.sleep(1000);		
		
		System.out.println("Area master deleted successfully");
		
	}
	@Test(priority=14)
	public void bank() throws InterruptedException{
		
		String bankURL ="http://staging.app.centerpoint.io/bnc/masters/payment/banks";
		driver.get(bankURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement bankname = driver.findElement(By.id("bankName"));
		String bankName = "BOI";
		bankname.sendKeys(bankName);
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterbankNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterbankNameSearch.sendKeys(bankName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(bankName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();		
		
	}
	
	@Test
	public void blockingType() throws InterruptedException{
		
		String blockintype ="http://staging.app.centerpoint.io/bnc/masters/area/block/types";
		driver.get(blockintype);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement blockingname = driver.findElement(By.id("blockingName"));
		String blockingName = "Maintainance";
		blockingname.sendKeys(blockingName);
		blockingname.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);	
		
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterblockNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterblockNameSearch.sendKeys(blockingName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(blockingName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
		
		Thread.sleep(1000);		
		
	}
	@Test(priority=18)
	public void customer() throws InterruptedException{
		
		String customerURL ="http://staging.app.centerpoint.io/bnc/masters/customers";
		driver.get(customerURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement customerName = driver.findElement(By.id("name"));
		String custname = "AishwaryaBrath";
		customerName.sendKeys(custname);
		customerName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);	
		
		WebElement selectOrg = driver.findElement(By.xpath("//*[@id='CustomerForm']/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/span/div/div/div/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(selectOrg);
		action.click();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement designation = driver.findElement(By.id("designation"));
		designation.sendKeys("Team lead");
		
		Thread.sleep(1000);		
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Somajiguda");
		
		Thread.sleep(1000);

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Hyderabad");
		
		Thread.sleep(1000);

		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("TG");
		
		Thread.sleep(1000);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("AishwaryaBrath@gmail.com");
		
		Thread.sleep(1000);
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("7733488326");
		Thread.sleep(1000);	
		
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterCustomerSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterCustomerSearch.sendKeys(custname);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[7]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);
		
		WebElement editAddress = driver.findElement(By.id("address"));
		editAddress.clear();
		editAddress.sendKeys("Somajiguda Circle");
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[7]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
		
		Thread.sleep(1000);		
	}
	@Test(priority=12)
	public void functionSubFunction() throws InterruptedException{
		
		String functionSubFunctionURL ="http://staging.app.centerpoint.io/bnc/masters/functions";
		driver.get(functionSubFunctionURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement functnName = driver.findElement(By.id("functionName"));
		String functionName = "Reception";
		functnName.sendKeys(functionName);
		
		Thread.sleep(1000);
		
		WebElement subFunctiontab =driver.findElement(By.xpath("//*[@id='FunctionForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		subFunctiontab.click();
		
		Thread.sleep(1000);
		
		WebElement subFunctionbtn =driver.findElement(By.xpath("//*[@id='FunctionForm']/div[1]/div[2]/div[2]/div/div/div/span/button"));
		Actions actions = new Actions(driver);
		actions.moveToElement(subFunctionbtn);
		actions.click();			
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(functionName);// enter sub function name		
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(functionName);//enter sub_function short name	
		actions.build().perform();
		Thread.sleep(1000);
		
		WebElement saveSubFunctn =driver.findElement(By.xpath("//*[@id='FunctionForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[5]/span/button[1]"));
		saveSubFunctn.click();
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[2]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterfunctnNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterfunctnNameSearch.sendKeys(functionName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(functionName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();		

	}
	
	@Test(priority=11)
	public void industryType() throws InterruptedException{
		
		String industryTypeURL ="http://staging.app.centerpoint.io/bnc/masters/industrytypes";
		driver.get(industryTypeURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement industryName = driver.findElement(By.id("industryTypeName"));
		String industryTypeName = "Hospitality";
		industryName.sendKeys(industryTypeName);
		industryName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterbankNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterbankNameSearch.sendKeys(industryTypeName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(industryTypeName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();		
		
	}
	
	@Test(priority=16)
	public void invoiceVoidReaon() throws InterruptedException{
		
		String invoiceVoidReaonURL ="http://staging.app.centerpoint.io/bnc/masters/invoice/void/reasons";
		driver.get(invoiceVoidReaonURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement invoiceVoidReaonName = driver.findElement(By.id("reason"));
		String invoiceVoidreaonName = "Wrong Split";
		invoiceVoidReaonName.sendKeys(invoiceVoidreaonName);
		invoiceVoidReaonName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterbankNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterbankNameSearch.sendKeys(invoiceVoidreaonName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(invoiceVoidreaonName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
	}
	
	@Test(priority=4)
	public void itemCategeoryItemGroup() throws InterruptedException{
		
		String itemCategeoryItemGroupURL ="http://staging.app.centerpoint.io/bnc/masters/itemCategory";
		driver.get(itemCategeoryItemGroupURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement categeoryName = driver.findElement(By.id("banquetItemGroupName"));
		String categoryName = "NonVeg";
		categeoryName.sendKeys(categoryName);
		categeoryName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement itemgrouptab =driver.findElement(By.xpath("//*[@id='ItemCategoryForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		itemgrouptab.click();
		
		Thread.sleep(1000);
		
		WebElement itemgroupbtn =driver.findElement(By.xpath("//*[@id='ItemCategoryForm']/div[1]/div[2]/div[2]/div/div/div/span/button"));
		Actions actions = new Actions(driver);
		actions.moveToElement(itemgroupbtn);
		actions.click();			
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(categoryName);// enter item type	
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(categoryName);//enter item short name
		actions.build().perform();
		Thread.sleep(1000);
		
		WebElement saveItemGroup =driver.findElement(By.xpath("//*[@id='ItemCategoryForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[5]/span/button[1]"));
		saveItemGroup.click();
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterItemcatSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterItemcatSearch.sendKeys(categoryName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement itemCategeorytab =driver.findElement(By.xpath("//*[@id='ItemCategoryForm']/div[1]/div[1]/div/div/div/div/div[2]"));
		itemCategeorytab.click();
		
		Thread.sleep(1000);
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(categoryName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
		
	}
	@Test(priority=5)
	public void itemGroupItemSubGroup() throws InterruptedException{
		
		String itemGroupItemSubGroup ="http://staging.app.centerpoint.io/bnc/masters/itemGroup";
		driver.get(itemGroupItemSubGroup);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		
		WebElement groupName = driver.findElement(By.id("banquetItemTypeName"));
		Actions actions = new Actions(driver);
		actions.moveToElement(groupName);		
		String grouppName = "Corn Starters";
		actions.click();
		actions.sendKeys(grouppName);		
		
		Thread.sleep(1000);
		
		WebElement selectItemCat =driver.findElement(By.xpath("//*[@id='ItemGroupForm']/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/div/span/div/div/div/div[1]"));
		actions.moveToElement(selectItemCat);
		actions.click();
		Thread.sleep(1000);		
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemsubgrouptab =driver.findElement(By.xpath("//*[@id='ItemGroupForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		itemsubgrouptab.click();
		
		Thread.sleep(1000);
		
		WebElement itemgroupbtn =driver.findElement(By.xpath("//*[@id='ItemGroupForm']/div[1]/div[2]/div[2]/div/div/div/span/button"));		
		actions.moveToElement(itemgroupbtn);
		actions.click();			
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(grouppName);// enter sub function name		
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(grouppName);//enter sub_function short name	
		actions.build().perform();
		Thread.sleep(1000);
		
		WebElement saveItemSubGroup =driver.findElement(By.xpath("//*[@id='ItemGroupForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[5]/span/button[1]"));
		saveItemSubGroup.click();
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterItemcatSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterItemcatSearch.sendKeys(grouppName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);
		
		WebElement itemGroupTab =driver.findElement(By.xpath("//*[@id='ItemGroupForm']/div[1]/div[1]/div/div/div/div/div[2]"));
		itemGroupTab.click();
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(grouppName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();
		
	}
	@Test(priority=8)
	public void menu() throws InterruptedException{
		
		String menuUrl="http://staging.app.centerpoint.io/bnc/masters/menuitems";
		
		driver.get(menuUrl);
		
		Thread.sleep(1000);
		
		WebElement newButton = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();
		
		String menuName ="momos";		
		driver.findElement(By.id("menuItem")).sendKeys(menuName);		
		
		driver.findElement(By.id("menuItemPrice")).sendKeys("200");
		
		driver.findElement(By.id("hsnSacCode")).sendKeys("9996");
		
		Thread.sleep(1000);
		
		WebElement taxGroup = driver.findElement(By.xpath("//*[@id='MenusForm']/div[1]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/span/div/div/div/div"));
		Actions action = new Actions(driver);
		action.moveToElement(taxGroup);
		action.click();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemGroup = driver.findElement(By.xpath("//*[@id='MenusForm']/div[1]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/span/div/div/div"));	
		action.moveToElement(itemGroup);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemType = driver.findElement(By.xpath("//*[@id='MenusForm']/div[1]/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div/span/div/div/div/div[1]"));	
		action.moveToElement(itemType);		
		action.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemsubType = driver.findElement(By.xpath("//*[@id='MenusForm']/div[1]/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div/span/div/div/div"));	
		action.moveToElement(itemsubType);
		Thread.sleep(1000);
		action.click();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);
		action.build().perform();		
		
		Thread.sleep(1000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement menuSearchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[2]/span/i"));
		menuSearchIcon.click();
		
		Thread.sleep(1000);
		
		WebElement enterSearchAreaName = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));
		enterSearchAreaName.sendKeys(menuName);;
		
		Thread.sleep(1000);
		
		WebElement searchBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Search element found successfully");
		
		Thread.sleep(1000);
		
		WebElement editbtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[1]"));
		editbtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortname = driver.findElement(By.id("shortName"));
		shortname.sendKeys(menuName);
		shortname.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Menu master edited successfully");
		
		Thread.sleep(1000);
		
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[2]"));
		deleteBtn.click();
		
		Thread.sleep(1000);
		
		WebElement deleteConfirm =driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteConfirm.click();
		
		Thread.sleep(1000);		
		
		System.out.println("Menu master deleted successfully");
	
	}
	@Test(priority=9)
	public void menuPackage() throws InterruptedException{
		
		String menuPackageUrl="http://staging.app.centerpoint.io/bnc/masters/menu/packages";
		
		driver.get(menuPackageUrl);
		
		Thread.sleep(1000);
		
		WebElement newButton = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();
		
		String menupackageName ="Snacks";		
		driver.findElement(By.id("packageName")).sendKeys(menupackageName);		
		
		driver.findElement(By.id("price")).sendKeys("200");
		
		driver.findElement(By.id("hsnSacCode")).sendKeys("9996");
		
		Thread.sleep(1000);
		
		WebElement taxGroup = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div/span/div/div/div/div"));
		Actions action = new Actions(driver);
		action.moveToElement(taxGroup);
		action.click();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemGroup = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/span/div/div/div/div[1]"));	
		action.moveToElement(itemGroup);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemType = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/span/div/div/div/div[1]"));	
		action.moveToElement(itemType);		
		action.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemsubType = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[3]/div[2]/div/span/div/div/div"));	
		action.moveToElement(itemsubType);
		Thread.sleep(1000);
		action.click();
		action.click();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(2000);
		
		WebElement menuItemTab = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		menuItemTab.click();
		
		Thread.sleep(1000);
		
		WebElement menuItemBtn = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[2]/div/div/div/span/button[1]"));
		menuItemBtn.click();
		
		Thread.sleep(1000);
		
		WebElement selectmenuItem = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/span/div/div/div/div[1]"));
		action.moveToElement(selectmenuItem);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement menuItemOneSave = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[4]/span/button[1]"));
		menuItemOneSave.click();
		
		Thread.sleep(1000);
		
		WebElement menuItemBtn2ndTime = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[2]/div/div/div/span/button[1]"));
		menuItemBtn2ndTime.click();
		
		Thread.sleep(1000);
		
		WebElement select2ndmenuItem = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]/div/div/div/span/div/div/div/div[1]"));
		action.moveToElement(select2ndmenuItem);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement item2SaveBtn = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[4]/span/button[1]"));
		item2SaveBtn.click();
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement menuSearchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[2]/span/i"));
		menuSearchIcon.click();
		
		Thread.sleep(1000);
		
		WebElement enterSearchAreaName = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));
		enterSearchAreaName.sendKeys(menupackageName);;
		
		Thread.sleep(1000);
		
		WebElement searchBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Search element found successfully");
		
		Thread.sleep(1000);
		
		WebElement editbtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editbtn.click();
		
		Thread.sleep(1000);
		
		WebElement menuPackageTab = driver.findElement(By.xpath("//*[@id='MenuPackagesForm']/div[1]/div[1]/div/div/div/div/div[2]"));
		menuPackageTab.click();
		
		Thread.sleep(1000);
		
		WebElement shortname = driver.findElement(By.id("shortName"));
		shortname.sendKeys(menupackageName);
		shortname.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("menu package master edited successfully");
		
		Thread.sleep(1000);
		
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();
		
		Thread.sleep(1000);
		
		WebElement deleteConfirm =driver.findElement(By.xpath("/html/body/div[9]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteConfirm.click();
		
		Thread.sleep(1000);		
		
		System.out.println("Menu Package master deleted successfully");
		
	}
	@Test(priority=17)
	public void organization() throws InterruptedException{
		
		String OrgURL ="http://staging.app.centerpoint.io/bnc/masters/organization";
		driver.get(OrgURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement orgName = driver.findElement(By.id("name"));
		String organizationname = "Ibacco";
		orgName.sendKeys(organizationname);
		orgName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);	
		
		WebElement industryType = driver.findElement(By.xpath("//*[@id='OrganizationForm']/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/span/div/div/div/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(industryType);
		action.click();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);				
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Somajiguda");
		
		Thread.sleep(1000);

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Hyderabad");
		
		Thread.sleep(1000);

		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("TG");
		
		Thread.sleep(1000);
		
		WebElement pincode = driver.findElement(By.id("pincode"));
		pincode.sendKeys("500018");
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterCustomerSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterCustomerSearch.sendKeys(organizationname);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);
		
		WebElement editAddress = driver.findElement(By.id("address"));
		editAddress.clear();
		editAddress.sendKeys("Somajiguda Circle");
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
		
		Thread.sleep(1000);		
	}
	@Test(priority=15)
	public void paymentGateWay() throws InterruptedException{
		
		String paymentGateWayURL ="http://staging.app.centerpoint.io/bnc/masters/paymentGateway";
		driver.get(paymentGateWayURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement paymentGateWayName = driver.findElement(By.id("cardType"));
		String gateWayname = "Gold";
		paymentGateWayName.sendKeys(gateWayname);
		paymentGateWayName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterbankNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterbankNameSearch.sendKeys(gateWayname);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(gateWayname);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();			
	}
	
	@Test(priority=13)
	public void salesPerson() throws InterruptedException{
		
		String salesPersonURL ="http://staging.app.centerpoint.io/bnc/masters/salesPerson";
		driver.get(salesPersonURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement salesPersonName = driver.findElement(By.id("firstName"));
		String salesPersonFirstName = "Anuitika";
		salesPersonName.sendKeys(salesPersonFirstName);
		salesPersonName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);			
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Anuitika");		
				
		Thread.sleep(1000);
		

		WebElement phone = driver.findElement(By.id("phoneNumber"));
		phone.sendKeys("9935859668");
		
		Thread.sleep(1000);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Anuitika@gmail.com");
		
		Thread.sleep(1000);		
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(2000);		
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterCustomerSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterCustomerSearch.sendKeys(salesPersonFirstName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[7]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);
		
		WebElement phoneNum = driver.findElement(By.id("phoneNumber"));
		phoneNum.clear();
		phoneNum.sendKeys("8844556622");
		phoneNum.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
		
		Thread.sleep(1000);	
	}
	
	@Test(priority=6)
	public void seatingType() throws InterruptedException{
		
		String seatingTypeURL ="http://staging.app.centerpoint.io/bnc/masters/seating";
		driver.get(seatingTypeURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement seatingName = driver.findElement(By.id("seatingType"));
		String seatingTypeName = "Round";
		seatingName.sendKeys(seatingTypeName);
		seatingName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterbankNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterbankNameSearch.sendKeys(seatingTypeName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(seatingTypeName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
	}
	@Test(priority=10)
	public void service() throws InterruptedException{
		
		String serviceUrl="http://staging.app.centerpoint.io/bnc/masters/services";
		
		driver.get(serviceUrl);
		
		Thread.sleep(1000);
		
		WebElement newButton = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();
		
		String serviceName ="Disco lights";		
		driver.findElement(By.id("serviceName")).sendKeys(serviceName);		
		
		driver.findElement(By.id("servicePrice")).sendKeys("200");
		
		driver.findElement(By.id("hsnSacCode")).sendKeys("9996");
		
		Thread.sleep(1000);
		
		WebElement taxGroup = driver.findElement(By.xpath("//*[@id='ServicesForm']/div[1]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/span/div/div/div/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(taxGroup);
		action.click();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemGroup = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div/span/div/div/div/div[1]"));	
		action.moveToElement(itemGroup);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement itemType = driver.findElement(By.xpath("//*[@id='AreasForm']/div[2]/div[2]/div/span/div/div/div/div[1]"));	
		action.moveToElement(itemType);		
		action.click();
		action.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ENTER);//select item sub type
		action.build().perform();				
		
		Thread.sleep(1000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement menuSearchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[2]/span/i"));
		menuSearchIcon.click();
		
		Thread.sleep(1000);
		
		WebElement enterSearchAreaName = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));
		enterSearchAreaName.sendKeys(serviceName);;
		
		Thread.sleep(1000);
		
		WebElement searchBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Search element found successfully");
		
		Thread.sleep(1000);
		
		WebElement editbtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"));
		editbtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortname = driver.findElement(By.id("shortName"));
		shortname.sendKeys(serviceName);
		shortname.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Service master edited successfully");
		
		Thread.sleep(1000);
		
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[2]"));
		deleteBtn.click();
		
		Thread.sleep(1000);
		
		WebElement deleteConfirm =driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteConfirm.click();
		
		Thread.sleep(1000);		
		
		System.out.println("Service master deleted successfully");	
		
	}
	@Test(priority=1)
	public void taxCategeory() throws InterruptedException{
		
		String taxCategeoryURL ="http://staging.app.centerpoint.io/bnc/masters/taxCategory";
		driver.get(taxCategeoryURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement taxCategeoryName = driver.findElement(By.id("taxCategoryName"));
		String CategeoryName = "GST Test";
		taxCategeoryName.sendKeys(CategeoryName);
		taxCategeoryName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterbankNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterbankNameSearch.sendKeys(CategeoryName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(CategeoryName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	

	}
	@Test(priority=2)
	public void taxStructure() throws InterruptedException{
		
		String taxStructureURL ="http://staging.app.centerpoint.io/bnc/masters/taxStructure";
		driver.get(taxStructureURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement taxStructureName = driver.findElement(By.id("taxStructureName"));
		String structureName = "CGST Test5%";
		taxStructureName.sendKeys(structureName);
		taxStructureName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement actualRate =driver.findElement(By.id("taxActualRate"));
		actualRate.sendKeys("5");
		
		Thread.sleep(1000);
		
		WebElement selectTaxCategeory =driver.findElement(By.xpath("//*[@id='TaxStructureForm']/div[1]/div[2]/div/div[2]/div[7]/div[2]/div/span/div/div/div"));
		Actions action = new Actions(driver);
		action.moveToElement(selectTaxCategeory);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterTSNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterTSNameSearch.sendKeys(structureName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(structureName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	

	}
	@Test(priority=3)
	public void taxGroup() throws InterruptedException{
		
		String taxGroupURL ="http://staging.app.centerpoint.io/bnc/masters/taxGroup";
		driver.get(taxGroupURL);
		
		WebElement newBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement taxGroupName = driver.findElement(By.id("taxGroupName"));
		String GroupName = "Check Grouup";
		taxGroupName.sendKeys(GroupName);
		taxGroupName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement taxGruopStructureTab =driver.findElement(By.xpath("//*[@id='TaxGroupForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		taxGruopStructureTab.click();
		
		Thread.sleep(1000);
		
		WebElement addtaxStructure =driver.findElement(By.xpath("//*[@id='TaxGroupForm']/div[1]/div[2]/div[2]/div/div/div/span/button"));
		addtaxStructure.click();
		
		Thread.sleep(1000);
		
		WebElement selectTaxStructure =driver.findElement(By.xpath("//*[@id='TaxGroupForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/span/div/div/div/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(selectTaxStructure);
		action.click();
		
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement saveTaxStructure =driver.findElement(By.xpath("//*[@id='TaxGroupForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[3]/span/button[1]"));
		action.moveToElement(saveTaxStructure);
		action.click();
		action.build().perform();
		
		Thread.sleep(1000);
		
		WebElement saveBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		searchIcon.click();		
		
		Thread.sleep(1000);
		
		WebElement enterTGNameSearch = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));		
		enterTGNameSearch.sendKeys(GroupName);
		
		Thread.sleep(1000);
		
		WebElement searchBtn  =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		WebElement editBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/div/button[1]"));
		editBtn.click();
		
		Thread.sleep(1000);		
		
		WebElement shortName = driver.findElement(By.id("shortName"));		
		shortName.sendKeys(GroupName);
		shortName.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/div/button[2]"));
		deleteBtn.click();

		Thread.sleep(1000);
		
		WebElement deleteconfirm =driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteconfirm.click();	
	}
	@Test(priority=19)
	public void vendor() throws InterruptedException{
		

		String vendorUrl="http://staging.app.centerpoint.io/bnc/masters/vendor";
		
		driver.get(vendorUrl);
		
		Thread.sleep(1000);
		
		WebElement newButton = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();
		
		String vendorName ="UrbanClap";		
		driver.findElement(By.id("vendorName")).sendKeys(vendorName);		
		
		driver.findElement(By.id("price")).sendKeys("2000");
		
		driver.findElement(By.id("contactNumber")).sendKeys("9996544487");
		
		driver.findElement(By.id("vendorDetails")).sendKeys("plumber works");	
		
		
		WebElement serviceTab = driver.findElement(By.xpath("//*[@id='VendorForm']/div[1]/div[1]/div/div/div/div/div[3]"));
		serviceTab.click();
		
		Thread.sleep(1000);
		
		WebElement addServiceBtn = driver.findElement(By.xpath("//*[@id='VendorForm']/div[1]/div[2]/div[2]/div/div/div/span/button"));
		addServiceBtn.click();
		
		Thread.sleep(2000);
		
		WebElement selectService =driver.findElement(By.xpath("//*[@id='VendorForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/span/div/div/div"));		
		Actions action = new Actions(driver);
		action.moveToElement(selectService);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);				
		action.build().perform();
		
		Thread.sleep(1000);
		
		action.sendKeys(Keys.TAB);
		action.sendKeys("300");// service price
		
		Thread.sleep(1000);	
		
		
		WebElement saveService =driver.findElement(By.xpath("//*[@id='VendorForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[4]/span/button[1]"));
		saveService.click();
		
		Thread.sleep(1000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Area added successfully");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		WebElement areaSearchIcon =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/table/thead/tr/th[3]/span/i"));
		areaSearchIcon.click();
		
		Thread.sleep(1000);
		
		WebElement enterSearchAreaName = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/input"));
		enterSearchAreaName.sendKeys(vendorName);;
		
		Thread.sleep(1000);
		
		WebElement searchBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div/div/button[1]"));
		searchBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("Search element found successfully");
		
		Thread.sleep(1000);
		
		WebElement editbtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[7]/div/button"));
		editbtn.click();
		
		Thread.sleep(1000);
		
		WebElement infotab = driver.findElement(By.xpath("//*[@id='VendorForm']/div[1]/div[1]/div/div/div/div/div[2]"));
		infotab.click();
		
		WebElement shortname = driver.findElement(By.id("shortName"));
		shortname.sendKeys(vendorName);
		shortname.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement updateBtn =driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateBtn.click();
		
		Thread.sleep(1000);
		
		System.out.println("vendor master edited successfully");
		
		Thread.sleep(1000);
		
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[2]/table/tbody/tr/td[4]/div/button[2]"));
		deleteBtn.click();
		
		Thread.sleep(1000);
		
		WebElement deleteConfirm =driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/button[2]"));
		deleteConfirm.click();
		
		Thread.sleep(1000);		
		
		System.out.println("service master deleted successfully");
		
	}
	@AfterMethod
	public void quit(){
		driver.close();
	}


}
