import java.util.Arrays;

public class SelectionSort {

//    Сначала нужно рассмотреть подмножество массива и найти в нём максимум (или минимум).
//    Затем выбранное значение меняют местами со значением первого неотсортированного элемента.
//    Этот шаг нужно повторять до тех пор, пока в массиве не закончатся неотсортированные подмассивы.

    private static int countLoop;

    public static void main(String[] args) {

        int n = 25;

        int[] myArrInt = new int[n];
        for (int i = 0; i < n; i++) {
            myArrInt[i] = ((int) (Math.random() * 100) + 10);
        }

        System.out.println("selectionSort Unsort " + Arrays.toString(myArrInt));
        selectionSort(myArrInt);
        System.out.println("selectionSort Sort " + Arrays.toString(myArrInt));


    }

    public static void selectionSort(int[] arr) {
        for (int min = 0; min < arr.length - 1; min++) {

            int least = min;

            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;

            countLoop++;
            System.out.println(countLoop + " - " + Arrays.toString(arr));
        }
    }
}
