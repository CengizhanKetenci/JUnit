package practice04;

import Utilities.TestBase_Before_After;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02 extends TestBase_Before_After {

    // Verify that we have pom.xml file in our project => please try in 4 min s


    @Test
    public void verify() {

        String dosyaYolu = "pom.xml";
        Assert.assertTrue(Files.exists(Path.of(dosyaYolu)));

        // veya Absolute path ile yapalım;
        String dosyaYoluAbsolute = "C:\\comBatch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluAbsolute)));



    }

    }
