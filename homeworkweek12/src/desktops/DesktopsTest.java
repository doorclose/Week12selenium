package desktops;

import browsertest.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends BaseTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }
    @Test
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()//
    public void selectMenu() {
        Actions actions = new Actions(driver);
       /* WebElement DesktopTabs = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement Showallalldesktop = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        actions.moveToElement(DesktopTabs).moveToElement(Showallalldesktop).click().build().perform();

        WebElement Default = driver.findElement(By.id("input-sort"));
        Select select = new Select(Default);
        select.selectByVisibleText("Name (Z - A)");*/

        //verifyProductAddedToShoppingCartSuccessFully()


        WebElement DesktopTabs = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement Showallalldesktop = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        actions.moveToElement(DesktopTabs).moveToElement(Showallalldesktop).click().build().perform();

        WebElement Default = driver.findElement(By.id("input-sort"));
        Select select = new Select(Default);
        select.selectByVisibleText("Name (A - Z)");

        WebElement Laptop = driver.findElement(By.linkText("HP LP3065"));
        Laptop.click();

        String actualHpText = driver.findElement(By.linkText("HP LP3065")).getText();
        String expectedHpText = "HP LP3065";
        Assert.assertEquals("HP LP3065", expectedHpText, actualHpText);


        WebElement Laptopproduct = driver.findElement(By.xpath("//h1[text()='HP LP3065']"));
        Laptopproduct.getText().equals("HP LP3065");

        //DAte
        WebElement Deliverydate = driver.findElement(By.id("input-option225")); //Enter date
        Deliverydate.clear();
        Deliverydate.sendKeys("2022-11-30");

        WebElement Quentity = driver.findElement(By.id("input-quantity")); //select Qty
        Quentity.clear();
        Quentity.sendKeys("1");

       /* Select select1 = new Select(driver.findElement(By.name("quantity")));
        select1.selectByIndex(1); */
        //2.8
        WebElement AddtoCart = driver.findElement(By.id("button-cart"));  //Add to cart button
        AddtoCart.click();

      /*  String actualMsg=driver.findElement(By.ClassName("alert alert-success alert-dismissible")).getText();
        String expectedMsg = "Success: You have added HP LP3065 to your shopping cart! *";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg)); */

        //2.10
        WebElement Shoppingcartlink = driver.findElement(By.linkText("Shopping Cart")); //click on shopping cart
        Shoppingcartlink.click();
        //2.11
        String actualMsg = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        String expectedMsg = "Shopping Cart  (1.00kg)";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        // 2.12
        String actualMsg1 = driver.findElement(By.linkText("HP LP3065")).getText();
        String expectedMsg1 = "HP LP3065";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        //2.13
        String actualMsg3 = driver.findElement(By.xpath("//*[text()='Delivery Date:2022-11-30']")).getText();
        String expectedMsg3 = "input-option225";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

        //2.14
        String actualModel = driver.findElement(By.xpath("//td[text()='Product 21']")).getText();
        String expectedModel = "Product 21";
        Assert.assertEquals(actualModel,expectedModel);

        //2.15
        String actualMsg5 = driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expectedMsg5 = "$122.00";
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));

    }
    @After
    public void tearDown() {
        // closeBrowser();

    }
}