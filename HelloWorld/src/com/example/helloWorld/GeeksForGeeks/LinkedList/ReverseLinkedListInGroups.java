package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//Stack can be used for better optimization
import java.util.*;
import java.lang.*;

public class ReverseLinkedListInGroups {

    static Node head;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }

            int k = sc.nextInt();
            Node res = reverse(head, k);
            Node.printList(res);
            System.out.println();
        }
    }

    public static Node reverse(Node node, int k)
    {
        if(node==null || node.next==null)
            return node;
        int len=1;
        Node curr=node;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        int[] arr=new int[len-1];
        arr[0]=node.data;
        curr=node;
        for(int i=1;i<len-1;i++){
            curr=curr.next;
            arr[i]=curr.data;
        }
        arr=reverseInGroups(arr, len-1,k);
        // for(int i=0;i<len-1;i++){
        //     System.out.println(arr[i]);
        // }
        node.data=arr[0];
        node.next=null;
        curr=node;
        for(int i=1;i<len-1;i++){
            Node temp=new Node(1);
            temp.data=arr[i];
            curr.next=temp;
            temp.next=null;
            curr=temp;
        }
        return node;
    }

    private static int[] reverseInGroups(int[] temp, int n, int k) {
        int[] rev=new int[n];
        int i, j, z;
        for(i=k;i<n;i+=k){
            for(j=0;j<k;j++){
                rev[i-k+j]=temp[i-j-1];
            }
        }
        // System.out.println(i+" "+k+" "+n);
        if(i-k==n-1){
            rev[n-1]=temp[n-1];
        }else{
            z=0;
            for(i=i-k;i<n;i++){
                // System.out.println(i+" "+z+" "+(n-1-z));
                rev[n-1-z]=temp[i];
                z++;
            }
        }
        return rev;
    }
}
