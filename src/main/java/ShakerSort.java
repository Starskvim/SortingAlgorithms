import java.util.Arrays;

public class ShakerSort {

//    Шейкерная сортировка отличается от пузырьковой тем, что она двунаправленная: алгоритм перемещается не строго
//    слева направо, а сначала слева направо, затем справа налево.

    private static int countLoop;

    public static void main(String[] args) {

        int n = 25;

        int[] myArrInt = new int[n];
        for (int i = 0; i < n; i++) {
            myArrInt[i] = ((int) (Math.random() * 100) + 10);
        }


        System.out.println("shakerSort Unsort " + Arrays.toString(myArrInt));
        shakerSort(myArrInt);
        System.out.println("shakerSort Sort " + Arrays.toString(myArrInt));

    }

    public static void shakerSort(int[] arr) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;

            countLoop++;
            System.out.println(countLoop + " - " + Arrays.toString(arr));

        } while (left < right);
    }
}
