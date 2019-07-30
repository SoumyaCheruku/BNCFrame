package com.bnc.testscripts;

import org.testng.annotations.Test;

import com.bnc.lib.Genral;

public class QuickReservationTest {
	
	@Test
	public void quikResWithExixtingCompany() throws InterruptedException{
		
		Genral g = new Genral();
		
		g.login();
		
		Thread.sleep(1000);
		
		g.quikResrvationWithExistingCompany();
		
		Thread.sleep(1000);
		
		g.quickReservationWithnewCompany();
		
		Thread.sleep(1000);
		
		g.filterInQuickRes();
		
		Thread.sleep(1000);
		
		g.searchInQuickRes();
		
		Thread.sleep(1000);
		
		g.editQuickReservation();
		
		Thread.sleep(1000);
		
		g.deleteQuickReservation();
		
		Thread.sleep(1000);		
		
		g.closeBrowser();
		

		
	}

}
