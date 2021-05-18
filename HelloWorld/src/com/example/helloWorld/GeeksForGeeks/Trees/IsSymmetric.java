package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/symmetric-tree/1#

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class IsSymmetric {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);

            if(isSymmetric(root) == true)
                System.out.println("True");
            else
                System.out.println("False");

            t--;

        }
    }
    private static boolean isSymmetric(Node root)
    {
        return isMirror(root, root);
    }
    private static boolean isMirror(Node node1, Node node2){
        if(node1==null && node2==null)
            return true;
        if(node1!=null && node2!=null && node1.data==node2.data){
            return (isMirror(node1.left,node2.right) && isMirror(node1.right, node2.left));
        }
        return false;
    }
}