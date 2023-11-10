//package Assignment;
//
//import org.testng.annotations.Test;
//import driver.driverFactory;
//import org.openqa.selenium.WebDriver;
//import pom.Page;
//
//public class TestCase7 {
//    @Test
//    public void Main() {
//
//        // Create a WebDriver instance
//        WebDriver driver = driverFactory.getChromeDriver();
//
//        Page page = new Page(driver);
//
//        // Step 1: Go to http://live.techpanda.org/
//        page.goToHomePage();
//
//        // Step 2: Click on My Account link
//        page.clickMyAccount();
//
//        // Step 3: Login in application using previously created credential
//        page.login("aaaaa@email.com", "A123456");
//
//        // Step 4: Click on 'My Orders'
//        page.clickMyOrders();
//
//        // Step 5: Click on 'View Order'
//        page.clickViewOrder();
//
//        // Step 6: Click on 'Print Order' link
//        page.clickPrintOrder();
//
//        // Step 8: A popup will be opened as 'Select a destination' , select 'Save as PDF' link.
////        page.clickSavePDF();
//
//        // Close the browser
//        driver.quit();
//    }
//}
package Assignment;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import driver.driverFactory;
import pom.Page;

public class TestCase7 {
    private WebDriver driver;
    private Page page;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        page = new Page(driver);
    }

    @Test
    public void testOrderPrint() {
        // Step 1: Go to http://live.techpanda.org/
        page.goToHomePage();

        // Step 2: Click on My Account link
        page.clickMyAccount();

        // Step 3: Login in application using previously created credential
        page.login("aaaaa@email.com", "A123456");

        // Step 4: Click on 'My Orders'
        page.clickMyOrders();

        // Step 5: Click on 'View Order'
        page.clickViewOrder();

        // Step 6: Click on 'Print Order' link
        page.clickPrintOrder();

        // Step 8: A popup will be opened as 'Select a destination', select 'Save as PDF' link.
        // Uncomment the following line when the corresponding method is implemented in the 'Page' class
        // page.clickSavePDF();
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
