package testsuits;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Loginsuits extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    @Test
    public void register() {
     //4.1.userShouldLoginSuccessfullyWithValidCredentials

    driver.findElement(By.name("username")).sendKeys("Imjackjune");
    driver.findElement(By.name("password")).sendKeys("June@jack");
   driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();

   //String ActualMsg = driver.findElement(By.xpath("//p[text()='Account Overview']")).getText();
}

    @Test

    public void wronglogin(){
        driver.findElement(By.name("username")).sendKeys("Imjackjuny");
        driver.findElement(By.name("password")).sendKeys("June_jack");
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
}

        @Test
         public void logout(){
            driver.findElement(By.name("username")).sendKeys("Imjackjune");
            driver.findElement(By.name("password")).sendKeys("June@jack");
            driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
            driver.findElement(By.xpath("//div[@id='leftPanel']/ul/li[8]/a")).click();


        }

    }
