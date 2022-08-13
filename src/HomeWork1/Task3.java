package HomeWork1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String s = " a   good     example";
        System.out.println(reverseWords(s));
        s = "something";
        System.out.println(reverseWords(s));
    }
//Input: s = "the sky is blue"
//Output: "blue is sky the" исключая пробелы в начале в конце, двойные пробелы между словами
    public static String reverseWords(String s) {
        //Первый вариант
//        s = s.replaceAll("( +)"," ").trim();
//        String[] words = s.split(" ");
//        int length = words.length;
//        for (int i = 0; i < length/2; i++) {
//            String temp = words[length-1-i];
//            words[length-1-i] = s1[i];
//            words[i] = temp;
//        }
//        return String.join(" ", s1);

        // Второй вариант
//        String[] words=s.split("\\s+");
//        System.out.println(Arrays.toString(words));
//        StringBuilder sb = new StringBuilder();
//        for (int i = words.length - 1; i >= 0; i--) {
//            sb.append(words[i]).append(" ");
//        }
//        return sb.toString().strip();

        StringBuilder sb = new StringBuilder();
        //Вариант 3, поздно заметил что split нельзя))
//        String result = "";
//        s = s.trim(); // про trim ничего не сказано))
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c != ' ') {
//                sb.append(c);
//            } else if (sb.toString() != "") {
//                result = sb.toString() + " " + result;
//                sb.delete(0, sb.length());
//            }
//        }
//        result = sb.toString() + " " + result;
//        return result.trim();

        //Вариант 4 в двумя указателями
        int endWord = s.length() - 1;
        while (endWord >= 0) {
            if (s.charAt(endWord) == ' ') {
                endWord--;
                continue;
            }
            int startWord = endWord - 1;
            while (startWord >= 0 && s.charAt(startWord) != ' ') {
                startWord--;
            }
            sb.append(s.substring(startWord + 1, endWord + 1) + " ");
            endWord = startWord - 1;
        }
        sb.delete(sb.length()- 1, sb.length());
        return  sb.toString();

    }
}
