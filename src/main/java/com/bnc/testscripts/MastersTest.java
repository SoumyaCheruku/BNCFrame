package com.bnc.testscripts;

import org.testng.annotations.Test;

import com.bnc.lib.MastersGeneral;

public class MastersTest {
	
	@Test
	public void masters(){
		
		MastersGeneral mg = new MastersGeneral();
		mg.login();
		
	}

}
