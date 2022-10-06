package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
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
        driver.close();
    }
    @Test
    public void test1() throws Exception {
        /*
        //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım
         */
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindoeHandle = driver.getWindowHandle();
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        //2- Url'nin amazon içerdiğini test edelim.
        String istenenKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni pencere açmak için
        driver.get("https://www.bestbuy.com");

        String bestbuyWindoeHandle = driver.getWindowHandle(); // yeni açtığımız pencerenin Handle değerini almak için.

        // //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya (amazon) dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindoeHandle); // sayfalar arası geçişlerde handle değerlerini kullanırız.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        // 6- Arama sonuclarının java içerdiğini test edelim
        WebElement sonucTabela = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("aramasonucu = " + sonucTabela.getText());

        String istenenKelimeJava = "java";
        String actualTabelaMetni  = sonucTabela.getText();
        Assert.assertTrue(actualTabelaMetni.contains(istenenKelimeJava));

        // 7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindoeHandle);

        //8- best buy Logosunun görünürlüğünü test edelim
        WebElement logoBestbuy = driver.findElement(By.xpath("//*[@class='logo']"));
        Assert.assertTrue(logoBestbuy.isDisplayed());







    }
}
