package week5day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Monsoon {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        // Launch Chrome browser
        ChromeDriver driver = new ChromeDriver();
        
        // Open Monsoon website
        driver.get("https://www.monsoon.co.uk/");
        
        // Maximize browser window
        driver.manage().window().maximize();
        
        // Set implicit wait for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        // Accept cookies
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(5000); // Wait to ensure popup disappears
        
        // Hover over "Women" menu
        WebElement women = driver.findElement(By.xpath("//span[text()='Women']"));
        Actions act = new Actions(driver);
        act.moveToElement(women).pause(3000).perform();
        
        // Click on "Maxi" category
        driver.findElement(By.xpath("//a[contains(text(), 'Maxi')]")).click();
        
        // Count number of dresses displayed
        List<WebElement> NoOfDresses = driver.findElements(By.xpath("//span[@class='b-price__sales ']"));
        System.out.println(NoOfDresses.size());
       
        // Sort dresses by "Price: Low to High"
        driver.findElement(By.xpath("//div[contains(text(),'Sort')]")).click();
        driver.findElement(By.xpath("//button[@data-sorting-rule='price-low-to-high']")).click();
        
        // Open price filter
        driver.findElement(By.xpath("//div[@aria-label='Price']")).click();
        
        // Move minimum slider
        WebElement minslider = driver.findElement(By.xpath("(//div[@class='noUi-touch-area'])[1]"));
        act.clickAndHold(minslider)
           .moveByOffset(10, 0)
           .release()
           .perform();
        
        // Move maximum slider
        WebElement maxslider = driver.findElement(By.xpath("(//div[@class='noUi-touch-area'])[2]"));
        act.clickAndHold(maxslider)
           .moveByOffset(-140, 0)
           .release()
           .perform();
        
        // Apply the price filter
        driver.findElement(By.xpath("//button[@class='b-button__primary b-slider__button h-block p-0 js-refinements-price-apply']")).click();
        
        // Filter by colour "Green"
        driver.findElement(By.xpath("//div[contains(text(),'Colour')]")).click();
        driver.findElement(By.xpath("//button[@data-component-description='Colour: Green']")).click();
        Thread.sleep(5000); // Wait for filter to apply
        
        // Hover over a specific dress image
        WebElement img = driver.findElement(By.xpath("//img[@alt='Odelle Floral Embroidered Midi Dress, Green (KHAKI), large']"));
        act.moveToElement(img).perform();
        
        // Select size 16
        driver.findElement(By.xpath("(//button[contains(text(),'16')])[3]")).click();
        Thread.sleep(5000); // Wait for selection
        
        // Add to bag
        driver.findElement(By.xpath("//span[@class='b-utility__text b-utility__text-bag']")).click();
        
        // View bag and checkout
        driver.findElement(By.xpath("//a[@data-btn-title='View Bag & Checkout']")).click();
        
        // Get and print total price
        WebElement TotalPrice = driver.findElement(By.xpath("(//div[contains(@class,'b-totals__total-value')])[2]"));
        System.out.println("Total Price: " + TotalPrice.getText());
        
        // Take screenshot of checkout page
       
        File src = driver.getScreenshotAs(OutputType.FILE); 
        File dest = new File("./snaps/checkout.png"); 
        FileUtils.copyFile(src, dest);
        
        // Close browser
        driver.quit();
    }
}