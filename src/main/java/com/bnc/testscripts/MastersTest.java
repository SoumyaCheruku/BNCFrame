package com.bnc.testscripts;

import org.testng.annotations.Test;

import com.bnc.lib.MastersGeneral;

public class MastersTest {
	
	//change area name,customer details,sales person details,tax group name
	@Test
	public void masters() throws InterruptedException{
		
		MastersGeneral mg = new MastersGeneral();
		
		 mg.login();
		
		 mg.Area();
		 
		 Thread.sleep(1000);
		
		 mg.bank();

		 Thread.sleep(1000);		
		
		 mg.blockingType();		 

		 Thread.sleep(1000);		
		
		 mg.customer();
		 
		 Thread.sleep(1000);
		
		 mg.functionSubFunction();
		 
		 Thread.sleep(1000);
		
		 mg.industryType();
		 
		Thread.sleep(1000);
		
		 mg.invoiceVoidReaon();//search not working so can check edit and delete
		 
		 Thread.sleep(1000);
		
		 mg.itemCategeoryItemGroup(); // unable to add group hitting 500
		 
		  Thread.sleep(1000);
		
		 mg.itemGroupItemSubGroup();// edit and delete not working(edit and delete buttons not available)
		 
		 Thread.sleep(1000);
		
		 mg.menu();//delete not working
		 
		 Thread.sleep(1000);
		
		 mg.menuPackage();
		 
		 Thread.sleep(1000);
		
		 mg.organization();
		 
		 Thread.sleep(1000);
		
		 mg.paymentGateWay();
		 
		 Thread.sleep(1000);
		
		 mg.salesPerson();
		 
		 Thread.sleep(1000);
		
		 mg.seatingType();
		 
		 Thread.sleep(1000);
		
		 mg.service();//delete not working
		 
		 Thread.sleep(1000);
		
		 mg.taxCategeory();
		 
		 Thread.sleep(1000);
		
		 mg.taxStructure();
		 
		 Thread.sleep(1000);
		
		 mg.taxGroup();//delete not working
		 
		 Thread.sleep(1000);
		
		 mg.vendor();//edit service select error, delete icon not available
		
	}

}
