package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePagesTests extends TestBase {
    //будет наследовать от ТестБейз
    @Test
    public void openHomePage() throws InterruptedException {
       /*WebDriver driver = new ChromeDriver();
        driver.get("https://mish.sheygam.com/#/wellcome");
        driver.manage().window().maximize();
        */
        Thread.sleep(10000);
        WaitUntillElementIsLoaded(driver, By.xpath("//span[contains(text(),'Login')]"),20);
        List<WebElement> topLinksList = driver.findElements(By.cssSelector(".mat-button-wrapper .mat-button-wrapper"));
        System.out.println("Login:" + topLinksList.get(0).getText());
        System.out.println("Create Account:" + topLinksList.get(1).getText());
        WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));
       // System.out.println("Text of button: " + goToEventsButton.getText());
       //Thread.sleep(5000);
        Assert.assertTrue(goToEventsButton.getText().equals("Go to Event list"));//проверяем что берём текст и что нахожимся на нужной странички
      //  driver.quit();

    }



    @Test
    public void goToEventsTests() throws InterruptedException {
        /*WebDriver driver = new ChromeDriver();
        driver.get("https://mish.sheygam.com/#/wellcome");
        driver.manage().window().maximize();
        */
       // Thread.sleep(10000);
        List<WebElement> topLinksList = driver.findElements(By.cssSelector(".mat-button-wrapper .mat-button-wrapper"));
        System.out.println("Login:" + topLinksList.get(0).getText());
        System.out.println("Create Account:" + topLinksList.get(1).getText());
        WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));
        System.out.println("Text of button: " + goToEventsButton.getText());
        Thread.sleep(5000);
        goToEventsButton.click();
        Thread.sleep(5000);
        WebElement titlePage = driver.findElement(By.xpath(" //h1[@class='gorisontal-center']"));
        Assert.assertTrue(titlePage.getText().equals("Find event"));
    //    driver.quit();
    }
    private void WaitUntillElementIsLoaded(WebDriver driver, By locator, int time)

    {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch(Exception e){ e.printStackTrace();
        }
    }
}
