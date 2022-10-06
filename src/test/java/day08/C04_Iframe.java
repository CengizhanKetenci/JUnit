package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class C04_Iframe {
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
        //driver.close();
    }

    @Test
    public void test1() throws Exception {
        // - https://html.com/tags/iframe/ adresine gidelim.
        driver.get("https://html.com/tags/iframe/");
        Thread.sleep(1000);

        // - youtube video'sunun frame'ini locate edelim ve frame'e switchTo() ile geçiş yapalım (en çok tercih edilen yöntemle yapalım)
        // bu yöntemle sitedeki tüm frame' 'leri bir List'e atıyoruz ve indeks vererek istediğimiz sıradaki frame'i oynatıyoruz.
        // bu örnekte toplam 64 frame vardı ve biz ilk frame deki "get(0)" videoyu oynattık. kodumuz dinamik olmuş oldu.
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        Thread.sleep(2000);


        // - youtube video'sunun frame'ini locate edelim ve frame'e switchTo() ile geçiş yapalım (farklı bir yöntemle yapalım.)
        // bu yöntemde direk oynatmak istediğimiz videonun src kodu üzerinden xpath üretip locate ediyoruz ve oynatıyoruz.
        // videonun src kodu her an değişebildiği için kodumuz geçersi hale gelebilir. Kodumuz dinamik olmaz.

        //WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //driver.switchTo().frame(youtubeFrame);


        // - youtube video sunun frame'inin içindeki play logosunu locate edelim.
        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        Thread.sleep(2000);

        // - youtube video sunun frame'inin içindeki "play" logosunu tıklayarak videoyu oynatalım.
        play.click();
        Thread.sleep(3000);

    }
}
