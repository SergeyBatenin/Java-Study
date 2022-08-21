package HomeWork4;

/*
 * Написать программу вычисляющую значение сложного арифметического выражения. Для простоты - выражение всегда вычисляемое
 * Пример: (2^3 * (10 / (5 - 3)))
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task3 {

    public static void main(String[] args) {

        String expression = "2^3 * (10 / (5 - 3))";
        System.out.println(infixToPostfix(expression));
        System.out.println();
        System.out.println(infixToPostfix("10 + 3 * 5 / (16 - 4)"));

    }

    public static int infixToPostfix(String expression) {

        Map<String, Integer> priorityOp = Map.of(
                "(", 0,
                "+", 1,
                "-", 1,
                "*", 2,
                "/", 2,
                "^", 3);

        List<String> exp = convertExpression(expression);
        System.out.println(exp);
        Deque<String> stack = new ArrayDeque<>();
        List<String> postfix = new ArrayList<>();
        for (String el : exp) {
            if (el.equals("(")) {
                stack.addLast(el);
            } else if (el.equals(")")) {
                while (!stack.peekLast().equals("(")) {
                    postfix.add(stack.pollLast());
                }
                stack.pollLast();
            } else if (priorityOp.containsKey(el)) {
                if (!stack.isEmpty() && priorityOp.get(stack.peekLast()) >= priorityOp.get(el)) {
                    postfix.add(stack.pollLast());
                }
                stack.addLast(el);
            } else {
                postfix.add(el);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pollLast());
        }
        return evaluateExpression(postfix);
    }

    private static int evaluateExpression(List<String> postfix) {

        int result = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "*", "/", "^");

        for (String s : postfix) {
            if (operators.contains(s)) {
                int op2 = stack.pollLast();
                int op1 = stack.pollLast();
                stack.addLast(calculate(s, op1, op2));
            } else {
                stack.addLast(Integer.valueOf(s));
            }
        }
        result = stack.pollLast();
        return result;

    }

    private static int calculate(String operator, int op1, int op2) {

        int result = 0;
        switch (operator) {
            case "+" -> result = op1 + op2;
            case "-" -> result = op1 - op2;
            case "*" -> result = op1 * op2;
            case "/" -> result = op1 / op2;
            case "^" -> result = (int) Math.pow(op1, op2);
            default -> result = 0;
        }
        return result;
    }

    public static List<String> convertExpression(String expression) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);
            if (currentSymbol == ' ') {
                continue;
            } else if (Character.isDigit(currentSymbol)) {
                sb.append(currentSymbol);
                // Как можно вот это условие в if переписать более красиво что ли или читабельнее
                // А то мне почему то кажется, что оно очень плохо читаемо, но не придумал как лучше
                if (!((i < expression.length() - 1) && Character.isDigit(expression.charAt(i + 1)))) {
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                result.add(String.valueOf(currentSymbol));
            }
        }
        return result;
    }
}
