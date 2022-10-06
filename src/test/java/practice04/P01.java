package practice04;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBase_Before_After {

    @Test
    public void test1() {

        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//div[@id='nature']//img"));
        animals.forEach(t-> t.click());


        // veya

       for (WebElement each:animals )
       {
           each.click();
       }

        // formu doldurun (dilediğinizi yazabilirsiniz)

        driver.switchTo().defaultContent(); // form kısmına gecebilmek için iframe'in dısına cıkmalıyız.

        List<WebElement> boxesList = driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));
        List<String> metin = new ArrayList<>(Arrays.asList("Türkiyenin","en","büyük","klübü","rize'nin","harika","forveti","HAKAN","cok","iyi","degil mi?"));
        for (int i = 0; i <boxesList.size() ; i++) {
            boxesList.get(i).sendKeys(metin.get(i));
        }

        // veya,
        WebElement isim = driver.findElement(By.xpath("(//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded'])[1]"));
        actions.click(isim).sendKeys("Cengizhan").sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).perform();

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
