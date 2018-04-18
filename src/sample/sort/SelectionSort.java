package sample.sort;

public class SelectionSort {

    public void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
        // Assume first element is min

            int min = i;


            for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;

                }
            }
            if (min != i) {
                final int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            System.out.println(arr[i]);// I print the in ascending order
        }
    }

}
