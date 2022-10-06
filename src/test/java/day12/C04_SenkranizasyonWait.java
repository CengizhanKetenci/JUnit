package day12;

import Utilities.TestBase_Before_After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C04_SenkranizasyonWait extends TestBase_Before_After {
    @Test
    public void test1() {

        /*
        https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        Textbox’in etkin olmadigini(enabled) dogrulayın
        Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Textbox’in etkin oldugunu(enabled) dogrulayın.
         */
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox’in etkin olmadigini(isEnabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enable = driver.findElement(By.xpath("//*[text()='Enable']"));
        enable.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));


        //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabled = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsEnabled.isDisplayed());

        //Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());

    }
}
