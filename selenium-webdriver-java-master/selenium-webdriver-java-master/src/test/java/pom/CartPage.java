package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    protected WebDriver driver;
    private By ByCountry = By.id("country");
    private By ByState = By.id("state");
    private By ByZip = By.id("zip");
    private By ESTIMATE = By.xpath("//button[@title='Estimate']");
    private By SEND = By.id("coupon_code");
    private By GET = By.xpath("//button[@title='Apply']");
    private By SubTotal = By.xpath("//tbody//tr[1]//td[2]//span[@class='price']");
    private By Discount  = By.xpath("//tbody//tr[2]//td[2]//span[@class='price']");
    private By Total = By.xpath("//tfoot//td[2]//strong//span[@class='price']");

    private By Username = By.cssSelector("#username");
    private By Password = By.cssSelector("#login");
    private By Login = By.cssSelector("input[title='Login']");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver racer(String country, String state, String zip) {
        driver.findElement(ByCountry).sendKeys(country);
        driver.findElement(ByState).sendKeys(state);
        driver.findElement(ByZip).sendKeys(zip);
        driver.findElement(ESTIMATE).click();
        return driver;
    }
    public boolean champion(String update) {
        driver.findElement(SEND).sendKeys(update);
        driver.findElement(GET).click();
        WebElement dis = driver.findElement(SubTotal);
        float discount = Float.parseFloat(dis.getText().replaceAll("[^\\d.-]+",""));
        WebElement dis2 = driver.findElement(Discount);
        float discount2 = Float.parseFloat(dis2.getText().replaceAll("[^\\d.-]+",""));
        WebElement dis3 = driver.findElement(Total);
        float discount3 = Float.parseFloat(dis3.getText().replaceAll("[^\\d.-]+",""));
        return discount + discount2 == discount3;
    }
    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(Username);
        WebElement passwordField = driver.findElement(Password);
        WebElement loginButton = driver.findElement(Login);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
//    public WebDriver Car(String apply){
//        driver.findElement(GET).sendKeys(apply);
//        return driver;
//    }
}
