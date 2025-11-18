package week5day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		
		// Launch browser
		ChromeDriver driver = new ChromeDriver();
		
		// Open site
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Locate table body
		WebElement table = driver.findElement(By.xpath("//table[@class='display nowrap dataTable dtr-inline collapsed']/tbody"));
		
		// Get rows
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='display nowrap dataTable dtr-inline collapsed']/tbody/tr"));
		
		// Get columns
		List<WebElement> Column = driver.findElements(By.xpath("//table[@class='display nowrap dataTable dtr-inline collapsed']/thead/tr/th"));
		
		// Print row & column count
		int size = row.size();
		System.out.println(size);
		int ColumnSize = Column.size();
		System.out.println(ColumnSize);
		
		// Get text from specific cell
		String Text = driver.findElement(By.xpath("//table[@class='display nowrap dataTable dtr-inline collapsed']/tbody/tr[5]/td[3]")).getText();
		System.out.println(Text);
		
		// Get all values from first column
		List<WebElement> SingleColumn = driver.findElements(By.xpath("//table[@class='display nowrap dataTable dtr-inline collapsed']/tbody/tr/td[1]"));
		for (WebElement Names : SingleColumn) {
			System.out.println(Names.getText());
		}
		
		// Close browser
		driver.close();
	}
}