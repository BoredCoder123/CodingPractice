package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1#
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

public class BinaryTreeToDoublyLinkedList {

    public static void main(String args[])  throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);

            Node ans = bToDLL(root);
            printList(ans);
            t--;
            System.out.println();
        }


    }
    static Node head;
    static Node prev=null;
    private static Node bToDLL(Node root)
    {
        temp(root);
        return head;
    }
    private static void temp(Node root){
        if(root==null)
            return;
        bToDLL(root.left);
        if(prev==null){
            head=root;
        }else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        bToDLL(root.right);
    }
    public static void printList(Node head)
    {
        Node prev = head;
        while (head != null)
        {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while(prev != null)
        {
            System.out.print(prev.data+" ");
            prev = prev.left;
        }
    }
}