package day15;

import Utilities.TestBase_Before_After;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBase_Before_After {

    @Test
    public void test1() throws IOException {

        // amazons sayfasına gideli tüm sayfanın ekran görüntüsünü alalım.
        driver.get("http://www.rizeekspertiz.com.tr");

        /*
        bir web sayfasının resmini alabilmek için TakesScreenshot class'ından obje oluşturup,
        geçici bir File class'ından değişkene TakesScreenshot'dan oluşturduğum obje'den
        getScreenShotAS methodunu kullanarak geçici bir file oluştururuz.
         */

        TakesScreenshot ts = (TakesScreenshot) driver;

        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));
    }
}

