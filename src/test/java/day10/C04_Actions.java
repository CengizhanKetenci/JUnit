package day10;

import Utilities.TestBase_Before_After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBase_Before_After {

    @Test
    public void test1() throws Exception {
        /*
        1- Yeni bir class olusturalim: MouseActions1
        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        3- Cizili alan uzerinde sag click yapalim
        4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        5- Tamam diyerek alert’i kapatalim
        6- Elemental Selenium linkine tiklayalim
        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        // aynı soruyu tek satırda aşağıdaki gibi de yazabiliriz.
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tiklayalim
        WebElement elementelSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        elementelSelenium.click();
        // yeni sayfa açıldığında aşağıdaki gibi ArrayList ile yeni sayfaya geçiş (switchTo()) yapabiliriz.
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement h1Tag = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String expectedText = "Elemental Selenium";
        String actualtext = h1Tag.getText();
        Assert.assertEquals(expectedText, actualtext);
        // aynı soruyu tek satırda aşağıdaki gibi de yazabiliriz.
        //Assert.assertEquals("You selected a context menu",driver.findElement(By.xpath("//*[text()='Elemental Selenium']")));


    }

}
