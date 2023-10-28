package Assignment;

import driver.driverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCase4 {
    @Test
    public void TestCase4() {
        //Step 1: http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
        String mainWindow = driver.getWindowHandle();
        //Step 2: Click on �MOBILE� menu
        WebElement Mobileclick = driver.findElement(By.className("first"));
        Mobileclick.click();
        //Step 3: In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
        ArrayList<String> list = new ArrayList<>();
        WebElement Sony = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
        list.add(Sony.getText());
        Sony = driver.findElement(By.xpath("//div[h2/a/@title='Sony Xperia']//div[@class='actions']//ul[@class='add-to-links']//li[2]//a[1]"));
        Sony.click();
        WebElement iphone = driver.findElement(By.xpath("//a[@title='IPhone'][normalize-space()='IPhone']"));
        list.add(iphone.getText());
        iphone = driver.findElement(By.xpath("//div[h2/a/@title='IPhone']//div[@class='actions']//ul[@class='add-to-links']//li[2]//a[1]"));
        iphone.click();
        //Step 4: Click on �COMPARE� button. A popup window opens
        WebElement compare = driver.findElement(By.xpath("//button[@title='Compare']"));
        compare.click();
        //Step 5: Verify the pop-up window and check that the products are reflected in it
        //Heading "COMPARE PRODUCTS" with selected products in it.
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        List<String> lists = new ArrayList<>();
        WebElement new_Sony = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
        lists.add(new_Sony.getText());
        WebElement new_Iphone = driver.findElement(By.xpath("//a[normalize-space()='Iphone']"));
        lists.add(new_Iphone.getText());
        assertEquals(list, lists);
        //Step 6: Close all popup windows
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.close();
    }
}
