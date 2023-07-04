package calculator;

//package practiceProject2;
import java.util.Scanner;

//import javafsd_package.PracticeProject2Arithmeticcalculator;
public class Calculator {
	private final double result;
	public Calculator(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operator!");
                result = Double.NaN;
                break;
        }
    }

    public double getResult() {
        return this.result;
    }

    private double add(double num1, double num2) {
        return num1 + num2;
    }

    private double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error! Division by zero is not allowed.");
            return Double.NaN;
        } else {
            return num1 / num2;
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        double num1 = scanner.nextDouble();

	        System.out.print("Enter second number: ");
	        double num2 = scanner.nextDouble();

	        System.out.print("Enter an operator (+, -, *, /): ");
	        char operator = scanner.next().charAt(0);

	        Calculator calculator = new Calculator(num1, num2, operator);

	        System.out.println("Result: " + calculator.getResult());

	        scanner.close();


	}

}

