package day11;

import Utilities.TestBase_Before_After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBase_Before_After {

    @Test
    public void test1() {
        /*
        Tests packagenin altina bir class oluşturalim : C04_FileDownload
        Iki tane metod oluşturun : isExist( ) ve downloadTest( )
        downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        https://the-internet.herokuapp.com/download adresine gidelim.
        test.txt dosyasını indirelim
        Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
         */

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // test.txt dosyasını indirelim
        WebElement text = driver.findElement(By.xpath("//*[text()='test.txt']"));
        text.click();

        // Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu ="C:\\Users\\PC\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // indirildiğini konsol da gösterin.
        System.out.println(Files.exists(Paths.get(dosyaYolu)));  // true



        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
