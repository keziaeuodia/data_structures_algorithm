package sample.sort;

import java.util.ArrayList;

public class BubbleSort <E extends Number>{

    public E[] bubbleSort(E[] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j].doubleValue() > array[j+1].doubleValue()) {
                    E temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public void print(E[] array){
        for (E e : array) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {

        Integer [] array = {889, 56, 80, 54, 32, 28, 10, 95, 45, 31};

        BubbleSort test = new BubbleSort();

        test.bubbleSort(array);
        test.print(array);

    }

}
