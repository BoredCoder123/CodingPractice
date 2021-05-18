package com.example.helloWorld.GeeksForGeeks.Heap;
//https://practice.geeksforgeeks.org/problems/heap-sort/1#
// { Driver Code Starts
import java.util.*;
class HeapSort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        HeapSort hs = new HeapSort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();

            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }

}


// } Driver Code Ends




class Solution
{
    private static int cur=-1;
    private static int[] minHeap=new int[1000000];
    void buildHeap(int arr[], int n)
    {
        for(int i=0;i<n;i++){
            cur++;
            minHeap[cur]=arr[i];
            int parentPos=(cur-1)/2;
            int curEle=cur;
            while(curEle>=0){
                if(minHeap[curEle]<minHeap[parentPos]){
                    int t=minHeap[curEle];
                    minHeap[curEle]=minHeap[parentPos];
                    minHeap[parentPos]=t;
                    curEle=parentPos;
                    parentPos=(curEle-1)/2;
                }else{
                    break;
                }
            }
        }
    }

    void heapify()
    {
        int pos=0, c1pos=(2*pos+1), c2pos=(2*pos+2);
        while(pos<cur){
            if(minHeap[pos]<=minHeap[c1pos] && minHeap[pos]<=minHeap[c2pos])
                break;
            else{
                if(c2pos<=cur) {
                    if (minHeap[pos] > minHeap[c1pos] && minHeap[pos] > minHeap[c2pos]) {
                        if (minHeap[c1pos] < minHeap[c2pos]) {
                            int t = minHeap[c1pos];
                            minHeap[c1pos] = minHeap[pos];
                            minHeap[pos] = t;
                            pos=c1pos;
                            c1pos=(2*pos+1); c2pos=(2*pos+2);
                        } else {
                            int t = minHeap[c2pos];
                            minHeap[c2pos] = minHeap[pos];
                            minHeap[pos] = t;
                            pos=c2pos;
                            c1pos=(2*pos+1); c2pos=(2*pos+2);
                        }
                    } else if (minHeap[pos] > minHeap[c1pos]) {
                        int t = minHeap[c1pos];
                        minHeap[c1pos] = minHeap[pos];
                        minHeap[pos] = t;
                        pos=c1pos;
                        c1pos=(2*pos+1); c2pos=(2*pos+2);
                    } else {
                        int t = minHeap[c2pos];
                        minHeap[c2pos] = minHeap[pos];
                        minHeap[pos] = t;
                        pos=c2pos;
                        c1pos=(2*pos+1); c2pos=(2*pos+2);
                    }
                }else if(c1pos<=cur){
                    if (minHeap[pos] > minHeap[c1pos]) {
                        int t = minHeap[c1pos];
                        minHeap[c1pos] = minHeap[pos];
                        minHeap[pos] = t;
                        pos=c1pos;
                        c1pos=(2*pos+1); c2pos=(2*pos+2);
                    }
                }else{
                    return;
                }
            }
        }
    }

    public void heapSort(int arr[], int n)
    {
        buildHeap(arr, n);
        for(int i=0;i<n;i++)
            System.out.println(minHeap[i]);
        for(int i=0;i<n;i++){
            arr[i]=minHeap[0];
            System.out.println(arr[i]);
            minHeap[0]=minHeap[cur];
            cur--;
            heapify();
        }
    }
}