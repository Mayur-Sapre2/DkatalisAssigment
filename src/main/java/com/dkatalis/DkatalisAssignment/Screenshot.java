package com.dkatalis.DkatalisAssignment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Screenshot {
		static WebDriver driver;
		
		public static String timestamp() {
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}
		
		public static void screenShot() throws IOException, InterruptedException
		{
		    File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		    File dest= new File("/home/gslab/Downloads/AvocadoAutomations/Screenshots_"+timestamp()+".png");
		    FileUtils.copyFile(scr, dest);
		}
		
		
		
		public static String takeScreenShot(String aPath) {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(aPath));
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
			return aPath;
		}
		
	}

