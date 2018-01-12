package classwork.lesson2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by eprupetw6980 on 12/01/2018.
 */
public class DPTest {

    @DataProvider
    public Object[][] dp() {
        return new Object[][]{{1, "string1"},{2, "string2"}};
    }

    @Test(dataProvider = "dp")
    public void dpTest(int i, String s) {
        System.out.println("int: " + i + " " + "String: " + s);
    }
}
