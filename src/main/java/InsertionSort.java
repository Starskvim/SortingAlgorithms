import java.util.Arrays;

public class InsertionSort {

//    При сортировке вставками массив постепенно перебирается слева направо. При этом каждый последующий
//    элемент размещается так, чтобы он оказался между ближайшими элементами с минимальным и максимальным значением.

    private static int countLoop;

    public static void main(String[] args) {

        int n = 25;

        int[] myArrInt = new int[n];
        for (int i = 0; i < n; i++) {
            myArrInt[i] = ((int) (Math.random() * 100) + 10);
        }


        System.out.println("shakerSort Unsort " + Arrays.toString(myArrInt));
        insertionSort(myArrInt);
        System.out.println("shakerSort Sort " + Arrays.toString(myArrInt));


    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;

            countLoop++;
            System.out.println(countLoop + " - " + Arrays.toString(array));
        }
    }
}
