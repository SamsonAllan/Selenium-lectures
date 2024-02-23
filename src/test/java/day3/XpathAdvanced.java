package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathAdvanced {
    @Test
    public void testCase(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.carfax.com/");
        driver.findElement(By.linkText("Used Car Values")).click();

        // Locate all a's  with class attribute
        // a[@class]

        //a[not(@class)] -> all a's that do NOT have class attribute

        // Advanced locating strategies based on child, parent and siblings

        // Locate a non-unique element by locating its unique PARENT
        //
        // div[@class='text-input vehicleInputFormStyle_vehicle-input-form__input__vin__dOb1V']//input[@type='text']

        driver.findElement(By.xpath("//div[@class='text-input vehicleInputFormStyle_vehicle-input-form__input__plate__gCjxu']//input[@type='text']")).sendKeys("UGA1010");

        // Locate a non-unique parent by its unique CHILD

        // syntax -> child locator//parent::tagName
        //h2[ contains ( text(),  'Step 2 - Enter your VIN')]//parent::form
        System.out.println(driver.findElement(By.xpath("//h2[ contains ( text(),  'Step 2 - Enter your VIN')]//parent::form")).getText());

        // locate a non-unique element by its unique SIBLING that comes after it

        //syntax -> uniqueSibling//following-sibling::tagName
        //input[@name='vin']//following-sibling::label
        driver.findElement(By.xpath("//input[@name='vin']//following-sibling::label")).getText();




    }
}
