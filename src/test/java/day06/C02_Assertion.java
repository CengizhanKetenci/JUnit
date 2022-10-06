package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {

    /*
    Amazon sayfasina git
    3 farkli test method'u olustur
    - url'in "amazon" icergini test et
    - title'in "facebook" icermedigini test et
    - sol ust kosede amazon logosunun gorundugunu test et
    - url nin www.facebook.com olduğunu test edin.
    */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {

        // 1- url'in "amazon" icergini test et

        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void test2() {

        // 2- title'in "facebook" icermedigini test et

        String expectedTitle = "Facebook";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test3() {

        // 3- sol ust kosede amazon logosunun gorundugunu test et.

        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());


    }

    @Test
    public void test4() {

        // 4- url nin www.facebook.com olduğunu test edin.

        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertFalse(actualUrl.equals(expectedUrl));
    }
}
