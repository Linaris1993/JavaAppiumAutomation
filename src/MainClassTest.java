import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    MainClass MainClassObject = new MainClass();

    @Test
    public void testGetLocalNumber() {
        Assert.assertTrue("Local number is not 14", MainClassObject.getLocalNumber == 14);
    }

    @Test
    public void testGetClassNumber() {
        Assert.assertTrue("Class_number is less than 45", MainClassObject.getClassNumber() > 45);
    }

    public String substring1 = "hello";
    public String substring2 = "Hello";

    @Test
    public void testGetClassString() {
        if (MainClassObject.getClassString().contains(this.substring1) || MainClassObject.getClassString().contains(this.substring2)) {
            System.out.println("String contains 'hello' or 'Hello'");
        } else {
            Assert.fail("String doesn't contain 'hello' or 'Hello'");
        }
    }
}
