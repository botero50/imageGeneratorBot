package org.bots.common;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public static WebDriver initializeDriver() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(publicData.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		getUrl(publicData.ENVIRONMENT_URL);
		return driver;
	}
	
	@AfterSuite(alwaysRun = true)
    public void tearDown(ITestContext  context) {
    	driver.quit();
    }
	
	public static void getUrl(String sUrl)
	{
		driver.get(sUrl);
	}
	
	public String getRandomLinesFromTheFile() throws Exception {

        File file = new File(new File("").getAbsolutePath() + "/src/test/resources/words.txt"); 
        final RandomAccessFile f = new RandomAccessFile(file, "r");
        String prhase="";
        for (int i = 0; i<4; i++)
        {
	        final long randomLocation = (long) (Math.random() * f.length());
	        f.seek(randomLocation);
	        f.readLine();
	        prhase += f.readLine() + " ";;
        }
        
        f.close();
        return prhase;
    }
}