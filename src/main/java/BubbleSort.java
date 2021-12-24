

public class BubbleSort {
    int count = 0;

    public void bubbleSort(int[] arrUnsort) {

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

    public void bubbleSortD(Double[] myArrDouble) {
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
}
