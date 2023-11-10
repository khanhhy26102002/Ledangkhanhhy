//package Assignment;
//
//import driver.driverFactory;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pom.Register;
//import pom.WishListShare;
//
//import static org.junit.Assert.assertEquals;
//
//public class TestCase5 {
//    @Test
//    public void TestCase05() {
//        String firstname = "A", middlename = "B", lastname = "C", email = "khanh145@gmail.com",
//                password = "000000";
//
//        // Step 1. Go to http://live.techpanda.org/
//        WebDriver driver = driverFactory.getChromeDriver();
//        driver.get("http://live.techpanda.org/");
//
//        // Step 2. Click on my account link
//        WebElement accountlink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']"));
//        accountlink.click(); // Webpage is now http://live.techpanda.org/index.php/customer/account/login/
//
//        // Step 3. Click Create an Account link
//        WebElement createButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
//        createButton.click();
//
//        // Step 4. Fill New User information excluding the registered Email ID, then click Register
//        Register register = new Register(driver);
//        driver = register.signIn(firstname, middlename, lastname, email, password, password);
//        driver.findElement(By.className("first"));
//        String newURL = driver.getCurrentUrl();
//
//        // Step 5. Verify Registration is done. Expected account registration done.
//        assertEquals("http://live.techpanda.org/index.php/customer/account/index/",newURL);
//
//        // Step 6. Go to TV menu
//        WebElement MOBILElink = driver.findElement(By.className("last"));
//        MOBILElink.click(); // Webpage is now http://live.techpanda.org/index.php/tv.html
//
//        // Step 7. Add product in your wish list - use product - LG LCD
//        WebElement lg = driver.findElement(By.xpath("//div[h2/a/@title='LG LCD']//div[@class='actions']//ul[@class='add-to-links']//li[1]//a[1]"));
//        lg.click();
//
//        // Step 8. Click SHARE WISHLIST
//        WebElement shareWish = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
//        shareWish.click();
//
//        // Step 9. In next page enter Email and a message and click SHARE WISHLIST
//        WishListShare wishlistShare = new WishListShare(driver);
//        driver = wishlistShare.wishlist("kk@gmail.com,cc@gmail.com", "Whoops...");
//        WebElement notification = driver.findElement(By.xpath("//li[@class='success-msg']//ul[1]//li[1]//span"));
//        String successMessage = notification.getText();
//
//        // Step 10. Check wishlist is shared. Expected wishlist shared successfully
//        assertEquals("Your Wishlist has been shared.", successMessage);
//    }
//}
package Assignment;

import driver.driverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Register;
import pom.WishListShare;

import static org.junit.Assert.assertEquals;

public class TestCase5 {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
    }

    @Test
    public void testWishlistShare() {
        // Step 2: Click on my account link
        WebElement accountLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']"));
        accountLink.click(); // Webpage is now http://live.techpanda.org/index.php/customer/account/login/

        // Step 3: Click Create an Account link
        WebElement createButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createButton.click();

        // Step 4: Fill New User information excluding the registered Email ID, then click Register
        Register register = new Register(driver);
        driver = register.signIn("A", "B", "C", "khanh245@gmail.com", "000000", "000000");
        String newURL = driver.getCurrentUrl();

        // Step 5: Verify Registration is done. Expected account registration done.
        assertEquals("http://live.techpanda.org/index.php/customer/account/index/", newURL);

        // Step 6: Go to TV menu
        WebElement tvLink = driver.findElement(By.className("last"));
        tvLink.click(); // Webpage is now http://live.techpanda.org/index.php/tv.html

        // Step 7: Add product in your wish list - use product - LG LCD
        WebElement lg = driver.findElement(By.xpath("//div[h2/a/@title='LG LCD']//div[@class='actions']//ul[@class='add-to-links']//li[1]//a[1]"));
        lg.click();

        // Step 8: Click SHARE WISHLIST
        WebElement shareWish = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
        shareWish.click();

        // Step 9: In the next page enter Email and a message and click SHARE WISHLIST
        WishListShare wishlistShare = new WishListShare(driver);
        driver = wishlistShare.wishlist("kk@gmail.com,cc@gmail.com", "Whoops...");
        WebElement notification = driver.findElement(By.xpath("//li[@class='success-msg']//ul[1]//li[1]//span"));
        String successMessage = notification.getText();

        // Step 10: Check wishlist is shared. Expected wishlist shared successfully
        assertEquals("Your Wishlist has been shared.", successMessage);
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
