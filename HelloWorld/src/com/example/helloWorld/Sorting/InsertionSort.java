package com.example.helloWorld.Sorting;

import com.example.helloWorld.Utils.UtilsClass;

public class InsertionSort {
    public static void callInsertionSort(){
        int array[]= {5,7,2,8,5,3};
//        int array[]= {6,5,4,3,2,1};
//        int array[]= {1,2,3,4,5,6};
        System.out.println(array.length);
        UtilsClass.printArray(array);
        array=insertionSort(array);
        UtilsClass.printArray(array);
    }

//    private static int[] insertionSort(int[] array){
//        int i,j,k,temp;
//        for(i=1;i<array.length;i++){
//            temp=array[i];
//            for(j=0;j<i;j++){
//                if(array[j]>temp) break;
//            }
//            if(i==j) continue;
//            else{
//                for(k=i-1;k>=j;k--){
//                    array[k+1]=array[k];
//                }
//                array[k+1]=temp;
//            }
//        }
//        return array;
//    }

    private static int[] insertionSort(int[] array){
        int i,j,key;
        for(i=1;i<array.length;i++){
            key=array[i];
            j=i-1;
            while(j>=0 && array[j]>key){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }
        return array;
    }
}
