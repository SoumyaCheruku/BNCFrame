package com.bnc.testscripts;

import org.testng.annotations.Test;

import com.bnc.lib.Genral;

public class InvoiceTest {
	
	@Test
	public void invoice() throws InterruptedException{
		
		Genral g = new Genral();
		
		g.login();
		
		Thread.sleep(1000);
		
		g.invoiceSplit();
		
		Thread.sleep(1000);
		
		g.payments();
		
		Thread.sleep(1000);
		
		//g.voidInvoice();
		
		
	}

}
