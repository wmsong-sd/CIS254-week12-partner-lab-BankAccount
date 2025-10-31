/*
*A method to count how many values in an int array are smaller than some target value.
*/

public class LoopExample {
    public static int countSmaller(int[] arr, int target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < target) {
                System.out.print(arr[i] + " ");
                count++;
            }
        }
        System.out.println();


        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 5, 8, 3, 10};
        int target = 6;

        countSmaller(numbers, target);
    }
}