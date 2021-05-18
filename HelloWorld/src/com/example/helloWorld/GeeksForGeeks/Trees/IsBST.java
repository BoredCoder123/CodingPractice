package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/check-for-bst/1#

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class IsBST {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);
            if(isBST(root))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

    private static boolean isBST(Node root)
    {
        return isbst(root, null, null);
    }
    private static boolean isbst(Node root, Node l, Node r){
        if(root==null)
            return true;

        if(l!=null && root.data <= l.data)
            return false;
        if(r!=null && root.data >= r.data)
            return false;

        return isbst(root.left, l, root) && isbst(root.right, root, r);
    }
}