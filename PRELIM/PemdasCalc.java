import java.util.Scanner;
import java.util.Stack;

class Calculator {
    private double result;

    public Calculator() {
        result = 0.0;
    }

    public double getResult() {
        return result;
    }

    public void evaluateExpression(String expression) {
        try {
            Stack<Double> operandStack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>();
            int index = 0;

            while (index < expression.length()) {
                char currentChar = expression.charAt(index);

                if (Character.isDigit(currentChar)) {
                    StringBuilder numBuilder = new StringBuilder();
                    while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
                        numBuilder.append(expression.charAt(index));
                        index++;
                    }
                    double operand = Double.parseDouble(numBuilder.toString());
                    operandStack.push(operand);
                } else if (currentChar == '(') {
                    operatorStack.push(currentChar);
                    index++;
                } else if (currentChar == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        performOperation(operandStack, operatorStack);
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                        operatorStack.pop();
                    }
                    index++;
                } else if (isOperator(currentChar)) {
                    while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), currentChar)) {
                        performOperation(operandStack, operatorStack);
                    }
                    operatorStack.push(currentChar);
                    index++;
                } else {
                    System.out.println("Invalid character in expression: " + currentChar);
                    return;
                }
            }

            while (!operatorStack.isEmpty()) {
                performOperation(operandStack, operatorStack);
            }

            if (operandStack.size() == 1) {
                result = operandStack.pop();
                System.out.println("Result: " + result);
            } else {
                System.out.println("Invalid expression.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int getOperatorPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private boolean hasHigherPrecedence(char operator1, char operator2) {
        return getOperatorPrecedence(operator1) >= getOperatorPrecedence(operator2);
    }

    private void performOperation(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = applyOperator(operand1, operand2, operator);
        operandStack.push(result);
    }

    private double applyOperator(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("illegal operator: " + operator);
        }
    }
}

public class PemdasCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        

        while (true) {
            System.out.println("Enter an expression: ");
            System.out.print("<-> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            calculator.evaluateExpression(input);
        }
    }
}