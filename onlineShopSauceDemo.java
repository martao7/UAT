package testShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class onlineShopSauceDemo {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void testSearch() {

        //a user logs in
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //user chooses 2 products
        WebElement sauceLabsBoltTShirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        sauceLabsBoltTShirt.click();

        WebElement sauceLabsBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLabsBackpack.click();

        //user goes to shopping cart
        WebElement shoppingCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        shoppingCart.isEnabled();
        Assert.assertEquals("2", "2");
        shoppingCart.click();

        //shopping cart - products check
        Assert.assertEquals(sauceLabsBoltTShirt,sauceLabsBoltTShirt);
        Assert.assertEquals(sauceLabsBackpack, sauceLabsBackpack);

        WebElement priceSauceLabsBoltTShirt = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
        Assert.assertEquals("15.99", priceSauceLabsBoltTShirt, priceSauceLabsBoltTShirt);

        WebElement priceSauceLabsBackpack = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div"));
        Assert.assertEquals("29.99", priceSauceLabsBackpack, priceSauceLabsBackpack);

        //user goes to checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        //checkout: Users information: firstname, lastname, zip
        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.click();
        firstname.clear();
        firstname.sendKeys("Anna");

        WebElement lastname = driver.findElement(By.id("last-name"));
        lastname.click();
        lastname.clear();
        lastname.sendKeys("Haus");

        WebElement zip = driver.findElement(By.id("postal-code"));
        zip.click();
        zip.clear();
        zip.sendKeys("60121");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        //assert prices
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
        Assert.assertEquals("49.66", totalPrice, totalPrice);

        //click on finish checkout
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        //assert checkout complete
        WebElement checkoutComplete = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals("Checkout: Complete!", checkoutComplete, checkoutComplete);

        WebElement successfulMessage = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        Assert.assertEquals("Thank you for your order!", successfulMessage, successfulMessage);
    }
    @After
    public void tearDown() throws Exception {
        //close the window
        driver.quit();
    }
}