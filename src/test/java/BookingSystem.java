import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BookingSystem {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.easemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies(); //delete all cookies

        //Click on Roundtrip button
        WebElement roundTrip = driver.findElement(By.id("rtrip"));
        roundTrip.click();
        //search city
        WebElement searchtoCity = driver.findElement(By.id("tocity"));
        searchtoCity.click();

        WebElement citySelection = driver.findElement(By.id("a_Editbox13_show"));
        citySelection.sendKeys("Chandigarh");
        Thread.sleep(2000);
        //toautoFill
        WebElement chandigarhSelection = driver.findElement(By.xpath("//*[@id='toautoFill']/ul/li[1]"));
        chandigarhSelection.click();
        Thread.sleep(2000);
//departure date
        WebElement activeDepartureDate = driver.findElement(By.className("active-date"));
        WebElement sibling = activeDepartureDate.findElement(By.xpath("following-sibling::*"));
        sibling.click();    //sibling expression : next date after active departure date

        //Search for City
        WebElement searchCity = driver.findElement(By.xpath("//*[@id='divSearchFlight']/button"));
        searchCity.click();
        Thread.sleep(5000);
        //BookNow
        WebElement bookNow = driver.findElement(By.xpath("//*[@id='BtnBookNow']"));
        bookNow.click();

        Thread.sleep(5000);
        //returnflight
        WebElement returnFlight = driver.findElement(By.xpath("//*[@id='DivMoreFareRT']/div/div[2]/div[1]/ul/li[2]"));
        returnFlight.click();

        //continue button
        driver.findElement(By.xpath("//*[@id='DivMoreFareRT']/div/div[3]/div/div/div[2]")).click();

        //clickensurebutton
        driver.findElement(By.id("notinsure")).click();

        //email
        WebElement userEmail = driver.findElement(By.id("txtEmailId"));
        userEmail.sendKeys("xyz@gmail.com");

        //continueBooking
        driver.findElement(By.id("spnVerifyEmail")).click();
        Thread.sleep(5000);

     //passengerdetails
        Select titleSelect= new Select(driver.findElement(By.id("titleAdult0")));
        titleSelect.selectByValue("Ms");

        //name
        driver.findElement(By.id("txtFNAdult0")).sendKeys("ABC");
        driver.findElement(By.id("txtLNAdult0")).sendKeys("XYZ");
        driver.findElement(By.id("txtCPhone")).sendKeys("9856012345");
        driver.findElement(By.id("spnTransaction")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='edit_btn'][text()='Skip']")).click();

        Thread.sleep(Duration.ofSeconds(5));//5 seconds
        //driver.findElement(By.xpath("//*[@id='DivContinueAncillary']/span")).click();//continue booking
           driver.findElement(By.id("skipPop")).click();
    }
}
