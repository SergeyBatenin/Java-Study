package HomeWork2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 */
public class Task1 {
    //static List<Integer> temp = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println(combine(4, 2));
        result.clear();
        System.out.println(combine(1, 1));
    }

    public static List<List<Integer>> combine(int n, int k) {

        generate(n, k, 1, new ArrayList<Integer>());

        return result;
    }

    public static void generate(int n, int k, int prevElement, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = prevElement; i <= n; i++) {
            temp.add(i);
            generate(n, k, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
