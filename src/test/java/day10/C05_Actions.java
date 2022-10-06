package day10;

import Utilities.TestBase_Before_After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_Actions extends TestBase_Before_After {
    @Test
    public void test1() throws Exception {
        /*
        1-Yeni bir class olusturalim: MouseActions2
        2-https://demoqa.com/droppable adresine gidelim
        3-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        4-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
         */
        //  1-Yeni bir class olusturalim: MouseActions2
        //  2-https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // 3-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();

        // 4-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dreppoed = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expected = "Dropped!";
        String actual = dreppoed.getText();
        Assert.assertEquals(expected, actual);
    }

}
