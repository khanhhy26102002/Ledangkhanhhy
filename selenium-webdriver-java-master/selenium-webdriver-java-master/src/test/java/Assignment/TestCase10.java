//package Assignment;
//
//import driver.driverFactory;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import pom.CartPage;
//import pom.Orders;
//import screenshot.ScreenshotTaker;
//
//public class TestCase10 {
//    @Test
//    public void TestCase10(){
//        //Step 1: Go to http://live.techpanda.org/index.php/backendlogin
//        WebDriver driver = driverFactory.getChromeDriver();
//         driver.get("http://live.techpanda.org/index.php/backendlogin");
//        CartPage cart = new CartPage(driver);
//         //Step 2: Login the credentials provided
//         String userid = "user01";
//         String password = "guru99com";
//         cart.login(userid,password);
//        //Step 3: Go to Sales->Orders menu
//        WebElement clickbutton = driver.findElement(By.xpath("//span[normalize-space()='close']"));
//        clickbutton.click();
//        WebElement title = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
//        title.click();
//        WebElement title1 = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
//        title1.click();
//        //Step 4: Input OrderID and FromDate -> ToDate and Step 5: Click Search button
//        String orders= "100021151";
//        String fromDate = "12/25/2023";
//        String endDate = "1/27/2024";
//        Orders order = new Orders(driver);
//        order.Search(orders,fromDate,endDate);
//        //Step 6: Screenshot capture
//        title = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
//        title.click();
//        ScreenshotTaker.takeScreenshot(driver,"Image.png");
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
import pom.Orders;
import screenshot.ScreenshotTaker;

public class TestCase10 {
    private WebDriver driver;
    private Orders ordersPage;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        ordersPage = new Orders(driver);
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        // Login with credentials
        String userId = "user01";
        String password = "guru99com";
        CartPage cart = new CartPage(driver);
        cart.login(userId, password);
    }

    @Test
    public void testSalesOrderSearch() {
        // Step 3: Go to Sales->Orders menu
        WebElement clickbutton = driver.findElement(By.xpath("//span[normalize-space()='close']"));
        clickbutton.click();
        WebElement title = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        title.click();
        WebElement title1 = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        title1.click();

        // Step 4: Input OrderID and FromDate -> ToDate
        String orderId = "100021151";
        String fromDate = "12/25/2023";
        String endDate = "1/27/2024";

        // Step 5: Click Search button
        ordersPage.Search(orderId, fromDate, endDate);

        // Step 6: Screenshot capture
        title = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        title.click();
        ScreenshotTaker.takeScreenshot(driver, "Image.png");
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
