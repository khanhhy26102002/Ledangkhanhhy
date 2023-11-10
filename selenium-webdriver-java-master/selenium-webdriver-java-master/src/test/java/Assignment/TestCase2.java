//package Assignment;
//
//import driver.driverFactory;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import static org.testng.AssertJUnit.assertEquals;
//
//public class TestCase2 {
//    @Test
//    public void TestCase2(){
//        // Step 1. Go to http://live.techpanda.org/
//        WebDriver driver = driverFactory.getChromeDriver();
//        driver.get("http://live.techpanda.org/");
//
//        // Step 2. Click on -> MOBILE -> menu
//        WebElement MOBILElink = driver.findElement(By.className("first"));
//        MOBILElink.click();
//        // Step 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
//        WebElement sony = driver.findElement(By.xpath("//div[h2/a/@title='Sony Xperia']"));
//        String test_value = sony.findElement(By.className("price")).getText();
//
//        // Step 4. Click on Sony Xperia mobile
//        sony = driver.findElement(By.xpath("//h2[a/@title='Sony Xperia']"));
//        sony.click();
//
//        // Step 5. Read the Sony Xperia mobile from detail page.
//        WebElement sony_detail = driver.findElement(By.className("price"));
//        String actual_value = sony_detail.getText();
//
//        // Step 6. Compare Product value in list and details page should be equal ($100).
//        assertEquals(test_value, actual_value);
//    }
//}
package Assignment;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver before each test
        driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
    }

    @Test
    public void verifySonyXperiaMobilePrice() {
        // Step 2. Click on -> MOBILE -> menu
        WebElement MOBILElink = driver.findElement(By.className("first"));
        MOBILElink.click();

        // Step 3. Read the cost of Sony Xperia mobile (which is $100)
        WebElement sony = driver.findElement(By.xpath("//div[h2/a/@title='Sony Xperia']"));
        String testValue = sony.findElement(By.className("price")).getText();

        // Step 4. Click on Sony Xperia mobile
        sony = driver.findElement(By.xpath("//h2[a/@title='Sony Xperia']"));
        sony.click();

        // Step 5. Read the Sony Xperia mobile from the detail page.
        WebElement sonyDetail = driver.findElement(By.className("price"));
        String actualValue = sonyDetail.getText();

        // Step 6. Compare Product value in the list and details page should be equal ($100).
        assertEquals(testValue, actualValue);
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }
}

