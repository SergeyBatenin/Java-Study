package HomeWork5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>(nums1.length);
        Map<Integer, Integer> num1 = new HashMap<>();

        for (int item : nums1) {
            num1.putIfAbsent(item, 0);
            num1.put(item, num1.get(item) + 1);
        }
        for (int item : nums2) {
            if (num1.containsKey(item) && num1.get(item) > 0) {
                res.add(item);
                num1.put(item, num1.get(item) - 1);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
