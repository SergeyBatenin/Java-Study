package HomeWork5;

import java.util.Map;

public class RomanNumbers {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s)); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> value = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0;
        int length = s.length() - 1;
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            if (value.get(current) >= value.get(s.charAt(i + 1))) {
                result += value.get(current);
            } else {
                result -= value.get(current);
            }
        }
        result += value.get(s.charAt(length));
        return result;
    }
}