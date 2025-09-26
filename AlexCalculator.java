
import java.util.*;

// Calculator abstract class
abstract class Calculator {

    abstract int add(int a, int b);
}

// Adder class
class Adder extends Calculator {

    @Override
    int add(int a, int b) {
        System.out.println("Adding Integers : " + a + " " + b);
        return a + b;
    }
}

// Multiplier class in which add method is called b times
class Multiplier {

    int multiply(int a, int b, Calculator calculator) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = calculator.add(result, a);
        }
        return result;
    }
}

public class AlexCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create Adder and Multiplier objects
        Adder adder = new Adder();
        Multiplier multiplier = new Multiplier();

        // Input two numbers
        System.out.print("Enter first number : ");
        int a = sc.nextInt();
        System.out.print("Enter second number : ");
        int b = sc.nextInt();
        // Test addition
        System.out.println("Testing Addition :");
        int sum = adder.add(a, b);
        System.out.println("Sum: " + sum);
        // Test multiplication
        System.out.println("Testing Multiplication : ");
        int product = multiplier.multiply(a, b, adder);
        System.out.println("Product: " + product);
        sc.close();
    }
}
