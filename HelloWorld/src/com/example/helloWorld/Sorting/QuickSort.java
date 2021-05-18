package com.example.helloWorld.Sorting;

import com.example.helloWorld.Utils.UtilsClass;

public class QuickSort {
    public static void callQuicksort(){
        int[] array={4,2,5,1,3};
//        int[] array={1,2,3,4,5};
//        int[] array={5,4,3,2,1};
        UtilsClass.printArray(array);
        quickSort(array, 0, array.length-1);
        UtilsClass.printArray(array);
    }

    private static int partition(int a[], int beg, int end)
    {

        int left, right, temp, loc, flag;
        loc = left = beg;
        right = end;
        flag = 0;
        while(flag != 1)
        {
            while((a[loc] <= a[right]) && (loc!=right))
                right--;
            if(loc==right)
                flag =1;
            else if(a[loc]>a[right])
            {
                temp = a[loc];
                a[loc] = a[right];
                a[right] = temp;
                loc = right;
            }
            if(flag!=1)
            {
                while((a[loc] >= a[left]) && (loc!=left))
                    left++;
                if(loc==left)
                    flag =1;
                else if(a[loc] <a[left])
                {
                    temp = a[loc];
                    a[loc] = a[left];
                    a[left] = temp;
                    loc = left;
                }
            }
        }
        return loc;
    }
    private static void quickSort(int a[], int beg, int end)
    {

        int loc;
        if(beg<end)
        {
            loc = partition(a, beg, end);
            quickSort(a, beg, loc-1);
            quickSort(a, loc+1, end);
        }
    }
}
