package com.example.helloWorld.Sorting;

public class BubbleSort {
    public static void callBubbleSort(){
//        int array[]= {4,2,5,1,7,9};
        int array[]={1,2,3,4,5,6};
        BubbleSort.printArray(array);
//        array=BubbleSort.bubbleSort(array);
        array=BubbleSort.bubbleSortAdaptive(array);
        BubbleSort.printArray(array);
    }

    private static void printArray(int[] array){
        int i;
        for(i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }

    private static int[] bubbleSort(int[] array){
        int temp=0, i, j;
        for(i=0;i<array.length-1;i++){
            for(j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    private static int[] bubbleSortAdaptive(int[] array){
        int temp=0, i, j;
        Boolean isSorted=true;
        for(i=0;i<array.length-1;i++){
            System.out.println("Running pass number "+(i+1));
            isSorted=true;
            for(j=0;j<array.length-1-i; j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    isSorted=false;
                }
            }
            if(isSorted){break;}
        }
        return array;
    }
}
