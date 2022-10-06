package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowsHandle {

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
        //driver.quit();
    }
    @Test
    public void test1() throws Exception {
        /*
        Tests package’inda yeni bir class olusturun: WindowHandle2
https://the-internet.herokuapp.com/windows adresine gidin.
Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
Click Here butonuna basın.
Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
Sayfadaki textin “New Window” olduğunu doğrulayın.
Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

         */
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.getText().contains("Opening a new window"));

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // Click Here butonuna basın.
        WebElement clickHere = driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickHere.click();
        /*
        Bir web sitesine gittiğimizde bir web elementi tıkladığımızda yeni bir sekme veya pencere açılırsa
        bu yeni açılan sekmenin handle değerini bulabilmek için driver.getWindowHandles() methodunu bir ArrayList'e
        atıp bütün sayfaların listesine ulaşabilirim. İlk açtığım pencerenin endex'i 0'dır. ikinci açılan sekmenin index'i 1'dir.
        ikinci açılan sekmede işlem yapabilmek için "driver.switchTo().window(ListAdı.get(1))" methodunu kullanırız.
         */
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle Değerleri = " + windowList);
        driver.switchTo().window(windowList.get(1));

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(), "New Window");

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());

    }
}
