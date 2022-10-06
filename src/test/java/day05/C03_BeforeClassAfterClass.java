package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonları oluştururken
    diğer notasyonlardan farklı olarak methodumuzu "static" yapmalıyız.
     */
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    @Ignore ("Çalışmasını istemediğimiz testin önüne @Ignore yazmamız yeterlidir.")
    public void method1(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void method2(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://www.hepsiburada.com");
    }
    /*
    beforeClass çalıştı, test1 çalıştı, aynı sayfada test2 çalıştı, aynı sayfada test3 çalıştı ve afterClass çalıştı.
    tüm testler aynı sayfada çalıştı. her test için, önceki sayfayı kapatıp yeni sayfa açması gerekmedi.

    @Test notasyonunun altına @Ignore notasyonunu eklerseniz o test çalışmaz bir sonrakinden çalışmaya devam eder.
    sıralı testler içinde çalışmasını istemediğimiz bir test varsa önüne @Ignore yazmamız yeterli.
     */

}
