package day14;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcell {

    @Test
    public void readExcellTest1() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/main/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // oluşturmuş olduğumuz dosyayı sistemde işleme alır.

        //- Workbook objesi olusturalim,parametre olarak fileInputStream objesini girelim.
        Workbook workbook = WorkbookFactory.create(fis); // Workbook objesiyle, fis objesi ile akışa aldığımız dosyamıza bir excell dosyası create ettik.

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)
        String actualData = workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println("actualData = " + actualData);


    }
}
