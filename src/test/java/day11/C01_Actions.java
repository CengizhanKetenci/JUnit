package day11;

import Utilities.TestBase_Before_After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Actions extends TestBase_Before_After {
    @Test
    public void test1() {
        /*
        Bir Class olusturalim KeyboardActions1
        1- https://www.amazon.com sayfasina gidelim
        2- Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        3- aramanin gerceklestigini test edin
         */
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        // 2- Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").sendKeys("1").
                sendKeys(Keys.ENTER).
                perform();


        // 3- aramanin gerceklestigini test edin
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(sonuc.isDisplayed());



    }
}
