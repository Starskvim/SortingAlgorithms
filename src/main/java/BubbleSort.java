import java.util.Arrays;

public class BubbleSort {

//    Здесь нужно последовательно сравнивать значения соседних элементов и менять числа местами, если предыдущее
//    оказывается больше последующего. Таким образом элементы с большими значениями оказываются в конце списка,
//    а с меньшими остаются в начале.

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



        System.out.println("bubbleSort Unsort " + Arrays.toString(myArrDouble));
        bubbleSortD(myArrDouble);
        System.out.println("bubbleSort Sort " + Arrays.toString(myArrDouble));

//        System.out.println("bubbleSort Unsort " + Arrays.toString(myArrInt));
//        bubbleSort(myArrInt);
//        System.out.println("bubbleSort Sort " + Arrays.toString(myArrInt));


    }

    public static void bubbleSort(int[] arrUnsort) {

        int count = 0;

        for (int i = 0; i < arrUnsort.length - 1; i++){
            if (arrUnsort[i] > arrUnsort[i + 1]) {
                int temp = arrUnsort[i];
                arrUnsort[i] = arrUnsort[i + 1];
                arrUnsort[i + 1] = temp;
                count++;
            }
        }
        if (count > 0) {
            bubbleSort(arrUnsort);
        }
    }

    public static void bubbleSortD(Double[] myArrDouble) {

        int count = 0;

        for (int i = 0; i < myArrDouble.length - 1; i++){
            if (myArrDouble[i] > myArrDouble[i + 1]) {
                Double temp = myArrDouble[i];
            myArrDouble[i] = myArrDouble[i + 1];
            myArrDouble[i + 1] = temp;
                count++;
            }
        }
        if (count > 0) {
            bubbleSortD(myArrDouble);
        }
    }

    public static void bubbleSortNoRec(int[] array) {
        boolean unsorted = true;
        int temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    unsorted = true;

                    countLoop++;
                    System.out.println(countLoop + " " + Arrays.toString(array));
                }
            }
        }
    }
}
