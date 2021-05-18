package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class BalancedTree {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = Node.buildTree(s);

            if (isBalanced(root) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }
    private static boolean isBalanced(Node root)
    {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if(root.right!=null){
            if(root.left==null && (root.right.left!=null || root.right.right!=null))
                return false;
        }
        if(root.left!=null){
            if(root.right==null && (root.left.left!=null || root.left.right!=null))
                return false;
        }
        return (isBalanced(root.right) && isBalanced(root.left));
    }
}