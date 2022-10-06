package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {

    /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
    */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasina gidelim.
        driver.get("https://www.amazon.com/");

        // 2- arama kutusunu locate edelim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(1000);

        // 3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones");
        WebElement clickButonu = driver.findElement(By.id("nav-search-submit-button"));
        clickButonu.click();
        Thread.sleep(1000);

        // 4- Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("arama Sonuc Sayisi = " + aramaSonucSayisi.getText());
        String [] aramaSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("aramaSonucSayisi = " + aramaSayisi[2]);

        // 5- Ilk urunu tiklayalim.
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@class=\"a-section aok-relative s-image-fixed-height\"]"));
        ilkUrun.click();
        Thread.sleep(1000);

        // 6- Sayfadaki tum basliklari yazdiralim.
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("h1 Ana Başlıklar : "+driver.findElement(By.xpath("//h1")).getText());
        System.out.println("h2 Başlıklar : "+driver.findElement(By.xpath("//h2")).getText());
        System.out.println("h3 Başlıklar : "+driver.findElement(By.xpath("//h3")).getText());
        /*
        6- Sayfadaki tum basliklari yazdiralim
        for (int i = 1; i <=6 ; i++) {
            List<WebElement> basliklar=driver.findElements(By.tagName("h"+i));
            basliklar.stream().forEach(t-> System.out.println(t.getText()));
        }
         */

        // 7- sayfayı kapat
        driver.close();


    }

}
