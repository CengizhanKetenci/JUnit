package day14;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel_Odev {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/main/resources/ulkeler2.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 6
        int expectedSatirSayi = 6;
        int actualSatirSayi= workbook.getSheet("Sayfa2").getLastRowNum();
        int sonsatir = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("sonsatir = " + (sonsatir+1));

        Assert.assertEquals(expectedSatirSayi, actualSatirSayi+1);

        // kullanilan satir sayisinin ise 3 oldugunu test edin
        int expectedKullanilanSatirSayisi = 3;
        int kullanilanSatirSayi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayi = " + kullanilanSatirSayi);
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayi);
    }
}
