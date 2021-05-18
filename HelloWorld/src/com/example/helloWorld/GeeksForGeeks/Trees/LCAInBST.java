package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class LCAInBST {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        //Scanner sc = new Scanner(System.in);
        while (t > 0) {
            String s = br.readLine();
            Node root = Node.buildTree(s);
            String X = br.readLine();
            String arr[] = X.split(" ");
            int x, y;
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            System.out.println(LCA(root, x, y).data);
            t--;

        }
    }

    private static Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data > n1 && root.data > n2)
            return LCA(root.left, n1, n2);
        else if (root.data < n1 && root.data < n2)
            return LCA(root.right, n1, n2);
        else
            return root;
    }
}