package testsuits;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setupTest() {

        openBrowser(baseUrl);
    }

    @Test
    public void register() {
        //3.1 User can register
    driver.findElement(By.xpath("//a[text()='Register']")).click();
    driver.findElement(By.id("customer.firstName")).sendKeys("Jack");
    driver.findElement(By.id("customer.lastName")).sendKeys("June");
    driver.findElement(By.id("customer.address.street")).sendKeys(("24,Rowan Avenue"));
    driver.findElement(By.id("customer.address.city")).sendKeys("Newark");
    driver.findElement(By.id("customer.address.state")).sendKeys("Newyork");
    driver.findElement(By.id("customer.address.zipCode")).sendKeys("58470231");
    driver.findElement((By.id("customer.phoneNumber"))).sendKeys(("0014287512"));
    driver.findElement(By.id("customer.ssn")).sendKeys("025");
    driver.findElement(By.id("customer.username")).sendKeys("Imjackjune");
    driver.findElement(By.id("customer.password")).sendKeys("June@jack");
    driver.findElement(By.id("repeatedPassword")).sendKeys("June@jack");
    driver.findElement(By.className("button")).click();


   /* String ActualMsg = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();
    String ExpectedMsg = "Your account was created successfully. You are now logged in.";
    Assert.assertEquals("Your account was created successfully. You are now logged in.",ExpectedMsg,ActualMsg);  */




    }
}