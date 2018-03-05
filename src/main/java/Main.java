import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement login = driver.findElement(By.name("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submit = driver.findElement(By.className("ladda-label"));
        submit.click();

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
        }

        WebElement yourProfile = driver.findElement(By.id("employee_infos"));
        yourProfile.click();

        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
       // Asserts.check(true : login.isDisplayed()); - I try to check that I'm logout.

        driver.close();




    }
    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
