package day12;

import Utilities.TestBase_Before_After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_SenkranizasyonWait extends TestBase_Before_After {

    @Test
    public void implicitlyWaitTest1() {

       //Bir class olusturun : WaitTest
       //Iki tane metod olusturun : implicitWait() , explicitWait()
       //Iki metod icin de asagidaki adimlari test edin.

        /*
       imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
       max belirttiğimiz süre altında bütün web elementler için bekler
       */

       //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
       driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       //Remove butonuna basin.
        WebElement remove = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        remove.click();

       //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneWE = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        System.out.println("gone.isDisplayed() = " + itsGoneWE.isDisplayed());

        //Add buttonuna basin
        WebElement add = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        add.click();

       //It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsBackWE.isDisplayed());
        System.out.println("back.isDisplayed() = " + itsBackWE.isDisplayed());


    }

    @Test
    public void explicitlyWaitTest2() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        WebElement remove = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        remove.click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        System.out.println("gone.isDisplayed() = " + itsGoneWE.isDisplayed());


          /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */

        //Add buttonuna basin
        WebElement add = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        add.click();

        //It’s back mesajinin gorundugunu test edin
       //WebElement itsBackWE = driver.findElement(By.xpath("//*[@id='message']"));
       WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
       Assert.assertTrue(itsBackWE.isDisplayed());
       System.out.println("back.isDisplayed() = " + itsBackWE.isDisplayed());
    }
}
