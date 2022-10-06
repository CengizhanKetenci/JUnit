package day11;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends TestBase_Before_After {
    @Test
    public void test1() {
        /*
        1- https://www.facebook.com adresine gidelim
        2- Yeni hesap olustur butonuna basalim
        3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        4- Kaydol tusuna basalim
         */
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //Actions actions = new Actions(driver);

        // 2- Yeni hesap olustur butonuna basalim
        WebElement hesapOlustur = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        hesapOlustur.click();


        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Cengizhan");
        actions.sendKeys(Keys.TAB).sendKeys("Ketenci").
                sendKeys(Keys.TAB).sendKeys("cengizhanketenci79@gmail.com").
                sendKeys(Keys.TAB).sendKeys("cengizhanketenci79@gmail.com").
                sendKeys(Keys.TAB).sendKeys("sifrem").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("20").
                sendKeys(Keys.TAB).sendKeys("01").
                sendKeys(Keys.TAB).sendKeys("1980").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        // 4- Kaydol tusuna basalim

    }
}
