package com.w2a.utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.w2a.base.TestBase;

public class TestUtil extends TestBase{

	
	public static void screenShotCapture() throws IOException{
		Date d=new Date();
		String screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".JPG";
	File srcFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("F:\\anshul\\NewWorkspaceTest\\DataDrivenFramework\\test-output\\html\\"+screenShotName));
	}
	
}
