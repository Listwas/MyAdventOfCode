package com.github.listwas;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n**********************************");
                System.out.println("*           calc app             *");
                System.out.println("**********************************");
                System.out.println("*   write expression eg 2 + 2    *");
                System.out.println("*  available operators: * / + -  *");
                System.out.println("**********************************");
                System.out.print("* input: ");

                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] operators = {"*", "/", "+", "-"};
                String operator = null;

                // find operator
                for (String op : operators) {
                    if (input.contains(op)) {
                        operator = op;
                        break;
                    }
                }

                if (operator == null) {
                    System.out.println("error: no valid operator found");
                    continue;
                }

                String[] operands = input.split("\\s*" + Pattern.quote(operator) + "\\s*");
                if (operands.length != 2) {
                    System.out.println("error: invalid expression format");
                    continue;
                }

                // assign numbers
                float num1, num2, result = 0;
                try {
                    num1 = Float.parseFloat(operands[0]);
                    num2 = Float.parseFloat(operands[1]);
                } catch (NumberFormatException e) {
                    System.out.println("error: invalid number format");
                    continue;
                }

                // calculate result
                switch (operator) {
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("error: division by zero");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    default:
                        System.out.println("error: unknown operator");
                        continue;
                }

                System.out.printf("* result: %.2f %s %.2f = %.2f\n", num1, operator, num2, result);
                System.out.print("* type exit/continue (E/C): ");
                char bottom = scanner.nextLine().toUpperCase().charAt(0);

                if (bottom == 'E') {
                    break;
                }

            } catch (Exception e) {
                System.out.println("unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
