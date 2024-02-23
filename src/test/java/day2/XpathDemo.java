package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo {

    // Xpath -> XMLPath -> query language used to locate element from XML/HTML document

    // absolute XPath -> html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div/div[1]
    // relative XPath -> //div[@class='_446kkh']
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // dynamic wait

        driver.get("https://www.hoteltonight.com/");

//        Thread.sleep(1000); // static wait

//        String absoluteXpath = "html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div/div[1]";
//        System.out.println(driver.findElement(By.xpath(absoluteXpath)).getText());
        String relativeXpath = "//div[@class='_446kkh']";
        System.out.println(driver.findElement(By.xpath(relativeXpath)).getText());



        // NoSuchElementException:
        // 1. Wrong locator
        // 2. Timing
        // 3. The element is inside an iframe


    }
}

