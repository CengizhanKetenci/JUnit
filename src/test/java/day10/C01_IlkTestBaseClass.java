package day10;

import Utilities.TestBase_Before_After;
import org.junit.Test;

public class C01_IlkTestBaseClass extends TestBase_Before_After {

    @Test
    public void test1() throws Exception {
        driver.get("https://www.amazon.com");
    }
}
