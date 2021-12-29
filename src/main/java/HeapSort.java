import java.util.Arrays;

public class HeapSort {
//    При этой сортировке сначала строится пирамида из элементов исходного массива. Пирамида (или двоичная куча) — это
//    способ представления элементов, при котором от каждого узла может отходить не больше двух ответвлений.
//    А значение в родительском узле должно быть больше значений в его двух дочерних узлах.
//    Пирамидальная сортировка похожа на сортировку выбором, где мы сначала ищем максимальный элемент, а затем помещаем
//    его в конец. Дальше нужно рекурсивно повторять ту же операцию для оставшихся элементов.

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

        System.out.println("HeapSort Unsort " + Arrays.toString(myArrInt));
        sort(myArrInt);
        System.out.println("HeapSort Sort " + Arrays.toString(myArrInt));

    }

    public static void sort(int arr[])
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }

        countLoop++;
        System.out.println(countLoop + " - " + Arrays.toString(arr));
    }


}
