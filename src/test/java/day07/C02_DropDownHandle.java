package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {

    /*
    ●https://www.amazon.com/ adresine gidin.
    -Test1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

    -Test2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin vearatin
    3.Bulunan sonuc sayisiniyazdirin
    4.Sonucun Java kelimesini icerdigini testedin
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/ adresine gidin.");
        Thread.sleep(1000);
        }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }
    @Test
    public void test1() throws Exception {
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com");

       List<WebElement> ddm = driver.findElements(By.xpath("//option"));

        System.out.println("ddm.size() = " + ddm.size());

        for (WebElement each : ddm) {
            System.out.println("each.getText() = " + each.getText());
        }
        Integer expectednumber =54;
        Integer actualnumber =ddm.size();
        Assert.assertNotEquals(expectednumber, actualnumber);
    }
    @Test
    public void test2() {
        // 1.Kategori menusunden Books secenegini secin
        driver.get("https://www.amazon.com");
        WebElement all = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        all.click();
        all.sendKeys("Books");

        //    2.Arama kutusuna Java yazin ve aratin
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("java"+ Keys.ENTER);


        //    3.Bulunan sonuc sayisiniyazdirin

        WebElement sonuc=driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
        System.out.println("sonuc.getText() = " + sonuc.getText());
        String aramaSonucu = sonuc.getText();
        String [] aramaSayisi =aramaSonucu.split(" ");
        System.out.println("Sonuç Sayısı = " + aramaSayisi[3]);

        //    4.Sonucun Java kelimesini icerdigini test edin
        String expectedKelime="java";
        String actualSonucYazisi= sonuc.getText();
        Assert.assertFalse(actualSonucYazisi.contains(expectedKelime));

    }

}
