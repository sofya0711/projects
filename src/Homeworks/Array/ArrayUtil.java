package Homeworks.Array;

public class ArrayUtil {

    public static void main(String[] args) {

        int[] array = {2, 5, 8, 10, 32, 22, 11, 66, 12, 30};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Max= " + max);

        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Min= " + min);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();

        int evenCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenCount = evenCount + 1;
            }
        }
        System.out.println("Even num count " + evenCount);

        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddCount = oddCount + 1;
            }
        }
        System.out.println("Odd num count " + oddCount);

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("Sum=" + sum);
        System.out.println("The arithmetic average= " + sum / array.length);


    }
}
