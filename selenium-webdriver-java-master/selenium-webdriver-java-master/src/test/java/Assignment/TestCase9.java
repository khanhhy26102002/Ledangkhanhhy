//package Assignment;
//
//import driver.driverFactory;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import pom.CartPage;
//
//import static org.junit.Assert.assertTrue;
//
//public class TestCase9 {
//    @Test
//    public void TestCase9(){
//        //Step 1:  Go to http://live.techpanda.org/
//        WebDriver driver = driverFactory.getChromeDriver();
//       driver.get("http://live.techpanda.org/");
//        CartPage champion = new CartPage(driver);
//        //Step 2: Go to Mobile and add IPHONE to cart
//        WebElement title = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
//        title.click();
//        WebElement click = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]"));
//        click.click();
//        //Step 3: Enter Coupon Code
//        WebElement enter = driver.findElement(By.id("coupon_code"));
//        enter.click();
//        //Step 4: Verify the discount generated
//        String update = "GURU50";
////        champion.champion(update);
//        assertTrue(champion.champion(update));
//    }
////}
package Assignment;

import driver.driverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.CartPage;

import static org.junit.Assert.assertTrue;

public class TestCase9 {
    private WebDriver driver;
    private CartPage cartPage;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        cartPage = new CartPage(driver);
        driver.get("http://live.techpanda.org/");
    }

    @Test
    public void testApplyCouponCode() {
        // Step 2: Go to Mobile and add IPHONE to cart
        WebElement mobileLink = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
        mobileLink.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]"));
        addToCartButton.click();

        // Step 3: Enter Coupon Code
        WebElement couponCodeInput = driver.findElement(By.id("coupon_code"));
        couponCodeInput.click();

        // Step 4: Verify the discount generated
        String couponCode = "GURU50";
        assertTrue(cartPage.champion(couponCode));
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
