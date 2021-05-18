package com.example.helloWorld.Sorting;

import com.example.helloWorld.Utils.UtilsClass;

public class SelectionSort {
    public static void callselectionSort(){
//        int[] array={4,2,5,7,1,3};
//        int[] array={1,2,3,4,5,6};
        int[] array={6,5,4,3,2,1};
        UtilsClass.printArray(array);
        array=selectionSort(array);
        UtilsClass.printArray(array);
    }
    private static int[] selectionSort(int[] array){
        int i,j,temp,min;
        for(i=0;i<array.length-1;i++){
            min=i;
            for(j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            if(i!=min){
                temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
        return array;
    }
}
