package com.example.helloWorld.GeeksForGeeks.Heap;
//Heap in java can be implemented via a priority queue
import java.util.Scanner;

public class Heap {
    private static int cur=-1;
    private static int[] maxHeap=new int[1000];

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice(1. Add a new element; 2. Show all elements; 3. Remove top element; 4. Break the loop)");
            int t=sc.nextInt();
            if(t==1){
                System.out.print("Enter the element: ");
                t=sc.nextInt();
                add(t);
            }else if(t==2){
                showAllElements();
            }else if(t==3){
                System.out.println("Remove element is: "+remove());
            }else if(t==4){
                break;
            }else{
                System.out.println("Incorrect choice. Enter again");
            }
        }
    }

    public static void add(int x){
        cur++;
        maxHeap[cur]=x;
        int parentPos=(cur-1)/2;
        int curEle=cur;
        while(curEle>=0){
            if(maxHeap[curEle]>maxHeap[parentPos]){
                int t=maxHeap[curEle];
                maxHeap[curEle]=maxHeap[parentPos];
                maxHeap[parentPos]=t;
                curEle=parentPos;
                parentPos=(curEle-1)/2;
            }else{
                break;
            }
        }
    }

    private static void showAllElements(){
        if(cur==-1){
            System.out.println("No elements in heap.");
            return;
        }
        System.out.println("Displaying all elements: ");
        for(int i=0;i<=cur;i++){
            System.out.print(maxHeap[i]+" ");
        }
        System.out.println(" ");
    }

    private static void heapify(){
        int pos=0, c1pos=(2*pos+1), c2pos=(2*pos+2);
        while(pos<cur){
            if(maxHeap[pos]>=maxHeap[c1pos] && maxHeap[pos]>=maxHeap[c2pos])
                break;
            else{
                if(c2pos<=cur) {
                    if (maxHeap[pos] < maxHeap[c1pos] && maxHeap[pos] < maxHeap[c2pos]) {
                        if (maxHeap[c1pos] > maxHeap[c2pos]) {
                            int t = maxHeap[c1pos];
                            maxHeap[c1pos] = maxHeap[pos];
                            maxHeap[pos] = t;
                            pos=c1pos;
                            c1pos=(2*pos+1); c2pos=(2*pos+2);
                        } else {
                            int t = maxHeap[c2pos];
                            maxHeap[c2pos] = maxHeap[pos];
                            maxHeap[pos] = t;
                            pos=c2pos;
                            c1pos=(2*pos+1); c2pos=(2*pos+2);
                        }
                    } else if (maxHeap[pos] < maxHeap[c1pos]) {
                        int t = maxHeap[c1pos];
                        maxHeap[c1pos] = maxHeap[pos];
                        maxHeap[pos] = t;
                        pos=c1pos;
                        c1pos=(2*pos+1); c2pos=(2*pos+2);
                    } else {
                        int t = maxHeap[c2pos];
                        maxHeap[c2pos] = maxHeap[pos];
                        maxHeap[pos] = t;
                        pos=c2pos;
                        c1pos=(2*pos+1); c2pos=(2*pos+2);
                    }
                }else if(c1pos<=cur){
                    if (maxHeap[pos] < maxHeap[c1pos]) {
                        int t = maxHeap[c1pos];
                        maxHeap[c1pos] = maxHeap[pos];
                        maxHeap[pos] = t;
                        pos=c1pos;
                        c1pos=(2*pos+1); c2pos=(2*pos+2);
                    }
                }else{
                    return;
                }
            }
        }
    }

    public static int remove(){
        if(cur==-1){
            System.out.println("Cannot remove any element as heap is empty. Will return -1");
            return -1;
        }
        int x=maxHeap[0];
        maxHeap[0]=maxHeap[cur];
        cur--;
        heapify();
        return x;
    }
}