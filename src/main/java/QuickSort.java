import java.util.Arrays;

public class QuickSort {

//    Сначала из массива нужно выбрать один элемент — его обычно называют опорным. Затем другие элементы в массиве
//    перераспределяют так, чтобы элементы меньше опорного оказались до него, а большие или равные — после.
//    А дальше рекурсивно применяют первые два шага к подмассивам справа и слева от опорного значения.

    private static int countLoop;

    public static void main(String[] args) {

        int n = 25;

        int[] myArrInt = new int[n];
        for (int i = 0; i < n; i++) {
            myArrInt[i] = ((int) (Math.random() * 100) + 10);
        }
        Double[] myArrDouble = new Double[n];
        for (int i = 0; i < n; i++) {
            myArrDouble[i] = Math.random();
        }
        Integer[] myArrInteger = new Integer[n];
        for (int i = 0; i < n; i++) {
            Integer number = ((int) ((Math.random() * 100) + 10));
            myArrInteger[i] = number;
        }

        System.out.println("quickSort Unsort " + Arrays.toString(myArrInt));
        quickSort(myArrInt, 0, myArrInt.length - 1);
        System.out.println("quickSort Sort " + Arrays.toString(myArrInt));

    }


    public static void quickSort(int[] array, int low, int high) {

        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, которые больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;

                countLoop++;
                System.out.println(countLoop + " - " + Arrays.toString(array));
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }





}
