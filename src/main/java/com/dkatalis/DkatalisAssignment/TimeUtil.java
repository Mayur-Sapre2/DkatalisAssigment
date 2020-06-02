package com.dkatalis.DkatalisAssignment;

import java.io.IOException;

public class TimeUtil {

	Setup setupObj = new Setup();
	
	public void waitForSmalltime() throws IOException, InterruptedException {
		
		setupObj.LoadConfigProperty();
		
		String smalltime;
		smalltime = setupObj.config.getProperty("SleepTimeSmall");
		long small = Long.parseLong(smalltime);
		Thread.sleep(small);;
	}
	
	public void waitForMediumtime() throws IOException, InterruptedException {
		
		//setupObj.LoadConfigProperty();
		
		String mediumtime;
		mediumtime = setupObj.config.getProperty("SleepTimeMedium");
		long medium = Long.parseLong(mediumtime);
		Thread.sleep(medium);;
	}
	
	public void waitForLongtime() throws IOException, InterruptedException {
		
		//setupObj.LoadConfigProperty();
		
		String longtime;
		longtime = setupObj.config.getProperty("SleepTimeLarge");
		long longt = Long.parseLong(longtime);
		Thread.sleep(longt);;
	}
	
	public void waitForXlargetime() throws IOException, InterruptedException {
		
		//setupObj.LoadConfigProperty();
		
		String xtime;
		xtime = setupObj.config.getProperty("SleepTimeXlarge");
		long large = Long.parseLong(xtime);
		Thread.sleep(large);;
	}
	
}
