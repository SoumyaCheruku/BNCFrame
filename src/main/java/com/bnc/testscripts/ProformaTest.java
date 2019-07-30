package com.bnc.testscripts;

import org.testng.annotations.Test;

import com.bnc.lib.Genral;

public class ProformaTest {
	
	@Test
	public void proforma() throws InterruptedException{
		
		Genral g = new Genral();
		
		g.login();
		
		Thread.sleep(1000);
		
		g.discount();

		Thread.sleep(1000);		
			
		g.generateInvoice();
		
		Thread.sleep(1000);
		
		g.closeBrowser();
		
	}

}
