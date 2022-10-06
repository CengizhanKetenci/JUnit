package day12;

import Utilities.TestBase_Before_After;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_odevler extends TestBase_Before_After {

    @Test
    public void test1() {
        /*
        1-“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        2-“Our Products” butonuna basin
        3-“Cameras product”i tiklayin
        4-Popup mesajini yazdirin
        5-“close” butonuna basin
        6-"WebdriverUniversity.com (IFrame)" linkini tiklayin
        7-"http://webdriveruniversity.com/index.html" adresine gittigini test edin
         */
        // 1- “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2- “Our Products” butonuna basin
        WebElement frameGecis=driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(frameGecis);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();

        // 3- “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        // 4- Popup mesajini yazdirin  //h4[@class='modal-title'] , //div[@class='modal-body']
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='modal-title']"))).getText();
        String popUpMesaji=driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']"))).getText();
        String pupUPMesaji2=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();

        System.out.println(popUpMesaji+"\n"+pupUPMesaji2);

        // 5- “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        // 6- "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("WebdriverUniversity.com (IFrame)")));
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        // 7- "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='CONTACT US']")).isDisplayed());
    }

    @Test
    public void test2() {
        /*
        "http://webdriveruniversity.com/Actions" sayfasina gidin
        "Hover over Me First" kutusunun ustune gelin
        "Link 1" e tiklayin
        Popup mesajini yazdirin
        Popup'i tamam diyerek kapatin
        "Click and hold" kutusuna basili tutun
        "Click and hold" kutusunda cikan yaziyi yazdirin
        "Double click me" butonunu cift tiklayin
         */
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        // "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        // Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldWE=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldWE).perform();

        // "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldWE.getText());

        // "Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClick).perform();

    }

    @Test
    public void test3() {

       // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

      // 2."Login Portal" a  kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

      // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        String ilkSayfa = driver.getWindowHandle();
        System.out.println("ilkSayfa = " + ilkSayfa);

        // 4.Diger Tab'a gecin
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));


      // 5."username" ve  "password" kutularina deger yazdirin
        WebElement username = driver.findElement(By.xpath("//*[@id='text']"));
        actions.sendKeys(username, "ali").perform();

        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        actions.sendKeys(username, "123456").perform();

    // 5. maddeyi faker classından yararlanarak yapalım.
      //Faker faker=new Faker();
      //WebElement usernameFaker=driver.findElement(By.xpath("//input[@id='text']"));
      //usernameFaker.sendKeys(faker.name().firstName());
      //actions.sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB,Keys.ENTER).perform();


      // 6."login" butonuna basin
        WebElement login = driver.findElement(By.xpath("//*[@id='login-button']"));
        actions.click(login).perform();


      // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertEquals("validation failed",driver.switchTo().alert().getText());

      // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

      // Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfa);

      // Ilk sayfaya donuldugunu test edin
        Assert.assertEquals("http://webdriveruniversity.com/",driver.getCurrentUrl());


    }
}
