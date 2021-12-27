import java.util.Arrays;

public class main {

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


//        System.out.println("bubbleSort Unsort " + Arrays.toString(myArrDouble));
//        bubbleSortD(myArrDouble);
//        System.out.println("bubbleSort Sort " + Arrays.toString(myArrDouble));
//
//        System.out.println("bubbleSort Unsort " + Arrays.toString(myArrInt));
//        bubbleSort(myArrInt);
//        System.out.println("bubbleSort Sort " + Arrays.toString(myArrInt));

//        System.out.println("shakerSort Unsort " + Arrays.toString(myArrInt));
//        shakerSort(myArrInt);
//        System.out.println("shakerSort Sort " + Arrays.toString(myArrInt));

//        System.out.println("combSort Unsort " + Arrays.toString(myArrInteger));
//        combSort(myArrInteger);
//        System.out.println("combSort Sort " + Arrays.toString(myArrInteger));

//        System.out.println("shakerSort Unsort " + Arrays.toString(myArrInt));
//        insertionSort(myArrInt);
//        System.out.println("shakerSort Sort " + Arrays.toString(myArrInt));

//        System.out.println("selectionSort Unsort " + Arrays.toString(myArrInt));
//        selectionSort(myArrInt);
//        System.out.println("selectionSort Sort " + Arrays.toString(myArrInt));

//        System.out.println("quickSort Unsort " + Arrays.toString(myArrInt));
//        quickSort(myArrInt, 0, myArrInt.length - 1);
//        System.out.println("quickSort Sort " + Arrays.toString(myArrInt));

        System.out.println("mergesort Unsort " + Arrays.toString(myArrInt));
        System.out.println("mergesort Sort " + Arrays.toString(mergesort(myArrInt)));

    }

    public static void bubbleSort(int[] arrUnsort) {

        int count = 0;

        for (int i = 0; i < arrUnsort.length - 1; i++) {
            if (arrUnsort[i] > arrUnsort[i + 1]) {
                int temp = arrUnsort[i];
                arrUnsort[i] = arrUnsort[i + 1];
                arrUnsort[i + 1] = temp;
                count++;

                countLoop++;
                System.out.println(countLoop + " " + Arrays.toString(arrUnsort));
            }
        }
        if (count > 0) {
            bubbleSort(arrUnsort);
        }
    }

    public static void bubbleSortD(Double[] myArrDouble) {
        int count = 0;

        for (int i = 0; i < myArrDouble.length - 1; i++) {
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

    public static <E extends Comparable<? super E>> void combSort(E[] input) {
        int gap = input.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swapped = false;
            while (i + gap < input.length) {

                if (input[i].compareTo(input[i + gap]) > 0) {
                    E t = input[i];
                    input[i] = input[i + gap];
                    input[i + gap] = t;
                    swapped = true;
                }
                i++;

                countLoop++;
                System.out.println(countLoop + " - " + Arrays.toString(input));
            }
        }
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

    /////////////////////////////////////////
    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);

        int[] buffer2 = new int[array1.length];

        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);

        return result;
    }

    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
    ///////////////////////////////////////

}
