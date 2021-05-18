package com.example.helloWorld.GeeksForGeeks.Heap;
//https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1#
import java.util.*;

class Node{
    public int data;
    public Node next;
    Node(int n){
        data=n;
        next=null;
    }
}

public class MergeKSortedList {

    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Node []a = new Node[N];

            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();

                Node head = new Node(sc.nextInt());
                Node tail = head;

                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }

                a[i] = head;
            }

            MergeKSorList g = new MergeKSorList();

            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}

class MergeKSorList
{
    Node mergeKList(Node[]arr,int K)
    {
        Node head=null, last=null;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){        //This is a heap
            public int compare(Node a, Node b){
                return a.data - b.data;
            }
        });
        for(int i=0;i<K;i++){
            if(arr[i]!=null)
                pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            Node temp=pq.poll();
            if(temp.next!=null)
                pq.add(temp.next);

            if(head==null){
                head=temp;
                last=head;
            }else{
                last.next=temp;
                last=temp;
            }
        }
        return head;
    }
}
