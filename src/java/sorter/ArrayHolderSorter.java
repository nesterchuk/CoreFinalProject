package sorter;

import java.util.Arrays;

public class ArrayHolderSorter {

    public int[] standardMethod(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public int[] bubbleSortUp(int[] array) {
        boolean changes;
        do {
             changes = false;
             for (int i = 0; i < array.length-1; i++) {
                  if (array[i] > array[i + 1]) {
                      int temp = array[i + 1];
                      array[i + 1] = array[i];
                      array[i] = temp;
                      changes=true;
                  }
             }
        }while (changes);
        return array;
    }

    public int[] bubbleSortDown(int[] array){
        boolean changes;
        do {
             changes = false;
             for (int i = array.length-1; i > 0; i--){
                  if (array[i] < array[i - 1]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    changes=true;
                  }
             }
        }while (changes);
        return array;
    }



    public int[] mergeSort(int[] array) {

        if (array.length < 2) {
            return array;
        }
        int m = array.length / 2;
        int[] arrayLeft = mergeSort(Arrays.copyOfRange(array, 0, m));
        int[] arrayRight = mergeSort(Arrays.copyOfRange(array, m, array.length));

        int n = arrayLeft.length + arrayRight.length;
        int[] mergeArray = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arrayLeft.length) {
                mergeArray[i] = arrayRight[i2++];
            } else if (i2 == arrayRight.length) {
                mergeArray[i] = arrayLeft[i1++];
            } else {
                if (arrayLeft[i1] < arrayRight[i2]) {
                    mergeArray[i] = arrayLeft[i1++];
                } else {
                    mergeArray[i] = arrayRight[i2++];
                }
            }
        }
        return mergeArray;
    }
}

