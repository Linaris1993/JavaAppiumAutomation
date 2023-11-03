import lib.CoreTestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest extends CoreTestCase {
    @Before
    public void textStartTest() {
        System.out.println("Start test");
    }
    @After
            public void textFinishTest() {
        System.out.println("Finish test");
    }
    MathHelper Math = new MathHelper();
    int a = 5;
    int b = 11;

    @Test
    public void myFirstTest() {
        System.out.println("First test: Before changing static int: " + MathHelper.static_int);
        MathHelper.static_int = 8;

        MathHelper mathObject = new MathHelper();
        System.out.println("First test: Before changes simple_int: " + mathObject.simple_int);
        mathObject.simple_int = 8;
    }

    @Test
    public void mySecondTest() {
        System.out.println("Second test: Before changing static int: " + MathHelper.static_int);
        MathHelper.static_int = 9;

        MathHelper mathObject = new MathHelper();
        System.out.println("Second test: Before changes simple_int: " + mathObject.simple_int);
        mathObject.simple_int = 8;
    }
public void typeStartMessage() {
        //if you remove super - it will execute only code from here
        //super.typeStartMessage(); //super means 1st it will execute code from parent class, then whats here
        //System.out.println("Current class is MainTest");
}
    @Test
    public void MyThirdTest() {
        this.typeStartMessage();
    }

    @Test
    public void MyFourthTest() {
        this.typeStartMessage();
    }

    @Test
    public void MyFifthTest() {
        this.assertFail();
    }

    private void assertFail() {
        Assert.fail("This message will be printed");
    }

    @Test
    public void MySixTest() {
       int expected = 25;
       int actual = 5 * 5;
      Assert.assertTrue("5 * 5 != 25", actual == expected);
       }
    }

//    public void myFirstTest() {
        //   double number = 10.0/3.0;
//      int a = 10;
//      int b = 15;
//    if (a > b) {
//    System.out.println("this will never happen");
//    } else {
//    System.out.println("This is what will happen");
//    }
//    System.out.println(number);
//       System.out.println(a);
//       System.out.println(b);
//       System.out.println(this.a);
//       System.out.println(this.b);

//
//        if (a == 10) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
//    }
//}
