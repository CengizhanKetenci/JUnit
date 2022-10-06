package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;

    @Before
    // Before notasyonu her testten önce çalışır.
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    // After notasyonu her testten sonra çalışır.
    public void tearDown(){
        driver.close();
    }
    @Test
    public void method1(){

        // 1 defa before methodu çalışır.
        driver.get("https://www.amazon.com/");
        // 1 defa after methodu çalışır
    }
    @Test
    public void method2(){

        // 1 defa before methodu çalışır.
        driver.get("https://www.techproeducation.com/");
        // 1 defa after methodu çalışır
    }
    @Test
    public void method3(){

        // 1 defa before methodu çalışır.
        driver.get("https://www.hepsiburada.com/");
        // 1 defa after methodu çalışır
    }
    /*
    önce before çalıştı, test1 çalıştı, after çalışarak sayfayı kapattı.
    tekrar before çalıştı, yeni sayfada test2 çalıştı, yine after çalışarak sayfayı kapattı.
    üçüncü kez before çalıştı, yeni sayfada test3 çalıştı, üçüncü kez after çalışarak sayfayı kapattı.
     */

}
