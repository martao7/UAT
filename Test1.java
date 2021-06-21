package Testerski;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

public class Test1 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://www.google.com");

        //////

        WebElement element = driver.findElement(By.id("L2AGLb"));
        // kliknij nutzungsbedingungen 'stimme zu' zeby przejsc dalej
        element.click();
    }
    @Test
    public void testGoogleSearch() {
        // znajdz element
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();

        // Wpisz informacje do wyszukania
        element.sendKeys("Testowanie Selenium WebDriver");

        // Prześlij formularz
        element.submit();

        //driver.get("https://www.google.com/search?source=hp&ei=4ENKX56dIqW2gwevt4agCg&q=Testowanie+Selenium+WebDriver");


    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}