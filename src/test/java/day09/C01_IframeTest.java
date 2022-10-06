package day09;

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

public class C01_IframeTest {

    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */

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

        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement IframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(IframeYazisi.isDisplayed());
        System.out.println("IframeYazisi.getText() = " + IframeYazisi.getText());

        // textBox'a "merhaba dünya" yazdırın.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(textBox);

        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        Thread.sleep(1000);
        textBoxFrame.clear();
        Thread.sleep(1000);
        textBoxFrame.sendKeys("merhaba dünya");

// TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // bir önceki soru için içine girdiğimiz iframe den anasayfa'ya çıkmak için bu kodu kullanırız.
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println("elementalSelenium.getText() = " + elementalSelenium.getText());


    }
}
