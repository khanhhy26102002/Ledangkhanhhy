//package Assignment;
//
//import driver.driverFactory;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import pom.CartPage;
//import pom.Login;
//
//public class TestCase6 {
//    @Test
//    public void TestCase6(){
//        //Step 1: Go to http://live.techpanda.org/
//        WebDriver driver = driverFactory.getChromeDriver();
//        driver.get("http://live.techpanda.org/");
//        //Step 2: Click on my account link
//        WebElement link = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']"));
//        link.click();
//        //Step 3: Login in application using previously created credential
//        String email = "ledang123@gmail.com";
//        String password = "123456";
//        Login login = new Login(driver);
//        driver = login.wishlist(email,password);
//        //Step 4: Click on MY WISHLIST link
//        WebElement wishlist = driver.findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']"));
//        wishlist.click();
//        //Step 5:In next page, Click ADD TO CART link
//        WebElement Cart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
//        Cart.click();
//        //Step 6: Enter general shipping country, state/province and zip for the shipping cost estimate
//        CartPage cart = new CartPage(driver);
//        String country = "United States";
//        String state = "New York";
//        String zip = "9000";
//        driver = cart.racer(country,state,zip);
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
import pom.CartPage;
import pom.Login;

public class TestCase6 {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
    }

    @Test
    public void testWishlistToCart() {
        // Step 2: Click on my account link
        WebElement accountLink = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']"));
        accountLink.click();

        // Step 3: Login to the application using previously created credentials
        String email = "ledang123@gmail.com";
        String password = "123456";
        Login login = new Login(driver);
        driver = login.wishlist(email,password);

        // Step 4: Click on MY WISHLIST link
        WebElement wishlistLink = driver.findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']"));
        wishlistLink.click();

        // Step 5: In the next page, Click ADD TO CART link
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        addToCartButton.click();

        // Step 6: Enter general shipping country, state/province, and zip for the shipping cost estimate
        CartPage cart = new CartPage(driver);
        String country = "United States";
        String state = "New York";
        String zip = "9000";
        driver = cart.racer(country, state, zip);
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
