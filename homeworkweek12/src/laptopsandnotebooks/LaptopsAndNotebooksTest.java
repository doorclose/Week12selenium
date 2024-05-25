package laptopsandnotebooks;

import browsertest.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);

    }

    @Test
    public void selectMenu() {
        Actions actions = new Actions(driver);

        WebElement laptopnotebookTab = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement ShowallLaptopsandNotebooks = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        actions.moveToElement(laptopnotebookTab).moveToElement(ShowallLaptopsandNotebooks).click().build().perform();

        //1.3
        WebElement Default = driver.findElement(By.id("input-sort"));
        Select select = new Select(Default);
        select.selectByVisibleText("Price (High > Low)");


        WebElement laptopnotebookTab1 = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement ShowallLaptopsandNotebooks1  = driver.findElement(By.xpath("//a[text()='AllLaptops & Notebooks']"));
        actions.moveToElement(laptopnotebookTab1).moveToElement(ShowallLaptopsandNotebooks1).click().build().perform();

        //2.4 Cick on MacBook
        WebElement MacBook = driver.findElement(By.xpath("//div[@id='content']/div[4]/div[4]/div/div[1]/a"));
        MacBook.click();

        //2.5 Verify "Macbook
        String actualModel = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        String expectedModel = "MacBook";
        Assert.assertEquals(actualModel,expectedModel);


        // 2.6 Click on add to cart
        WebElement AddtoCart = driver.findElement(By.id("button-cart"));
        AddtoCart.click();

        //2.7 Verify “Success: You have added MacBook to your shopping cart!”..I tried but cant do it

        //2.8 Click on shopping cart

        WebElement Shoppingcartlink = driver.findElement(By.linkText("Shopping Cart"));
        Shoppingcartlink.click();

        //2.9 Veryfy Shopping Cart
        String actualMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedMsg = "Shopping Cart  (0.00kg)";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        //2.10 Verify the Product name "MacBook"
        String actualMsg1 = driver.findElement(By.linkText("MacBook")).getText();
        String expectedMsg1 = "MacBook";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

       // 2.11 update quantity 2
        WebElement Quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        Quantity.clear();
        Quantity.sendKeys("2");

        //2.12 Click UPdate Tab
        WebElement Update = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]"));
        Update.click();

        //2.13 Verify message;->Success: You have modified your shopping cart!



        //2.14Verify Price
        String actualMsg5 = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expectedMsg5 = "$1,204.00";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        //2.15 click on checkout button
        WebElement CheckOut = driver.findElement(By.linkText("Checkout"));
        CheckOut.click();

        //2.19
        WebElement Continue = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/a"));
        Continue.click();

    }
}