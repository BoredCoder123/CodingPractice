package com.example.helloWorld.InterviewQuestions.DP;

import java.util.Arrays;

public class BoxStacking {
    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);
        System.out.println(boxStacking(arr));
    }

    private static int boxStacking(Box[] arr) {
        int n=arr.length, i, j;
        Box[] rot = new Box[n*3];
        for(i=0;i<n;i++){
            Box box = arr[i];
            rot[i*3]=new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));
            rot[i*3+1]=new Box(box.w, Math.max(box.h, box.d), Math.min(box.h, box.d));
            rot[i*3+2]=new Box(box.d, Math.max(box.w, box.h), Math.min(box.w, box.h));
        }
        Arrays.sort(rot);
        int c=3*n;
        int[] msh = new int[c];
//        for(i=0;i<c;i++){
//            msh[i]=rot[i].h;
//        }
        for(i=0;i<c;i++){
            msh[i]=0;
            Box box= rot[i];
            int val=0;
            for(j=0;j<i;j++){
                Box prevBox=rot[j];
                if(box.w<prevBox.w && box.d<prevBox.d)
                    val=Math.max(val, msh[j]);
            }
            msh[i]=val+box.h;
        }
        int max=0;
        for(i=0;i<c;i++)
            max=Math.max(max, msh[i]);
        return max;
    }

    private static class Box implements Comparable<Box>{
        int h, w, d, area;
        public Box(int h, int w, int d){
            this.h=h;
            this.w=w;
            this.d=d;
            this.area=w*d;
        }

        @Override
        public int compareTo(Box o) {
            return o.area-this.area;
        }
    }
}
