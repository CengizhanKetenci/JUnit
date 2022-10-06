package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void test1() throws Exception {
        /*
        Yeni bir class olusturun: WindowHandle
Amazon anasayfa adresine gidin.
Sayfa’nin window handle degerini String bir degiskene atayin
Sayfa title’nin “Amazon” icerdigini test edin
Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
Sayfa title’nin “Walmart” icerdigini test edin
Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
         */

        // 1-Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        // 2-Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindoeHandle = driver.getWindowHandle();

        // 3-Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 4-Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        // 5-Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedTitle2 = "TECHPROEDUCATION";
        String actualTitle2 = driver.getTitle();
        Assert.assertFalse(actualTitle2.contains(expectedTitle2));

        // 6-Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        // 7-Sayfa title’nin “Walmart” icerdigini test edin
        String expectedTitleWM ="Walmart";
        String actualTitleWM = driver.getTitle();
        Assert.assertTrue(actualTitleWM.contains(expectedTitleWM));

        // veya 7.soruyu tek satırda şöyle yazabiliriz.
        Assert.assertTrue(driver.getCurrentUrl().contains("Walmart.com"));

        // 8-Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindoeHandle); // dönmek istediğimiz sayfanın handle değerini kullanmalıyız.
        String expectedUrl = "https://www.amazon.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(actualUrl));

        // veya 8.soruyu tek satırda yazacak olursak
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));



    }
}
