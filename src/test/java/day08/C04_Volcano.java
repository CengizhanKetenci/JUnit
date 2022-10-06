package day08;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Volcano extends TestBase_Before_After {
    @Test
    public void volkano() {

        // - https://html.com/tags/iframe/ adresine gidelim.
        driver.get("https://html.com/tags/iframe/");

        // - youtube video'sunun frame'ini locate edelim ve frame'e switchTo() ile geçiş yapalım
        // (en çok tercih edilen yöntemle yapalım)

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));

        // - youtube video sunun frame'inin içindeki play logosunu locate edelim.
        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));


        // - youtube video sunun frame'inin içindeki "play" logosunu tıklayarak videoyu oynatalım.
        play.click();
    }
}
