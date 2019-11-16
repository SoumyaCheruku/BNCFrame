package com.bnc.testscripts;

import org.testng.annotations.Test;

import com.bnc.lib.Genral;

public class ReservationTest {
	
	@Test
	public void resrvation() throws InterruptedException{
		
		Genral g = new Genral();
		
		g.login();
		
		Thread.sleep(1000);
		
		g.addReservation();
		
		Thread.sleep(1000);
		
		g.reservationEdit();
		
		Thread.sleep(1000);
		
		g.fpAndChallans();		
		
		Thread.sleep(1000);
		
		g.proformaGeneration();
		
		/*Thread.sleep(1000);
		
		g.reservationIdFillter();
		
		Thread.sleep(1000);
		
		g.reservationSearch();
		
		Thread.sleep(1000);
		
		g.deleteReservation();
		
		Thread.sleep(1000);*/
		
		g.closeBrowser();
		
		
		
	}

}
