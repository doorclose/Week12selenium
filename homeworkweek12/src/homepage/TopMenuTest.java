package homepage;

import browsertest.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);

    }
    @Test
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()//
    public void selectMenu() {
        Actions actions = new Actions(driver);
       WebElement DesktopTabs = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement Showallalldesktop = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        actions.moveToElement(DesktopTabs).moveToElement(Showallalldesktop).click().build().perform();

        String actualMsg=driver.findElement(By.xpath("//a[text()='Desktops']")).getText();
        String expectedMsg = "Desktops";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        //verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
        WebElement Laptopsandnotebooks  = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement ShowallLaptopsandNotebooks = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        actions.moveToElement(Laptopsandnotebooks).moveToElement(ShowallLaptopsandNotebooks).click().build().perform();

        String actualMsg1=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).getText();
        String expectedMsg1 = "Laptops & Notebooks";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        //verifyUserShouldNavigateToComponentsPageSuccessfully()
        WebElement Components  = driver.findElement(By.xpath("//a[text()='Components']"));
        WebElement ShowallComponents = driver.findElement(By.xpath("//a[text()='Show AllComponents']"));
        actions.moveToElement(Components).moveToElement(ShowallComponents).click().build().perform();

        String actualMsg2=driver.findElement(By.xpath("//a[text()='Components']")).getText();
        String expectedMsg2 = "Components";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

    }
    @After
    public void tearDown() {
        // closeBrowser();
    }
}

