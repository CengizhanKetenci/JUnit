package day16;

import Utilities.TestBase_Before_After;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class C01_GetScreenShotWE extends TestBase_Before_After {

    @Test
    public void test1() throws IOException {

        // amazon sayfasına gidelim.
        driver.get("https://www.amazon.com");

        // nutella aratalım.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        // arama sonucu webelementi'nin resmini alalım.
        WebElement resultWE = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File result = resultWE.getScreenshotAs(OutputType.FILE);

        // sadece WebElementin resmini alacak isek TakesScreenshot class'ına ihtiyacımız yok.
        // Locate ettiğimiz webelementi direkt geçici bir file'a atayıp FileUtils ile kopyalayıp yolunu belirtiriz.

        FileUtils.copyFile(result, new File("target/ekranGoruntusuWE/WebESS"+tarih+".jpeg"));
    }
}
