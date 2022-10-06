package day10;

import Utilities.TestBase_BeforeClass_AfterClass;
import org.junit.Test;

public class C02_TestBaseClass extends TestBase_BeforeClass_AfterClass {

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
    }

}
