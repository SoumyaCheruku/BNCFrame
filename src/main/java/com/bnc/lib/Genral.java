package com.bnc.lib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Genral extends Global {

	@BeforeMethod
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

		String BNCURL = "http://staging.app.centerpoint.io/bnc";
		driver.get(BNCURL);

		System.out.println("Login Successful");

		driver.manage().window().maximize();
	}

	@Test
	public void quikResrvationWithExistingCompany() throws InterruptedException {
		driver.get("http://staging.app.centerpoint.io/bnc/reservations/quickreservation");// navigate
																							// to
																							// quick
																							// reservation

		driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"))
				.click();// click on new

		Actions action = new Actions(driver);
		WebElement salesperson = driver.findElement(By.className("ant-select-selection__placeholder"));// click
																										// on
																										// sales
																										// person
		action.moveToElement(salesperson);
		action.click();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);// select sales person
		action.build().perform();

		Thread.sleep(1000);
		WebElement toggle = driver.findElement(
				By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[8]/div[3]/div/div[2]/div/span/span/span/i"));// click
																														// on
																														// company
																														// toggle
		toggle.click();
		Thread.sleep(1000);

		WebElement company = driver.findElement(
				By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[8]/div[2]/div[2]/div/span/div/div/div/div[1]"));
		action.moveToElement(company);
		action.click();
		action.sendKeys("AIDC");
		action.sendKeys(Keys.TAB);
		action.build().perform();
		Thread.sleep(1000);

		WebElement customer = driver.findElement(
				By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[9]/div[2]/div[2]/div/span/div/div/div/div"));
		action.moveToElement(customer);
		action.click();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.id("minPax")).sendKeys("300");
		driver.findElement(By.id("maxPax")).sendKeys("400");

		Thread.sleep(2000);
		WebElement event = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[16]/div[2]/div/span/span/span"));
		action.moveToElement(event);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_RIGHT);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[2]/div[2]/div[2]/div[1]")).click();// select
																												// 1st
																												// area
		// driver.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[2]/div[2]/div[2]/div[2]")).click();
		driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"))
				.click();
		Thread.sleep(1000);
		System.out.println("Quick Reservation added successfully with existing company");

	}

	// change company name,customer name,phone number before executing the
	// script
	@Test
	public void quickReservationWithnewCompany() throws InterruptedException {

		driver.get("http://staging.app.centerpoint.io/bnc/reservations/quickreservation");// navigate
																							// to
																							// quick
																							// res

		WebElement newButton = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();

		WebElement validUpto = driver.findElement(By.id("validUpto"));
		validUpto.sendKeys("2");

		Actions action = new Actions(driver);
		WebElement salesperson = driver.findElement(By.className("ant-select-selection__placeholder"));// click
																										// on
																										// sales
																										// person
		action.moveToElement(salesperson);
		action.click();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);// select sales person
		action.build().perform();

		Thread.sleep(1000);

		WebElement company = driver.findElement(By.id("companyName"));
		String org = "Burger king";
		company.sendKeys(org);

		WebElement customer = driver.findElement(By.id("contactPersonName"));
		customer.sendKeys("Pankaj");

		WebElement industryType = driver.findElement(
				By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[10]/div/div[2]/div/span/div/div/div/div[1]"));
		action.moveToElement(industryType);
		action.click();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ENTER);
		action.build().perform();

		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Hyderabad");

		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9958411236");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Burger@gmail.com");

		WebElement min = driver.findElement(By.id("minPax"));
		min.sendKeys("300");

		WebElement max = driver.findElement(By.id("maxPax"));
		max.sendKeys("500");

		WebElement event = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[16]/div[2]/div/span/span/span"));
		action.moveToElement(event);
		action.click();
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_RIGHT);
		action.sendKeys(Keys.ENTER);
		action.build().perform();

		WebElement budget = driver.findElement(By.id("budget"));
		budget.sendKeys("80000");

		WebElement refferedBy = driver.findElement(By.id("referedBy"));
		refferedBy.sendKeys("Soumya");

		WebElement refferedDetails = driver.findElement(By.id("referedDetails"));
		refferedDetails.sendKeys("Sales Person");

		WebElement comments = driver.findElement(By.id("callbackDetails"));
		comments.sendKeys("satisfied");

		WebElement firstArea = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[2]/div[2]/div[2]/div[1]"));
		firstArea.click();

		Thread.sleep(1000);

		WebElement secondArea = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[2]/div[2]/div[2]/div[2]"));
		secondArea.click();

		WebElement save = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		save.click();

		Thread.sleep(1000);

		String getorgname = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr[1]/td[7]/div/span[1]"))
				.getText();

		Assert.assertEquals(org, getorgname);

		System.out.println("Quick Reservation added successfully with new company");

	}

	@Test
	public void editQuickReservation() throws InterruptedException {

		driver.get("http://staging.app.centerpoint.io/bnc/reservations/quickreservation");// navigate
																							// to
																							// quick
																							// res

		Thread.sleep(1000);
		WebElement editButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[1]"));
		editButton.click();

		WebElement validUpto = driver.findElement(By.id("validUpto"));
		validUpto.clear();
		validUpto.sendKeys("3");
		validUpto.sendKeys(Keys.TAB);

		WebElement update = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		update.click();

		System.out.println("Quick reservation edited successfully");

	}

	@Test
	public void deleteQuickReservation() throws InterruptedException {

		driver.get("http://staging.app.centerpoint.io/bnc/reservations/quickreservation");// navigate
																							// to
																							// quick
																							// res

		Thread.sleep(1000);

		WebElement deleteButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[2]/div/i"));
		deleteButton.click();

		WebElement reason = driver.findElement(By.id("reason"));
		reason.sendKeys("Not Required");

		WebElement popUpDeletebutton = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div[3]/div/button[2]"));
		popUpDeletebutton.click();

		System.out.println("Reservattion deleted successfully");

	}

	// change reservation id
	@Test
	public void filterInQuickRes() throws InterruptedException {

		driver.get("http://staging.app.centerpoint.io/bnc/reservations/quickreservation");// navigate
																							// to
																							// quick
																							// res

		Thread.sleep(1000);

		WebElement filterIcon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[2]/span/i"));
		filterIcon.click();

		WebElement filterSearch = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/div/div/input"));
		String res_id = "4751370";
		filterSearch.sendKeys(res_id);

		WebElement searchInFilter = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/div/div/div/button[1]"));
		searchInFilter.click();

		String idText = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/td[2]"))
				.getText();

		Assert.assertEquals(res_id, idText);
		System.out.println("Filtered element Found");

		Thread.sleep(1000);

		driver.navigate().refresh();

	}

	// change organization name
	@Test
	public void searchInQuickRes() throws InterruptedException {

		driver.get("http://staging.app.centerpoint.io/bnc/reservations/quickreservation");// navigate
																							// to
																							// quick
																							// res

		Thread.sleep(1000);

		WebElement searchicon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[7]/span/i"));
		searchicon.click();

		WebElement searchTexBox = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/div/div/input"));
		String searchText = "walkin";
		searchTexBox.sendKeys(searchText);

		WebElement searchButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/div/div/button[1]"));
		searchButton.click();

		String resultCompany = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr[1]/td[7]/div/span[1]"))
				.getText();

		Assert.assertEquals(searchText, resultCompany);
		System.out.println("Search found successfully");

	}

	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void addReservation() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(1000);

		WebElement newButton = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]"));
		newButton.click();

		Thread.sleep(1000);

		WebElement organization = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[1]/div/div[1]/div[1]/div/div[2]/div/span/div/div/div"));
		Actions actions = new Actions(driver);
		actions.moveToElement(organization);
		actions.click();
		Thread.sleep(1000);
		actions.sendKeys("Google");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB);
		actions.build().perform();

		Thread.sleep(1000);

		WebElement customer = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[1]/div/div[1]/div[2]/div/div[2]/div/span/div/div/div"));
		customer.click();

		Thread.sleep(1000);

		WebElement selectCust = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/ul/li"));
		selectCust.click();

		Thread.sleep(1000);

		WebElement event = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[1]/div/div[1]/div[3]/div/div[2]/div/span/div/div/div"));
		event.click();

		WebElement selectEvent = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul/li[1]"));
		selectEvent.click();

		Thread.sleep(1000);

		WebElement startDate = driver.findElement(By.xpath("//*[@id='reservationStartDate']/div/input"));
		startDate.click();

		Thread.sleep(1000);

		WebElement selectStartDate = driver.findElement(By.linkText("Now"));
		selectStartDate.click();

		Thread.sleep(1000);

		WebElement endDate = driver.findElement(By.xpath("//*[@id='reservationEndDate']/div/input"));
		endDate.click();

		Thread.sleep(2000);

		WebElement selectEndDate = driver
				.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[2]/div[2]/table/tbody/tr[5]/td[7]/div"));
		selectEndDate.click();

		Thread.sleep(1000);

		WebElement status = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[1]/div/div[3]/div[1]/div/div[2]/div/span/div/div/div"));// click
																														// on
																														// status
		status.click();

		WebElement selectStatus = driver.findElement(By.xpath("/html/body/div[8]/div/div/div/ul/li[1]"));
		selectStatus.click();

		Thread.sleep(1000);

		WebElement salesPerson = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[1]/div/div[3]/div[2]/div/div[2]/div/span/div/div/div"));
		salesPerson.click();

		WebElement selectsalesperson = driver.findElement(By.xpath("/html/body/div[9]/div/div/div/ul/li[3]"));
		selectsalesperson.click();

		WebElement areatab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[3]/span"));
		areatab.click();

		Thread.sleep(1000);

		WebElement addArea = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/button"));
		actions.moveToElement(addArea);
		actions.click();
		actions.build().perform();

		Thread.sleep(1000);

		WebElement selectFirstArea = driver.findElement(By.xpath(
				"/html/body/div[10]/div/div[2]/div/div/div[2]/form/div/div/div[3]/div[1]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/button"));
		selectFirstArea.click();

		Thread.sleep(1000);

		WebElement selectSecondArea = driver.findElement(By.xpath(
				"/html/body/div[10]/div/div[2]/div/div/div[2]/form/div/div/div[3]/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[5]/button"));
		selectSecondArea.click();

		Thread.sleep(1000);

		WebElement closeAreabox = driver.findElement(By.xpath("/html/body/div[10]/div/div[2]/div/div/button"));
		closeAreabox.click();

		Thread.sleep(1000);

		WebElement clickOnPage = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div/div[1]"));
		clickOnPage.click();

		Thread.sleep(1000);

		WebElement saveButton = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]"));
		saveButton.click();

		System.out.println("Reservation added successfully");

		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	// change res id
	@Test
	public void reservationIdFillter() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(1000);

		WebElement filtericon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[2]/span/i"));
		filtericon.click();

		Thread.sleep(1000);

		String resid = "4489219";
		WebElement enterSearchId = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div/div/div/div/input"));
		enterSearchId.sendKeys(resid);

		Thread.sleep(1000);

		WebElement searchicon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div/div/div/div/div/button[1]"));
		searchicon.click();

		Thread.sleep(1000);

		String filteredId = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/td[2]"))
				.getText();
		Assert.assertEquals(resid, filteredId);
		System.out.println("Reservation filtered element found successfully");

	}

	// change organization name
	@Test
	public void reservationSearch() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(1000);

		WebElement searchIcon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[7]/span/i"));
		searchIcon.click();

		Thread.sleep(1000);

		String orgname = "walkin";
		WebElement enterOrgname = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[3]/div/div/div/div/input"));
		enterOrgname.sendKeys(orgname);

		Thread.sleep(1000);

		WebElement searchicon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[3]/div/div/div/div/button[1]"));
		searchicon.click();

		Thread.sleep(1000);

		String searchOrgRes = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/td[7]/div/span[1]"))
				.getText();
		Assert.assertEquals(orgname, searchOrgRes);
		System.out.println("Reservation Search element found successfully");

	}

	@Test
	public void reservationEdit() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(1000);

		WebElement editButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"));
		editButton.click();

		Thread.sleep(2000);

		WebElement areatab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(areatab);
		action.click();
		action.build().perform();

		Thread.sleep(1000);

		WebElement offerprice = driver.findElement(By.name("offerPrice"));
		offerprice.clear();
		offerprice.sendKeys("50000");

		Thread.sleep(1000);

		WebElement selectSecondarea = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/a"));
		selectSecondarea.click();

		Thread.sleep(1000);

		WebElement secondAreaofferprice = driver.findElement(By.name("offerPrice"));
		secondAreaofferprice.clear();
		secondAreaofferprice.sendKeys("30000");

		Thread.sleep(1000);

		Actions actions = new Actions(driver);
		WebElement fpTab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[5]"));
		actions.moveToElement(fpTab);
		actions.click();
		actions.build().perform();

		Thread.sleep(1000);

		WebElement genrateAllFpbtn = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div[1]/div[1]/div/div[2]/button"));

		if (genrateAllFpbtn.isEnabled())
			genrateAllFpbtn.click();

		WebElement updateButton = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updateButton.click();

		System.out.println("Reservation edited successfully");

	}
	@Test
	public void deleteReservation() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(1000);

		WebElement deleteButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[2]/div/i"));
		deleteButton.click();

		WebElement reason = driver.findElement(By.id("reason"));
		reason.sendKeys("Not Required");

		WebElement popUpDeletebutton = driver
				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div[3]/div/button[2]"));
		popUpDeletebutton.click();

		System.out.println("Reservation deleted successfully");

	}

	// Change challan_Number
	@Test
	public void fpAndChallans() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(3000);

		WebElement ongoingradioBtn = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div/label[3]/span[1]/input"));
		ongoingradioBtn.click();

		Thread.sleep(2000);

		/*
		 * List<WebElement> ongoingList = driver.findElements(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"
		 * ));//ongoing list System.out.println("show size" +
		 * ongoingList.size());
		 * 
		 * for (int i = 1; i <= ongoingList.size(); i++) {
		 */

		// WebElement editButton =
		// driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td/div/button[1]"));
		WebElement editButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[1]"));
		editButton.click();

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		WebElement fpTab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[4]"));
		actions.moveToElement(fpTab);
		actions.click();
		actions.build().perform();

		Thread.sleep(1000);

		WebElement genrateAllFpbtn = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[3]/div[1]/div/div/div[1]/div[1]/div/div[2]/button"));

		if (genrateAllFpbtn.isEnabled())
			genrateAllFpbtn.click();

		Thread.sleep(1000);

		WebElement challanTab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[5]"));
		challanTab.click();

		Thread.sleep(1000);

		WebElement areaClickToAddChallan = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]"));
		areaClickToAddChallan.click();

		WebElement challanButton = driver.findElement(By.xpath("//*[@id='challanNumber']/div[2]/div/span/button"));
		challanButton.click();

		Thread.sleep(1000);

		WebElement passChallanNumber = driver.findElement(By.name("challanNumber"));
		actions.moveToElement(passChallanNumber);
		Thread.sleep(1000);
		actions.click();
		actions.sendKeys("johar123");
		actions.build().perform();

		Thread.sleep(1000);

		WebElement saveChallanNumber = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div/div[2]/button[1]"));
		saveChallanNumber.click();

		Thread.sleep(1000);

		WebElement challanCardClick = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/article/span/div"));
		challanCardClick.click();

		Thread.sleep(1000);

		WebElement plusButtonToAddChallanItem = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/button"));
		plusButtonToAddChallanItem.click();

		Thread.sleep(1000);

		WebElement addChallanFirstArea = driver.findElement(By.xpath("(//*[@id='addAreas'])[1]"));
		addChallanFirstArea.click();

		Thread.sleep(1000);

		WebElement addChallanSecondArea = driver.findElement(By.xpath("(//*[@id='addAreas'])[2]"));
		addChallanSecondArea.click();

		Thread.sleep(1000);

		WebElement closeAreaChallanList = driver.findElement(By.className("ant-drawer-close-x"));
		closeAreaChallanList.click();

		Thread.sleep(1000);

		WebElement challanMenutab = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div[3]/span"));
		challanMenutab.click();

		Thread.sleep(1000);

		WebElement menuPlusbutton = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/button"));
		menuPlusbutton.click();

		Thread.sleep(1000);

		WebElement addchallanfirstMenuItem = driver.findElement(By.xpath("(//*[@id='addChallans'])[1]"));
		addchallanfirstMenuItem.click();

		Thread.sleep(1000);

		WebElement addchallanSecondMenuItem = driver.findElement(By.xpath("(//*[@id='addChallans'])[2]"));
		addchallanSecondMenuItem.click();

		Thread.sleep(1000);

		WebElement closeMenuChallanList = driver.findElement(By.className("ant-drawer-close-x"));
		closeMenuChallanList.click();

		Thread.sleep(1000);

		WebElement challanServicetab = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div[4]/span"));
		challanServicetab.click();

		Thread.sleep(1000);

		WebElement servicePlusbutton = driver.findElement(By.xpath(
				"//*[@id='ReservationListForm']/div/div[2]/div[4]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/button"));
		servicePlusbutton.click();

		Thread.sleep(1000);

		WebElement addchallanfirstService = driver.findElement(By.xpath("(//*[@id='addServices'])[1]"));
		addchallanfirstService.click();

		Thread.sleep(1000);

		WebElement addchallanSecondService = driver.findElement(By.xpath("(//*[@id='addServices'])[2]"));
		addchallanSecondService.click();

		Thread.sleep(1000);

		WebElement closeServiceChallanList = driver.findElement(By.className("ant-drawer-close-x"));
		closeServiceChallanList.click();

		Thread.sleep(1000);

		WebElement clickOnpage = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div/div[1]"));
		clickOnpage.click();

		Thread.sleep(1000);

		WebElement updatebutton = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[3]"));
		updatebutton.click();

		System.out.println("Fp and challan Successfull");

		Thread.sleep(1000);

		driver.navigate().refresh();

		Thread.sleep(1000);

		// }

	}

	@Test
	public void proformaGeneration() throws InterruptedException {

		String resListUrl = "http://staging.app.centerpoint.io/bnc/reservations/reservation";
		driver.get(resListUrl);

		Thread.sleep(3000);

		WebElement ongoingradioButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div/label[3]/span[1]/input"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ongoingradioButton);
		actions.click();
		actions.build().perform();

		Thread.sleep(2000);

		/*
		 * List<WebElement> ongoingList = driver.findElements(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"
		 * ));//ongoing list System.out.println("show size" +
		 * ongoingList.size());
		 * 
		 * for (int i = 1; i <= ongoingList.size(); i++) {
		 * 
		 * WebElement editButton = driver.findElement(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr["
		 * +i+"]/td/div/button[1]")); editButton.click();
		 */
		WebElement editButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[1]"));
		editButton.click();

		Thread.sleep(1000);

		WebElement fpTab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[4]/span"));
		actions.moveToElement(fpTab);
		actions.click();
		actions.build().perform();

		Thread.sleep(2000);

		WebElement proformatab = driver
				.findElement(By.xpath("//*[@id='ReservationListForm']/div/div[1]/div[2]/div/div/div/div[6]/span"));
		proformatab.click();

		Thread.sleep(1000);

		WebElement proformaGenerateBtn = driver.findElement(
				By.xpath("//*[@id='ReservationListForm']/div/div[2]/div[5]/div/div/div/div/div[1]/div/button"));
		proformaGenerateBtn.click();

		System.out.println("Proforma Generated Successfully");

		// }
	}

	public void discount() throws InterruptedException {

		String proformaListURL = "http://staging.app.centerpoint.io/bnc/invoices/preview";

		driver.get(proformaListURL);

		Thread.sleep(1000);

		WebElement viewClick = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[1]"));
		viewClick.click();

		Thread.sleep(1000);

		WebElement discountButton = driver.findElement(
				By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/button[1]"));
		discountButton.click();

		Thread.sleep(1000);

		WebElement disMode = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[6]/div/div[1]/div[1]/div[2]/div[1]/div/div[2]/div/span/div/div/div/div"));
		Actions actions = new Actions(driver);
		actions.moveToElement(disMode);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

		Thread.sleep(1000);

		WebElement value = driver.findElement(By.id("discountValue"));
		value.sendKeys("100");

		Thread.sleep(1000);

		WebElement applyToAllButton = driver.findElement(
				By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[6]/div/div[1]/div[2]/button[2]"));
		applyToAllButton.click();

		Thread.sleep(1000);

		WebElement savebutton = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/button[1]"));
		savebutton.click();

		Thread.sleep(1000);

		System.out.println("Discount applied successfully");

	}

	public void generateInvoice() throws InterruptedException {

		String proformaListURL = "http://staging.app.centerpoint.io/bnc/invoices/preview";

		driver.get(proformaListURL);

		Thread.sleep(1000);

		WebElement viewClick = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td/div/button[1]"));
		viewClick.click();

		Thread.sleep(1000);

		WebElement invoiceGenBtn = driver.findElement(
				By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/button"));
		invoiceGenBtn.click();

		Thread.sleep(1000);

		System.out.println("Invoice generated successfully");

	}

	// change org name given in quick res
	public void invoiceSplit() throws InterruptedException {

		String proformaListURL = "http://staging.app.centerpoint.io/bnc/invoices/preview";
		driver.get(proformaListURL);

		Thread.sleep(1000);

		WebElement invoiceradioBtn = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[1]/div/label[2]/span[1]/input"));
		invoiceradioBtn.click();

		Thread.sleep(1000);

		/*
		 * WebElement orgFilter = driver.findElement(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[1]/div[1]/table/thead/tr/th[4]/span/i"
		 * )); orgFilter.click();
		 * 
		 * Thread.sleep(1000);
		 * 
		 * WebElement orgsearch = driver.findElement(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[4]/div/div/div/div/input"
		 * )); orgsearch.click();
		 * 
		 * Thread.sleep(1000);
		 * 
		 * WebElement searchIcon = driver.findElement(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[4]/div/div/div/div/div/button[1]"
		 * )); searchIcon.click();
		 * 
		 * Thread.sleep(1000);
		 * 
		 * WebElement searchField = driver.findElement(By.xpath(
		 * "//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[4]/div/div/div/div/input"
		 * )); searchField.sendKeys("M/s JDA Software");
		 * 
		 * Thread.sleep(1000);
		 */

		WebElement viewIcon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"));
		viewIcon.click();

		Thread.sleep(1000);

		WebElement splitButton = driver.findElement(
				By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div[2]/div[1]/button"));
		splitButton.click();

		Thread.sleep(1000);

		WebElement areaSplitButton = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[7]/div/div/div/div[4]/div/div[2]/div[1]/span[3]/button"));
		areaSplitButton.click();

		Thread.sleep(1000);

		WebElement splitSave = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/button[2]"));
		splitSave.click();

	}

	public void payments() throws InterruptedException {

		String proformaListURL = "http://staging.app.centerpoint.io/bnc/invoices/preview";
		driver.get(proformaListURL);

		Thread.sleep(1000);

		WebElement invoiceradioBtn = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[1]/div/label[2]/span[1]/input"));
		invoiceradioBtn.click();

		Thread.sleep(1000);

		WebElement viewIcon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"));
		viewIcon.click();

		Thread.sleep(1000);

		WebElement paymentsButton = driver.findElement(
				By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div[2]/button[2]"));
		paymentsButton.click();

		Thread.sleep(1000);

		// String getInvoiceNum =
		// driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[4]/div[1]/div/div[3]")).getText();

		// Payment Through card mode
		WebElement cardNumber = driver.findElement(By.id("cardLastDigits"));
		cardNumber.sendKeys("4995");

		Thread.sleep(1000);

		WebElement cardtype = driver.findElement(By.xpath("//*[@id='Card']/div[2]/div[2]/div/span/div/div/div/div"));
		Actions actions = new Actions(driver);
		actions.moveToElement(cardtype);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

		Thread.sleep(1000);

		WebElement cardAmount = driver.findElement(By.xpath("(//*[@id='amount'])[1]"));
		cardAmount.clear();
		cardAmount.sendKeys("1000");

		Thread.sleep(1000);

		WebElement addButton = driver.findElement(By.xpath("//*[@id='Card']/div[4]/button"));
		addButton.click();

		Thread.sleep(1000);

		// Payment through cheque mode
		WebElement selectChequeMode = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[5]/div/div[2]/div/div[2]/div/div[1]/div/div/div/div/div[3]"));
		selectChequeMode.click();

		Thread.sleep(2000);

		WebElement chequeNumber = driver.findElement(By.id("chequeNo"));
		chequeNumber.sendKeys("559663");
		;

		Thread.sleep(1000);

		WebElement selectBank = driver
				.findElement(By.xpath("//*[@id='Cheque']/div[2]/div[2]/div/span/div/div/div/div"));
		actions.moveToElement(selectBank);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

		Thread.sleep(1000);

		WebElement chequeAmount = driver.findElement(By.xpath("(//*[@id='amount'])[2]"));
		chequeAmount.clear();
		chequeAmount.sendKeys("1000");

		Thread.sleep(1000);

		WebElement addButtonCheque = driver.findElement(By.xpath("//*[@id='Cheque']/div[4]/button"));
		addButtonCheque.click();

		Thread.sleep(1000);

		WebElement selectCashMode = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[5]/div/div[2]/div/div[2]/div/div[1]/div/div/div/div/div[4]"));
		selectCashMode.click();

		Thread.sleep(1000);

		WebElement cashAmount = driver.findElement(By.xpath("(//*[@id='amount'])[3]"));
		cashAmount.clear();
		cashAmount.sendKeys("1000");

		WebElement addCashButton = driver.findElement(By.xpath("//*[@id='cash']/div[2]/button"));
		addCashButton.click();

		Thread.sleep(1000);

		WebElement selectBTCMode = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[5]/div/div[2]/div/div[2]/div/div[1]/div/div/div/div/div[6]"));
		selectBTCMode.click();

		Thread.sleep(1000);

		String resOrgName = driver
				.findElement(By
						.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[5]/div/div[1]/div[1]/div/div[4]/div[1]/div[3]"))
				.getText();
		System.out.println(resOrgName);
		WebElement selectorgname = driver
				.findElement(By.xpath("//*[@id='company']/div[1]/div[2]/div/span/div/div/div/div[1]"));
		actions.moveToElement(selectorgname);
		Thread.sleep(1000);
		actions.click();
		actions.sendKeys(resOrgName);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

		Thread.sleep(1000);

		WebElement BTCAdd = driver.findElement(By.xpath("//*[@id='company']/div[3]/button"));
		BTCAdd.click();

		Thread.sleep(2000);

		WebElement payNowbtn = driver
				.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div/button[3]"));
		payNowbtn.click();

		Thread.sleep(2000);

	}

	public void voidInvoice() throws InterruptedException {

		String proformaListURL = "http://staging.app.centerpoint.io/bnc/invoices/preview";
		driver.get(proformaListURL);

		Thread.sleep(1000);

		WebElement invoiceradioBtn = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[1]/div/label[2]/span[1]/input"));
		invoiceradioBtn.click();

		Thread.sleep(1000);

		WebElement viewIcon = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/table/tbody/tr/td/div/button[1]"));
		viewIcon.click();

		Thread.sleep(1000);

		WebElement voidBtn = driver.findElement(By.xpath(
				"//*[@id='app']/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/span/button"));
		voidBtn.click();

		Thread.sleep(1000);

		WebElement selectVoidtype = driver.findElement(By.xpath(
				"/html/body/div[2]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/span/div/div/div/div[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(selectVoidtype);
		actions.click();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

		Thread.sleep(1000);

		WebElement comments = driver.findElement(By.id("comments"));
		comments.sendKeys("Wrong Bill");

		Thread.sleep(1000);

		WebElement tickIcon = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div/div[2]/button[1]"));
		tickIcon.sendKeys("Wrong Bill");

	}

}
