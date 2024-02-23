package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class HandlingWindows2 {

    @Test
    public void TestHandlingWindows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.volvo.com/en/");
        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(1000);

        // Open the second window

        driver.findElement(By.xpath("//img[@alt='Cars']")).click();

        Set<String > windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Volvo USA | New and Used Cars | Official Volvo Website")){
                break;
            }
        }
        System.out.println("Current window title: " + driver.getTitle());

        // get rid of the cookie
        driver.findElement(By.xpath("//button[.='Accept']")).click();

        Thread.sleep(2000);

        // Open the third window

        new Actions(driver).keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//span[.='View offers ']"))).perform();

        // With multiple windows we can use their titles





    }
}
