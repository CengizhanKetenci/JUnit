package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim.
    - Click fpr JS Allert butonunu tıklayın
    - tıkladıktan sonra çıkan uyarı mesajına (Allert) tamam diyelim.
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
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // - Click fpr JS Allert butonunu tıklayın
        WebElement alertButton = driver.findElement(By.xpath("//*[@onclick='jsAlert()']"));
        alertButton.click();
        Thread.sleep(1000);

        // - tıkladıktan sonra çıkan uyarı mesajındaki metni yazdıralım.
        System.out.println("JS Alert = " + driver.switchTo().alert().getText());
        Thread.sleep(1000);

        // - JS Alert butonuna tıkladıktan sonra çıkan uyarı mesajına tamam diyelim.
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        // - JS Confirm Butonuna tıkladıktan sonra çıkan uyarı mesajına (Allert) iptal diyelim.
        WebElement confirmButton = driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        confirmButton.click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);



    }

}
