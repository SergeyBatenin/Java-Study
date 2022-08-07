package HomeWork1;

import java.util.Arrays;

//Input: arr = [1,0,2,3,0,4,5,0]
//Output:      [1,0,0,2,3,0,0,4]
public class Task1 {
    public static void main(String[] args) {
        int[] array = {1,0,2,3,0,4,5,0};
        //int[] array = {0,0,0,0,0,0,0};
        duplicateZeros(array);
        System.out.println(Arrays.toString(array));
    }
    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i+1 ; j--) {
                    arr[j] = arr[j-1];
                }
                if (i < (arr.length - 1)) arr[++i] = 0;
            }
        }
    }
}
