package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username    : admin
    password    : admin
    Basarili sekilde sayfaya girildigini dogrulayin
     */
    WebDriver driver;

    @Before
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(1000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test1() throws Exception {
        // https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);

        // asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //    Html komutu : https://username:password@URL
        //    Username    : admin
        //    password    : admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Basarili sekilde sayfaya girildigini dogrulayin
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isDisplayed());

    }
}
