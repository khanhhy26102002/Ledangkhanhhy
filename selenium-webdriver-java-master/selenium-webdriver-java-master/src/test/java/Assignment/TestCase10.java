package Assignment;

import driver.driverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.CartPage;
import pom.Orders;

public class TestCase10 {
    @Test
    public void TestCase10(){
        //Step 1: Go to http://live.techpanda.org/index.php/backendlogin
        WebDriver driver = driverFactory.getChromeDriver();
         driver.get("http://live.techpanda.org/index.php/backendlogin");
        CartPage cart = new CartPage(driver);
         //Step 2: Login the credentials provided
         String userid = "user01";
         String password = "guru99com";
         cart.login(userid,password);
        //Step 3: Go to Sales->Orders menu
        WebElement clickbutton = driver.findElement(By.xpath("//span[normalize-space()='close']"));
        clickbutton.click();
        WebElement title = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        title.click();
        WebElement title1 = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        title1.click();
        //Step 4: Input OrderID and FromDate -> ToDate
        String orders= "100021151";
        String fromDate = "25/12/2023";
        String endDate = "27/1/2024";
        Orders order = new Orders(driver);
        order.Search(orders,fromDate,endDate);
    }
}
