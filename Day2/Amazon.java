package week5day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

    public static void main(String[] args) {
        
        // Launch a new Chrome browser instance
        ChromeDriver driver = new ChromeDriver();
        
        // Navigate to Amazon India website
        driver.get("https://www.amazon.in");
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Set implicit wait of 20 seconds for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        // Click on "Continue shopping" button if it appears (pop-up)
        driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
        
        // Locate the search box and enter "oneplus 9 pro"
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
        
        // Click on the search button
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        
        // Locate the price of the first product in the search results
        WebElement FirstProductPrice = driver.findElement(By.xpath("//span[@class='a-price-whole'][1]"));
        System.out.println("First product price: " + FirstProductPrice.getText());
        
        // Locate the customer rating of the first product
        WebElement CustomerRatingofFP = driver.findElement(By.xpath("//a[@aria-label='4,481 ratings']"));
        System.out.println("Customer rating of first product: " + CustomerRatingofFP.getText());
        
        // Click on the first product link to open the product details page
        driver.findElement(By.xpath("//span[text()='JGD PRODUCTS for OnePlus 9 Pro Premium Transparent Hybrid Soft Slim Dust Proof Plastic Back Case Cover with Camera Protection']")).click();
        
        // Get all window handles (main window + product details window)
        Set<String> childWindow = driver.getWindowHandles();
        
        // Convert the set of window handles to a list
        List<String> listWindow = new ArrayList<String>(childWindow);
        
        // Switch to the product details window (second window)
        driver.switchTo().window(listWindow.get(1));
        
        // Click on "Add to Cart" button
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        
        // Locate the subtotal price in the cart
        WebElement SubTotal = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
        System.out.println("Cart subtotal: " + SubTotal.getText());
        
        // Optional: Close the browser
        // driver.quit();
    }
}