package myaccount;

import browsertest.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccount extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);

    }

    @After
    public void tearDown() {
        // closeBrowser();
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> accountOptions = driver.findElements(By.cssSelector(".dropdown-menu li a"));
        for (WebElement accountOption : accountOptions) {
            if (accountOption.getText().equalsIgnoreCase(option)) {
                accountOption.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on My Account Link
        driver.findElement(By.linkText("My Account")).click();
        // Call the method to select the Register option
        selectMyAccountOptions("Register");
        // Verify the text "Register Account"
        String expectedText = "Register Account";
        String actualText = driver.findElement(By.cssSelector("#content h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // Click on My Account Link
        driver.findElement(By.linkText("My Account")).click();
        // Call the method to select the Login option
        selectMyAccountOptions("Login");
        // Verify the text "Returning Customer"
        String expectedText = "Returning Customer";
        String actualText = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/h2")).getText();
        //String actualText = driver.findElement(By.cssSelector("#content h2")).getText();
        Assert.assertEquals(actualText, expectedText, "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        // Call the method to select the Register option
        selectMyAccountOptions("Register");

        // Fill the registration form
        driver.findElement(By.id("input-firstname")).sendKeys("July");
        driver.findElement(By.id("input-lastname")).sendKeys("dave");
        driver.findElement(By.id("input-email")).sendKeys("julydave@yahoo.com");
        driver.findElement(By.id("input-telephone")).sendKeys("0408255214");
        driver.findElement(By.id("input-password")).sendKeys("Orangesun");
        driver.findElement(By.id("input-confirm")).sendKeys("Orangesun");

        // Select Subscribe Yes radio button
       driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();

        // Click on Privacy Policy check box
        driver.findElement(By.name("agree")).click();

        // Click on Continue button
        driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();

        // Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = driver.findElement(By.cssSelector("#content h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Your Account Has Been Created!");

        // Click on Continue button
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

        // Logout steps
        selectMyAccountOptions("Logout");

        // Verify the text “Account Logout”
        expectedText = "Account Logout";
        actualText = driver.findElement(By.cssSelector("#content h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Text not matched");

        // Click on Continue button
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // Call the method to select the Login option
        selectMyAccountOptions("Login");

        // Enter login credentials
        driver.findElement(By.id("input-email")).sendKeys("julydave@yahoo.com");
        driver.findElement(By.id("input-password")).sendKeys("Orangesun");

        // Click on Login button
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();

        // Verify text “My Account”
        String expectedText = "My Account";
        String actualText = driver.findElement(By.cssSelector("#content h2")).getText();
        Assert.assertEquals(actualText, expectedText, "My Account");

        // Logout steps
        selectMyAccountOptions("Logout");

        // Verify the text “Account Logout”
        expectedText = "Account Logout";
        actualText = driver.findElement(By.cssSelector("#content h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Account Logout");

        // Click on Continue button
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
    }
    }
