import java.util.Scanner;
public class myCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Operator (+, -, *, ., x, /)");
        char operator = scanner.next().charAt(0);

        System.out.println("Second Number: ");
        double num2 = scanner.nextDouble();

        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '.':
                result = num1 * num2;
                break;

            case 'x':
                result = num1 * num2;
                break;

            case '/':
                if (num2 !=0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Syntax Error");
                    return;
                }
                break;

            default:
                System.out.println("Invalid Input");
                return;
        }

        System.out.println("Result: " + result);
    }
}