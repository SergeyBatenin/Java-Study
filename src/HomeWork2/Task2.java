package HomeWork2;

/*
 * Merge Sort
 */

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        int[] array = {5, 1, 4, 2, 3};
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static int[] mergeSort(int[] array) {

        int length = array.length;

        int[] sortedArray = merge(array, 0, length - 1);

        return sortedArray;
    }

    private static int[] merge(int[] array, int start, int end) {

        if (start == end) {
            return new int[]{array[start]};
        }

        int mid = (start + end) / 2;

        int[] leftPart = merge(array, start, mid);
        int[] rightPart = merge(array, mid + 1, end);

        return assembling(leftPart, rightPart);

    }

    private static int[] assembling(int[] leftPart, int[] rightPart) {

        int index = 0;

        int leftIndex = 0;
        int rigthIndex = 0;

        int leftLength = leftPart.length;
        int rigthLength = rightPart.length;

        int[] result = new int[leftLength + rigthLength];

        while (leftIndex < leftLength && rigthIndex < rigthLength) {
            if (leftPart[leftIndex] < rightPart[rigthIndex]) {
                result[index++] = leftPart[leftIndex++];
            } else {
                result[index++] = rightPart[rigthIndex++];
            }
        }

        while (leftIndex < leftLength) {
            result[index++] = leftPart[leftIndex++];
        }
        while (rigthIndex < rigthLength) {
            result[index++] = rightPart[rigthIndex++];
        }

        return result;

    }
}
