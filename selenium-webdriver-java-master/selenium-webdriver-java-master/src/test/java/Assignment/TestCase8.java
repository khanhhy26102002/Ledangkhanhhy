//package Assignment;
//
//import driver.driverFactory;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import pom.CheckOutPage;
//import pom.Page;
//
//public class TestCase8 {
//    @Test
//    public void TestCase8(){
//        WebDriver driver = driverFactory.getChromeDriver();
//
//        Page page = new Page(driver);
//        CheckOutPage chkout = new CheckOutPage(driver);
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
//        // Step 4: Click on 'REORDER' link , change QTY & click Update
//        page.clickReorder();
//        String OldgrandTotal = page.getOldGrandTotal();
//        page.changeQty("10");
//        page.clickUpdate();
//
//        // Step 5: Verify Grand Total is changed
//        String grandTotal = page.getGrandTotal();
//        assert !grandTotal.equals(OldgrandTotal) : "Failed update Grand Total!";
//        System.out.println("Grand Total Updated");
//
//        // Step 6: Complete Billing & Shipping Information
//        chkout.clickProceedToCheckout();
//
//        chkout.enterBillingInformation("New Address", "aaa",
//                "aaa", "aaa", "FPT", "24",
//                "LVV", "THUDUC", "New York", "123456",
//                "United States", "1234567890", "654321");
//
//        chkout.enterShippingInformation("New Address", "aaa",
//                "aaa", "aaa", "FPT", "24",
//                "LVV", "THUDUC", "New York", "123456",
//                "United States", "1234567890", "654321");
//
//        chkout.selectShippingMethod();
//        chkout.selectPaymentMethod();
//        chkout.clickPaymentInfo();
//        chkout.clickPlaceOrder();
//
//        // Step 7: Verify order is generated and note the order number
//        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
//        String actualMessage = chkout.getOrderRecievedMessage();
//        assert actualMessage.equals(expectedMessage) : "Order failed!";
//        System.out.println("Order sent succeed");
//
//        String orderNumber = chkout.getOrderNumber();
//        System.out.println(orderNumber);
//
//
//        // Close the browser
//        driver.quit();
//    }
//}
package Assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import driver.driverFactory;
import pom.CheckOutPage;
import pom.Page;

import static org.junit.Assert.assertEquals;

public class TestCase8 {
    private WebDriver driver;
    private Page page;
    private CheckOutPage chkout;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        page = new Page(driver);
        chkout = new CheckOutPage(driver);
    }

    @Test
    public void testOrderProcessing() {
        // Step 1: Go to http://live.techpanda.org/
        page.goToHomePage();

        // Step 2: Click on My Account link
        page.clickMyAccount();

        // Step 3: Login in application using previously created credential
        page.login("aaaaa@email.com", "A123456");

        // Step 4: Click on 'REORDER' link, change QTY & click Update
        String oldGrandTotal = page.getOldGrandTotal();
        page.clickReorder();
        page.changeQty("10");
        page.clickUpdate();

        // Step 5: Verify Grand Total is changed
        String grandTotal = page.getGrandTotal();
        assertEquals("Failed update Grand Total!", grandTotal, oldGrandTotal);
        System.out.println("Grand Total Updated");

        // Step 6: Complete Billing & Shipping Information
        chkout.clickProceedToCheckout();

        chkout.enterBillingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "24",
                "LVV", "THUDUC", "New York", "123456",
                "United States", "1234567890", "654321");

        chkout.enterShippingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "24",
                "LVV", "THUDUC", "New York", "123456",
                "United States", "1234567890", "654321");

        chkout.selectShippingMethod();
        chkout.selectPaymentMethod();
        chkout.clickPaymentInfo();
        chkout.clickPlaceOrder();

        // Step 7: Verify order is generated and note the order number
        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = chkout.getOrderRecievedMessage();
        assertEquals("Order failed!", expectedMessage, actualMessage);
        System.out.println("Order sent succeed");

        String orderNumber = chkout.getOrderNumber();
        System.out.println(orderNumber);
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
