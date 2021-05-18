package com.example.helloWorld;

import com.example.helloWorld.Utils.UtilsClass;

public class Temp {
    public static void callTemp(){
//        int[] array={1,2,3,4,5};          //For moveNElements
//        array=Temp.moveNElements(array, 1);          //For moveNElements
//        UtilsClass.printArray(array);          //For moveNElements

        Temp.correctPosition();         //For correct position
    }
    private static int[] moveNElements(int[] array, int pos){ //This is being written as a module of insertion sort
        int i, temp;
        temp=array[array.length-1];
        for(i=array.length-2;i>=pos-1;i--){
            array[i+1]=array[i];
        }
        array[i+1]=temp;
        return array;
    }

    private static void correctPosition(){ //This is being written as a module of insertion sort
        int i, temp=8;
        int[] array={1,2,3,4,5,6,7};
        for(i=0;i<array.length;i++){
            if(array[i]>temp){
                break;
            }
        }
        System.out.println(i+1);
    }
}
