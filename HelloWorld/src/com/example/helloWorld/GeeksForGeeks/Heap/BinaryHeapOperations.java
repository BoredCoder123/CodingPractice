package com.example.helloWorld.GeeksForGeeks.Heap;
//https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap/1

import java.util.*;
import java.io.*;

class BinaryHeapOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            MinHeap h = new MinHeap();
            for (int i = 0; i < a; i++) {
                int c = sc.nextInt();
                int n;
                if (c == 1) {
                    n = sc.nextInt();

                    h.insertKey(n);
                }
                if (c == 2) {
                    n = sc.nextInt();
                    h.deleteKey(n);
                }
                if (c == 3) {
                    System.out.print(h.extractMin() + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class MinHeap {
    private static int cur=-1;
    private static int[] minHeap=new int[1000000];
    void insertKey(int n)
    {
        cur++;
        minHeap[cur]=n;
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
    public int extractMin()
    {
        int x=minHeap[0];
        minHeap[0]=minHeap[cur];
        cur--;
        heapify();
        return x;
    }

    public void deleteKey(int x){
        if(x>cur)
            return;
        else{
            minHeap[x]=minHeap[cur];
            cur--;
            heapify();
        }
    }
}

