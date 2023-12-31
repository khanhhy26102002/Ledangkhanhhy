package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Orders {
    protected WebDriver driver;
    private By OrderID = By.id("sales_order_grid_filter_real_order_id");
    private By FromDate = By.name("created_at[from]");
    private By ToDate = By.name("created_at[to]");
    private By bySearch = By.xpath("//button[@title='Search']");
    public Orders(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void Search(String order, String start, String end) {
        if (order != null) {
            driver.findElement(OrderID).sendKeys(order);
        }
        if (start != null) {
            driver.findElement(FromDate).sendKeys(start);
        }
        if (end != null) {
            driver.findElement(ToDate).sendKeys(end);
        }
        driver.findElement(bySearch).click();
    }
}
