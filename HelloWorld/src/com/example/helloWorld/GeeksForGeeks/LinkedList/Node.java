package com.example.helloWorld.GeeksForGeeks.LinkedList;

public class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x){
        data=x;
        next=null;
        bottom=null;
    }

    Node(){
        data=0;
        next=null;
        bottom=null;
    }

    public static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}