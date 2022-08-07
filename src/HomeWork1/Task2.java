package HomeWork1;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(numbers, val));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int count = 0;
//        for (int i = 0; i < length; i++) {      // посмотрел чужие решения на литкоде и понял свою ошибку)
//            if (i+count == length) break;       // Есть у меня дурная привычка все усложнять)) вместо того
//            if (nums[i] == val) {               // чтобы считать нужное, считаю ненужное)
//                nums[i] = nums[length - 1 - count];
//                nums[length - 1 - count] = val;
//                count++;
//                i--;
//            }
//        }
//        //System.out.println(Arrays.toString(nums));
//        return length - count;

        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return count;
    }
}
