public class MathHelper {
public int simple_int = 7;
public static int static_int = 7; //for static we don't need to create an object of class

final public int simple_int2 = 7;
final public static int static_int2 = 7;
public void changeSimpleInt() {
    this.simple_int = 8; //will work
    static_int = 8; //will work
    //this.simple_int2 = 0; //will not work cause its define as final  (means can't be changed)
    //this.static_int2 = 0; //will not work cause its define as final  (means can't be changed)
}
    public static void changeSimpleIntByStaticFunction() {
        //this.simple_int = 8; //will not work cause its static method
    }
    public int calc(int a, int b, char action) {
        if (action == '+') {
            return this.plus(a, b);
        } else if (action == '-') {
            return this.minus(a, b);
        } else if (action == '*') {
            return this.multiply(a, b);
        } else if (action == '/') {
                return this.divide(a, b);
        } else {
           return this.typeAnErrorAndReturnDefaultValues("Wrong action: " + action);
        }
    }
    private int typeAnErrorAndReturnDefaultValues (String error_message) {
        System.out.println(error_message);
        return 0;
    }
    private int plus (int a, int b) {
        return a + b;
    }
    private int minus (int a, int b) {
        return a - b;
    }
    private int multiply (int a, int b) {
        return a * b;
    }
    private int divide (int number, int divider) {
        if (divider == 0) {
            return this.typeAnErrorAndReturnDefaultValues("Cannot divide by zero");
        } else {
            return number/divider;
        }
    }

//    public int multiply(int number) {
//        return number * 2;
//    }
//    public int multiply(int number, int multiplier) {
//        return number * multiplier;
//    }
}
