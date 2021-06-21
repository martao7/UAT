package Testerski;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import pages.UserInfoPage;

import java.util.concurrent.TimeUnit;

public class Test2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do strony
        driver.get("https://qloapps.coderslab.pl/en/");
    }
    @Test
    public void testGoogleSearch() {

        WebElement element = driver.findElement(By.className("hide_xs"));
        element.click();

        WebElement emailInput = driver.findElement(By.name("email_create"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("jan2.nowak@gmail.com");

        WebElement submitButton = driver.findElement(By.name("SubmitCreate"));
        submitButton.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        driver.get("https://qloapps.coderslab.pl/en/login?back=my-account#account-creation");


        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.addInfo("Janek", "Nowak", "pass123", "10", "5", "1990");
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}