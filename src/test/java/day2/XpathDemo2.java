package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo2 {

    // Xpath -> XMLPath -> query language used to locate element from XML/HTML document

    // absolute XPath -> html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div/div[1]
    // relative XPath -> //div[@class='_446kkh']
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // dynamic wait

        driver.get("https://www.webstaurantstore.com/");
        System.out.println(driver.findElement(By.xpath("//button[@type='submit'][@value='Search']")));

        // using multiple attributes:
        //button[@type='submit'][@value='Search']
        //button[@type='submit' and @value='Search']

        // using attribute names only:
        //button[@type] -> all button elements with type attribute
        //*[id] -> any element with an id attribute
        //*[@*] -> any element with any attribute
        //* -> any element

        // text based match
        //div[.='Prep & Transport Racks'] -> div with a text 'Prep & Transport Racks'
        //div[text()='Prep & Transport Racks'] -> div with a text 'Prep & Transport Racks'


        //div[contains(text(), 'Quick Transportation')]

        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Quick Transportation')]")).getText());

        // Predicate
        // (xpathExpression)[number]
        // (//div[@class='somevalue'])[2] -> matches the second of the possible matches

//        System.out.println(driver.findElement(By.xpath("")));
        




    }
}

