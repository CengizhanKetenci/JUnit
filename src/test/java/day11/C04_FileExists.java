package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {

    @Test
    public void test1() {
        // şu an içinde olduğumuz yolu gösterir.
        System.out.println(System.getProperty("user.dir")); // C:\comBatch81JUnit

        // geçerli kullanıcının ana dizinini verir.
        System.out.println(System.getProperty("user.home"));  // C:\Users\PC

        String farkliBolum = System.getProperty("user.home");
        // masaüstündeki dosyanın yolu C:\Users\PC\OneDrive\Masaüstü
        String ortakBolum = "\\OneDrive\\Masaüstü\\text.txt";

        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // masaüstündeki dosya yolunu gösterir.

        System.out.println("*"+masaUstuDosyaYolu); // C:\Users\PC\OneDrive\Masaüstü\text.txt
        System.out.println("***"+Files.exists(Path.of(masaUstuDosyaYolu)));  // true
        Assert.assertTrue(Files.exists(Path.of(masaUstuDosyaYolu)));

        // kısa yol

        String dosyaYolu = "C:\\Users\\PC\\OneDrive\\Masaüstü\\text.txt"; // dosya üzerinde shift+sağ click.
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine SHIFT tusuna basılı olarak sağ click yapıp (SHIFT+SAg CLICK)
        dosyanın yolunu kopyalayıp bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); konudu kullanırız.
         */


    }
}
