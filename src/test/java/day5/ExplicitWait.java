package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {

    @Test
    public void testExplicitWait() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[.=\"It's gone!\"]")));

        driver.findElement(By.xpath("//p[.=\"It's gone!\"]")).getText();

        WebElement webElement = driver.findElement(By.xpath("//input[@type='text']"));

        System.out.println(webElement.isDisplayed());
        System.out.println(webElement.isSelected());
        System.out.println(webElement.isEnabled());


        driver.findElement(By.xpath("//button[.='Enable']")).click();
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(webElement));

//        TimeoutException: Expected condition failed: waiting for element to be clickable:

       webElement.sendKeys("Hello");

    }
}
