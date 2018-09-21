package Testing_Packing;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import au.com.bytecode.opencsv.CSVReader;

public class GeminidLogin {

	public static void main(String[] args) throws Exception {
		//provide csv file path.(here it isinthe same folder of the project.
		String CSV_PATH = "test.csv";  
		WebDriver driver;
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
		driver.get("http://www.geminidsystems.com/home");
		CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
		String[] r;
		//while loop will be executed till the last line In CSV.
		while((r = reader.readNext()) !=null ) 
		{
			String login = r[0];
			String production = r[1];
			String unpath = r[2];
			String pwpath = r[3];
			String submit = r[4];
			String un = r[5];
			String pw = r[6];
			driver.findElement(By.xpath(login)).click();
			driver.findElement(By.xpath(production)).click();
			driver.findElement(By.xpath(unpath)).sendKeys(un);
			driver.findElement(By.xpath(pwpath)).sendKeys(pw);
			driver.findElement(By.xpath(submit)).click();
		}
	}

}
