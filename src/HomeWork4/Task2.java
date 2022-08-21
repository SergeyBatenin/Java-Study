package HomeWork4;

// Valid Parentheses

import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        System.out.println(isValid("(<>)"));
        System.out.println(isValid("()[<]{}"));
        System.out.println(isValid("()[>]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{a}[+]{(d*3)}"));

    }

    public static boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        // Словарь для проверки пары
        Map<Character, Character> dict = Map.of('(',')', '[', ']', '{', '}', '<', '>');
        // набор скобок, которые добавляем в стэк
        Set<Character> collection = Set.of('(', '[', '{', '<');
        // Обрабатываем входящую строку и удаляем из нее все элементы кроме различных скобок
        String data = s.replaceAll("[^\\[\\]<>(}{)]", "");

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < data.length(); i++) {
            char current = data.charAt(i);
            if (collection.contains(current)) {
                stack.addLast(current);
            } else {
                if (!stack.isEmpty()) {
                    char lastElementStack = stack.peekLast();
                    if (dict.get(lastElementStack).equals(current)) {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
