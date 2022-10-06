package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/main/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // oluşturmuş olduğumuz dosyayı sistemde işleme alır.

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-Turkce baskentler sutununu yazdiralim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum(); // getLastRowNum() işlem gören son satır numarasını verir.
        System.out.println("Satır Sayısı = " + sonSatir);

        String turkceBaskentler = "";
        for (int i = 0; i <= sonSatir ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }
        // lambda ile yapalım
        int sonSatir2 = workbook.getSheet("Sayfa1").getLastRowNum();
        List<String> list=new ArrayList<>();
        for (int i = 0; i <=sonSatir2 ; i++) {
            list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        list.forEach(t-> System.out.println(t));


    }
}
