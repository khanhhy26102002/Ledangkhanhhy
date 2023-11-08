package Assignment;

import driver.driverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.CartPage;

import static org.junit.Assert.assertTrue;

public class TestCase9 {
    @Test
    public void TestCase9(){
        //Step 1:  Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
       driver.get("http://live.techpanda.org/");
        CartPage champion = new CartPage(driver);
        //Step 2: Go to Mobile and add IPHONE to cart
        WebElement title = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        title.click();
        WebElement click = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]"));
        click.click();
        //Step 3: Enter Coupon Code
        WebElement enter = driver.findElement(By.id("coupon_code"));
        enter.click();
        //Step 4: Verify the discount generated
        String update = "GURU50";
//        champion.champion(update);
        assertTrue(champion.champion(update));
    }
}
