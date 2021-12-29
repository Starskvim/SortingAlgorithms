import java.util.Arrays;

public class MergeSort {
//    Сортировка слиянием пригодится для таких структур данных, в которых доступ к элементам осуществляется
//    последовательно (например, для потоков). Здесь массив разбивается на две примерно равные части и каждая из них
//    сортируется по отдельности. Затем два отсортированных подмассива сливаются в один.

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


        System.out.println("mergesort Unsort " + Arrays.toString(myArrInt));
        System.out.println("mergesort Sort " + Arrays.toString(mergesort(myArrInt)));


    }

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



}
