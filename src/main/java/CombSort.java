import java.util.Arrays;

public class CombSort {

//    Сортировка расчёской — улучшение сортировки пузырьком. Её идея состоит в том, чтобы «устранить» элементы
//    с небольшими значения в конце массива, которые замедляют работу алгоритма. Если при пузырьковой и шейкерной
//    сортировках при переборе массива сравниваются соседние элементы, то при «расчёсывании» сначала берётся достаточно
//    большое расстояние между сравниваемыми значениями, а потом оно сужается вплоть до минимального.

//    Первоначальный разрыв нужно выбирать не случайным образом, а с учётом специальной величины — фактора уменьшения,
//    оптимальное значение которого равно 1,247. Сначала расстояние между элементами будет равняться размеру массива,
//    поделённому на 1,247; на каждом последующем шаге расстояние будет снова делиться на фактор уменьшения — и так до
//    окончания работы алгоритма.

    private static int countLoop;

    public static void main(String[] args) {

        int n = 25;

        Integer[] myArrInteger = new Integer[n];
        for (int i = 0; i < n; i++) {
            Integer number = ((int) ((Math.random() * 100) + 10));
            myArrInteger[i] = number;
        }

        System.out.println("combSort Unsort " + Arrays.toString(myArrInteger));
        combSort(myArrInteger);
        System.out.println("combSort Sort " + Arrays.toString(myArrInteger));

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
}
