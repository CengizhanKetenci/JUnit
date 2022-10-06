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

public class C02_Allerts {
    /*

    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    /*
    bir Web sitesine girdiğimizde karşımıza bir uyarı mesajı yada bir butona tıkladığımızda bir uyarı (alert) çıkabilir.
    Eğer bu uyarıya sağ tuşla "incele" (inspect) yapabiliyorsak bu bir HTML Allert'tüdür ve Locate alabiliriz.
    Fakat, gelen uyarı kutusuna sağ tuşla müdahale edemiyorsak, incele deyip locate alamıyorsak bunlar JS Allert'dür
    JS Allert'lere müdahala edebilmek için ;
    - "tamam" yada "ok" diyebilmek için - driver.switchTo().alert().accept(); - methodu kullanılır.
    - "iptal" demek için - driver.switchTo().alert().accept(); - methodu kullanılır.
    - allert içindeki mesajı metin olarak almak için - driver.switchTo().alert().getText(); - methodu kullanılır
    - Allert 'e biz bir metin göndermek istiyorsak - driver.switchTo().alert().sendKeys("") - methodu kullanılır.
   */
    WebDriver driver;
    @Before
    public void before() throws Exception {
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
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // 1. butona tıklayın
        WebElement alertButton = driver.findElement(By.xpath("//*[@onclick='jsAlert()']"));
        alertButton.click();
        Thread.sleep(2000);

        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // ve result mesajının  “You successfully clicked an alert” oldugunu test edin.

        WebElement mesaj= driver.findElement(By.xpath("//*[@id='result']"));

        String expectedMesaj = "You successfully clicked an alert";
        String actualMesaj = mesaj.getText();

        Assert.assertTrue(actualMesaj.equals(expectedMesaj));

    }
    @Test
    public void test2() throws Exception {

        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // JS Confirm butona tıklayın,

        WebElement JSConfirm= driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        JSConfirm.click();
        Thread.sleep(1000);

        // çıkan uyarı kutusundaki metni yazdırın.
        System.out.println("JSConfirm Alert Mesajı : " + driver.switchTo().alert().getText());

        // uyarı kutusundaki seceneklerden "Cancel" butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);

        // result mesajının “successfuly” icermedigini test edin.
        WebElement resultYazisi = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedMesaj = "successfuly";
        Assert.assertFalse(resultYazisi.getText().contains(expectedMesaj) );
    }
    @Test
    public void test3() throws Exception {

        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // JS Promt butonuna (3.Buton) tıklayın,
        WebElement JSPrompt= driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        JSPrompt.click();
        Thread.sleep(1000);

        // Alert kutusundaki metni konsola yazdırın
        System.out.println("Alert Metni = " + driver.switchTo().alert().getText());

        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Cengizhan Ketenci");
        Thread.sleep(1000);

        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        // result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));

        String expectedMesaj = "Cengizhan Ketenci";
        String actualResult =  result.getText();

        Assert.assertTrue(actualResult.contains(expectedMesaj));

    }
}
