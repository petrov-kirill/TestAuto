package homework.homework2;

import org.testng.annotations.Test;

@Test(groups = {"Smoke"})
public class Exercise2_1 {

/*          1. Create 3 new test classes and place there from 2 up to 4 tests (copy your already existed tests).
            2. Tests from the first class are included to group “Smoke”
            3. Tests from the second class are included to group “Regression”
            4. Tests from the third class are included to group “Smoke” и “Regression”
            5. Create two TestNg config files, the first one runs all “Smoke” test, the second runs “Regression”.*/


    public void simpleTest1() {
        System.out.println("simple test #1, group = Smoke");
    }

    public void simpleTest2() {
        System.out.println("simple test #2, group = Smoke");
    }

    public void simpleTest3() {
        System.out.println("simple test #3, group = Smoke");
    }

}
